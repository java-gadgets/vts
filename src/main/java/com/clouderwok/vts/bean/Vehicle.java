package com.clouderwok.vts.bean;

public class Vehicle {
	
	private String plate;
	private String sn;
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

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
