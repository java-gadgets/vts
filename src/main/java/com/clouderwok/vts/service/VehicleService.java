package com.clouderwok.vts.service;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clouderwok.vts.bean.Vehicle;
import com.clouderwok.vts.dao.VehicleDao;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleDao vehicleDao;
	
	private Map<String, Vehicle> vehicles;
	
	@PostConstruct
	public void init() {
		try {
			this.vehicles = vehicleDao.getVehicles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Collection<Vehicle> getVehicles() {
		if (vehicles != null) {
			return vehicles.values();
		}
		return null;
	}
	
	public void addVehicle(Vehicle vehicle) throws JsonGenerationException, JsonMappingException, IOException {
		vehicles.put(vehicle.getSn(), vehicle);
		vehicleDao.saveVehicles(vehicles);
	}
	
	public Vehicle getVehicle(String sn) {
		return vehicles.get(sn);
	}
	
	public void removeVehicle(String sn) throws JsonGenerationException, JsonMappingException, IOException {
		if (vehicles.remove(sn) != null ) {
			vehicleDao.saveVehicles(vehicles);
		}
	}
	
}
