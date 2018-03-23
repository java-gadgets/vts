package com.clouderwok.vts.controller;

import java.io.IOException;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clouderwok.vts.bean.MarsboxReceiveMessage;
import com.clouderwok.vts.bean.Vehicle;
import com.clouderwok.vts.service.VehicleService;
import com.clouderwok.vts.service.VehicleTerminalService;
import com.clouderwok.vts.utils.ResHelper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/v1/vt", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleTerminalController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleTerminalService vehicleTerminalService;
	
	private ObjectMapper objectMapper;
	
	@PostMapping(path = "/add/{sn}")
	public Map<String, Object> onPostAdd(@PathVariable(name = "sn", required = true) String sn) {
		Vehicle vehicle = vehicleService.getVehicle(sn);
		if (vehicle == null) {
			return ResHelper.error("invalid sn");
		}
		vehicleTerminalService.addVehicleTerminal(vehicle);
		return ResHelper.success();
	}
	
	@PostMapping(path = "/receive/{msg}/{timestamp}")
	public Map<String, Object> onPostReceive(@PathVariable(name = "msg", required = true) String msg, @PathVariable(name = "timestamp", required = true) String timestamp) throws JsonParseException, JsonMappingException, IOException {
		String message = new String(Base64.decodeBase64(msg), "utf-8");
		MarsboxReceiveMessage marsboxReceiveMessage = objectMapper.readValue(message, MarsboxReceiveMessage.class);
		if (marsboxReceiveMessage != null) {
			vehicleTerminalService.exeCommand(marsboxReceiveMessage.getSn(), marsboxReceiveMessage.getAtcmd(), null);
		}
		return ResHelper.success();
	}
	
}
