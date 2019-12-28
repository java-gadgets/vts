package com.clouderwok.vts.bean;

import java.util.Date;

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
	
	public static ElectricVehicleData getDefault(Position position) {
		ElectricVehicleData data = new ElectricVehicleData();
		data.setDate(new Date());
		data.setKeyStatus(1);//1：OFF 2：ON 255：未知
		data.setDoorStatus(0);//0关闭，1未关闭
		data.setGearStatus(1);//1:P档，2：R档，3：N档，4：D档，255：未知
		data.setSpeed(0.0);
		data.setOdo(1000);
		data.setBatteryVoltage(24.0D);
		data.setVoltage(0.0D);
		data.setElectricity(0.0D);
		data.setBatteryPercent(80.0D);
		data.setEnduranceMileage(150);
		data.setChargingState(0);//0未充电，1充电中
		data.setNsv(0);
		data.setPositioningState(1);//0：未定位，1:已定位
		data.setEsc(6);
		data.setPostion(position);
		return data;
	}
	
}
