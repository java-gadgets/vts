package com.clouderwok.vts.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.clouderwok.vts.bean.Vehicle;
import com.clouderwok.vts.lib.MarsboxElectricVehicleTerminal;
import com.clouderwok.vts.lib.VehicleTerminal;

@Service
public class VehicleTerminalService {
	
	@Value("${vts.threadPool.size}")
	private int threadPoolSize;
	
	@Value("${vts.vehicle.interval.on}")
	private Integer onInterval;
	
	@Value("${vts.vehicle.interval.off}")
	private Integer offInterval;
	
	@Value("${vts.marsbox.report.url.prefix}")
	private String marsboxUrlPrefix;
	
	private ScheduledExecutorService scheduledExecutorService;
	
	private Map<String, VehicleTerminal> vehicleTerminals = new HashMap<>();
	
	@PostConstruct
	private void init() {
		scheduledExecutorService = new ScheduledThreadPoolExecutor(threadPoolSize);
	}
	
	public void addVehicleTerminal(Vehicle vehicle) {
		if (vehicleTerminals.containsKey(vehicle.getSn())) {
			return;
		}
		MarsboxElectricVehicleTerminal vehicleTerminal = new MarsboxElectricVehicleTerminal();
		vehicleTerminal.setVehicle(vehicle);
		vehicleTerminal.setOnInterval(onInterval);
		vehicleTerminal.setOffInterval(offInterval);
		vehicleTerminal.setUrlPrefix(marsboxUrlPrefix);
		vehicleTerminal.startup(scheduledExecutorService);
		vehicleTerminals.put(vehicle.getSn(), vehicleTerminal);
	}
	
	public void syncVehicleData(Vehicle vehicle) {
		if (!vehicleTerminals.containsKey(vehicle.getSn())) {
			return;
		}
		vehicleTerminals.get(vehicle.getSn()).setVehicle(vehicle);;
	}
	
	public void removeVehicleTerminal(Vehicle vehicle) {
		VehicleTerminal vehicleTerminal = vehicleTerminals.remove(vehicle.getSn());
		if (vehicleTerminal != null) {
			vehicleTerminal.shutdown();
		}
	}
	
	public void removeVehicleTerminals() {
		vehicleTerminals.keySet().forEach(sn -> {
			vehicleTerminals.remove(sn).shutdown();
		});
	}
	
	@PreDestroy
	public void preDestory() { 
		removeVehicleTerminals();
		scheduledExecutorService.shutdown(); 
		try {
			scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		scheduledExecutorService.shutdownNow();
		System.out.println("release scheduledExecutorService resources");
	} 
	
	public void exeCommand(String sn, String command, String param) {
		if (vehicleTerminals.containsKey(sn)) {
			vehicleTerminals.get(sn).exeCommand(command, param);
		} else {
			throw new RuntimeException("vehicle sn not exists");
		}
	}
	
}
