package com.clouderwok.vts.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import com.clouderwok.vts.service.VehicleService;
import com.clouderwok.vts.service.VehicleTerminalService;

public class InitListener implements ApplicationListener<ApplicationReadyEvent>  {

	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
		VehicleService vehicleService = applicationReadyEvent.getApplicationContext().getBean(VehicleService.class);
		final VehicleTerminalService vehicleTerminalService = applicationReadyEvent.getApplicationContext().getBean(VehicleTerminalService.class);
		vehicleService.getVehicles().forEach(vehicle -> {
			if (vehicle.getAutoStartup() == 1) {
				vehicleTerminalService.addVehicleTerminal(vehicle);
			}
		});
	}

}
