package com.clouderwok.vts.bean;

public class ElectricVehicleData extends VehicleData {
	/**
	 * 总电压
	 */
	private Double voltage;
	
	/**
	 * 总电流
	 */
	private Double electricity;
	
	/**
	 * 剩余电量百分比
	 */
	private Double batteryPercent;
	
	/**
	 * 续航里程
	 */
	private Integer enduranceMileage;
	
	/**
	 * 充电状态
	 */
	private Integer chargingState;

	public ElectricVehicleData() {
		super();
	}

	public Double getVoltage() {
		return voltage;
	}

	public void setVoltage(Double voltage) {
		this.voltage = voltage;
	}

	public Double getElectricity() {
		return electricity;
	}

	public void setElectricity(Double electricity) {
		this.electricity = electricity;
	}

	public Double getBatteryPercent() {
		return batteryPercent;
	}

	public void setBatteryPercent(Double batteryPercent) {
		this.batteryPercent = batteryPercent;
	}

	public Integer getEnduranceMileage() {
		return enduranceMileage;
	}

	public void setEnduranceMileage(Integer enduranceMileage) {
		this.enduranceMileage = enduranceMileage;
	}

	public Integer getChargingState() {
		return chargingState;
	}

	public void setChargingState(Integer chargingState) {
		this.chargingState = chargingState;
	}
	
}
