package com.clouderwok.vts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		/*
		ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(2);
		MarsboxElectricVehicleTerminal mevt = new MarsboxElectricVehicleTerminal("odbsntest1", new Position(116.450179D, 39.973767D));
		mevt.startup(scheduledExecutorService);
		mevt = new MarsboxElectricVehicleTerminal("test2", new Position(116.450179D, 39.973767D));
		mevt.startup(scheduledExecutorService);
		*/
	}
}
