package com.clouderwok.vts.bean;

public class Vehicle {
	
	private String plate;
	private String sn;
	/**
	 * 随系统启动 0:不启动（默认）, 1：启动
	 */
	private int autoStartup;
	private Position position;
	
	/**
	 * 指令响应时间，单位秒
	 */
	private int cmdResTime;
	/**
	 * 当cmdResTime > 0时生效
	 * 0不随机（默认）， 1随机(0 ~ cmdResTime)
	 */
	private int cmdResRandom;
	
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

	public int getCmdResTime() {
		return cmdResTime;
	}

	public void setCmdResTime(int cmdResTime) {
		this.cmdResTime = cmdResTime;
	}

	public int getCmdResRandom() {
		return cmdResRandom;
	}

	public void setCmdResRandom(int cmdResRandom) {
		this.cmdResRandom = cmdResRandom;
	}

}
