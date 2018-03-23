package com.clouderwok.vts.bean;

public class Vehicle {
	
	private String plate;
	private String sn;
	/**
	 * 随系统启动 0:不启动, 1：启动
	 */
	private int autoStartup;
	private Position position;
	
	public Vehicle() {
		super();
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public int getAutoStartup() {
		return autoStartup;
	}

	public void setAutoStartup(int autoStartup) {
		this.autoStartup = autoStartup;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
