package com.clouderwok.vts.bean;

import java.util.Date;

public class VehicleData {
	
	/**
	 * 时间
	 */
	private Date date;

	/**
	 * 设备状态
	 */
	private Integer deviceStatus;
	

	/**
	 * 钥匙状态
	 */
	private Integer keyStatus;

	/**
	 * 车门状态
	 */
	private Integer doorStatus;

	/**
	 * 后尾箱状态
	 */
	private Integer trunkStatus;
	
	/**
	 * 车门锁状态
	 */
	private Integer doorLockStatus;
	
	/**
	 * 车窗状态
	 */
	private Integer windowStatus;
	
	/**
	 * 车灯状态
	 */
	private Integer lightStatus;
	
	/**
	 * 档位
	 */
	private Integer gearStatus;
	
	/**
	 * 驻车制动状态
	 */
	private Integer parkBrakeStatus;
	
	/**
	 * 车速
	 */
	private Double speed;
	
	/**
	 * 总里程
	 */
	private Integer odo;
	
	/**
	 * 电瓶电压
	 */
	private Double batteryVoltage;
	
	/**
	 * 网络信号值 Network Signal Value
	 */
	private Integer nsv;
	
	/**
	 * 定位状态
	 */
	private Integer positioningState;
	
	/**
	 * 有效卫星数量 Effective Satellite Count
	 */
	private Integer esc;
	
    /**
     * 位置信息
     */
	private Position postion;
	
	public VehicleData() {
		super();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(Integer deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public Integer getKeyStatus() {
		return keyStatus;
	}

	public void setKeyStatus(Integer keyStatus) {
		this.keyStatus = keyStatus;
	}

	public Integer getDoorStatus() {
		return doorStatus;
	}

	public void setDoorStatus(Integer doorStatus) {
		this.doorStatus = doorStatus;
	}

	public Integer getTrunkStatus() {
		return trunkStatus;
	}

	public void setTrunkStatus(Integer trunkStatus) {
		this.trunkStatus = trunkStatus;
	}

	public Integer getDoorLockStatus() {
		return doorLockStatus;
	}

	public void setDoorLockStatus(Integer doorLockStatus) {
		this.doorLockStatus = doorLockStatus;
	}

	public Integer getWindowStatus() {
		return windowStatus;
	}

	public void setWindowStatus(Integer windowStatus) {
		this.windowStatus = windowStatus;
	}

	public Integer getLightStatus() {
		return lightStatus;
	}

	public void setLightStatus(Integer lightStatus) {
		this.lightStatus = lightStatus;
	}

	public Integer getGearStatus() {
		return gearStatus;
	}

	public void setGearStatus(Integer gearStatus) {
		this.gearStatus = gearStatus;
	}

	public Integer getParkBrakeStatus() {
		return parkBrakeStatus;
	}

	public void setParkBrakeStatus(Integer parkBrakeStatus) {
		this.parkBrakeStatus = parkBrakeStatus;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Integer getOdo() {
		return odo;
	}

	public void setOdo(Integer odo) {
		this.odo = odo;
	}

	public Double getBatteryVoltage() {
		return batteryVoltage;
	}

	public void setBatteryVoltage(Double batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}

	public Integer getNsv() {
		return nsv;
	}

	public void setNsv(Integer nsv) {
		this.nsv = nsv;
	}

	public Integer getPositioningState() {
		return positioningState;
	}

	public void setPositioningState(Integer positioningState) {
		this.positioningState = positioningState;
	}

	public Integer getEsc() {
		return esc;
	}

	public void setEsc(Integer esc) {
		this.esc = esc;
	}

	public Position getPostion() {
		return postion;
	}

	public void setPostion(Position postion) {
		this.postion = postion;
	}

}
