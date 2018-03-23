package com.clouderwok.vts.lib;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.clouderwok.vts.bean.Vehicle;

public abstract class VehicleTerminal implements Runnable {
	
	protected Vehicle vehicle;
	protected int onInterval = 10;
	protected int offInterval = 60;

	/**
	 * 0:off, 1:on
	 */
	protected int status = 0;
	protected int interval;
	
	private ScheduledExecutorService scheduledExecutorService;
	
	public VehicleTerminal() {
		super();
	}
	
	protected abstract void init();
	
	public abstract void sendRealtimeData();
	
	public abstract void exeCommand(String command, String param);
	
	public final void startup(ScheduledExecutorService scheduledExecutorService) {
		this.scheduledExecutorService = scheduledExecutorService;
		this.interval = this.offInterval;
		this.init();
		scheduledExecutorService.schedule(this, 0, TimeUnit.SECONDS);
	}
	
	public final void shutdown() {
		this.interval = 0;
	}

	@Override
	public void run() {
		if (this.interval > 0) {
			scheduledExecutorService.schedule(this, this.interval, TimeUnit.SECONDS);
		}
		this.sendRealtimeData();
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getOnInterval() {
		return onInterval;
	}

	public void setOnInterval(int onInterval) {
		this.onInterval = onInterval;
	}

	public int getOffInterval() {
		return offInterval;
	}

	public void setOffInterval(int offInterval) {
		this.offInterval = offInterval;
	}

	public int getStatus() {
		return status;
	}

	public int getInterval() {
		return interval;
	}

	public ScheduledExecutorService getScheduledExecutorService() {
		return scheduledExecutorService;
	}
	
}
