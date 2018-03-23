package com.clouderwok.vts.lib;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.tomcat.util.codec.binary.Base64;

import com.clouderwok.vts.Util;
import com.clouderwok.vts.bean.ElectricVehicleData;

public class MarsboxElectricVehicleTerminal extends VehicleTerminal {
	
	private ElectricVehicleData data = new ElectricVehicleData();
	
	private String urlPrefix;
	
	public MarsboxElectricVehicleTerminal() {
		super();
	}

	@Override
	public void init() {
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
		data.setPostion(vehicle.getPosition());
	}

	private String getRealtimeData() {
		StringBuilder body = getRealtimeDataBody();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("$E6")
		.append(',').append(vehicle.getSn())
		.append(',').append(24)
		.append(',').append(body.length())
		.append(',').append(body)
		.append("\r\n");
		return stringBuilder.toString();
	}

	private StringBuilder getRealtimeDataBody() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(Util.formateDateTime(data.getDate()))
		.append(',').append(data.getKeyStatus())
		.append(',').append(data.getDoorStatus())
		.append(',').append(data.getGearStatus())
		.append(',').append(data.getSpeed())
		.append(',').append(data.getOdo())
		.append(',').append(data.getBatteryVoltage())
		.append(',').append(data.getVoltage())
		.append(',').append(data.getElectricity())
		.append(',').append(data.getBatteryPercent())
		.append(',').append(data.getEnduranceMileage())
		.append(',').append(data.getChargingState())
		.append(',').append(data.getNsv())
		.append(',').append(data.getPositioningState())
		.append(',').append(data.getEsc())
		.append(',').append(data.getPostion().getLongitude())
		.append(',').append(data.getPostion().getLatitude())
		.append(',').append(data.getPostion().getCourseAngle())
		.append(',').append(0)
		.append(',').append(0);
		return stringBuilder;
	}

	@Override
	public void sendRealtimeData() {
		send(vehicle.getSn(), "24", nextData());
	}

	private String nextData() {
		data.setDate(new Date());
		return getRealtimeData();
	}

	@Override
	public void exeCommand(String command, String param) {
		System.out.println(command);
		
	}

	private void send(String sn, String cmd, String message) {
		try {
			HttpClient httpClient = HttpClients.createDefault();
			String encryptMessage = Base64.encodeBase64URLSafeString(message.getBytes("utf-8"));
			String url = StringUtils.joinWith("/", urlPrefix, sn, new Date().getTime(), cmd, encryptMessage);
			httpClient.execute(new HttpPost(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ElectricVehicleData getData() {
		return data;
	}

	public void setData(ElectricVehicleData data) {
		this.data = data;
	}

	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}
	
}
