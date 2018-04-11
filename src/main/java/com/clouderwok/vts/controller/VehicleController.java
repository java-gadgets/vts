package com.clouderwok.vts.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clouderwok.vts.bean.Vehicle;
import com.clouderwok.vts.service.VehicleService;
import com.clouderwok.vts.service.VehicleTerminalService;
import com.clouderwok.vts.utils.ResHelper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping(path = "/v1/vehicle", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleTerminalService vehicleTerminalService;
	
	@GetMapping(path = "/list")
	public Map<String, Object> onGetQuery(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException{
		return ResHelper.success(vehicleService.getVehicles());
	}

	@PostMapping(path="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> onPostSave(@RequestBody Vehicle vehicle) throws JsonGenerationException, JsonMappingException, IOException {
		vehicleService.addVehicle(vehicle);
		if (vehicle.getAutoStartup() == 1) {
			vehicleTerminalService.addVehicleTerminal(vehicle);
		}
		vehicleTerminalService.syncVehicleData(vehicle);
		return ResHelper.success();
	}
	
	@GetMapping(path = "/detail")
	public Map<String, Object> onGetDetail(@PathVariable(name = "sn", required = true) String sn) {
		return ResHelper.success(vehicleService.getVehicle(sn));
	}
	
	@PostMapping(path="/delete")
	public Map<String, Object> onPostDelete(@PathVariable(name = "sn", required = true) String sn) throws JsonGenerationException, JsonMappingException, IOException {
		vehicleService.removeVehicle(sn);
		return ResHelper.success();
	}
	
}
