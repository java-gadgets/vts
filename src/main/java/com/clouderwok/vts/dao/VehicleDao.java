package com.clouderwok.vts.dao;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.clouderwok.vts.bean.Vehicle;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class VehicleDao {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Value("${vts.store.file}")
	private File vehicleStoreFile;
	
	public Map<String, Vehicle> getVehicles() throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(vehicleStoreFile, new TypeReference<Map<String, Vehicle>>(){});
	}
	
	public void saveVehicles(Map<String, Vehicle> vehicles) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println(objectMapper.writeValueAsString(vehicles));
		objectMapper.writeValue(vehicleStoreFile, vehicles);
	}
	
}
