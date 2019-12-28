package com.clouderwok.vts.dao;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.clouderwok.vts.bean.ElectricVehicleData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ElectricVehicleDataDao {
	public static final String DATA_FILE_POSTFIX = ".jd";
	
	@Value("${vts.store.path}")
	private File storePath;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Map<String, ElectricVehicleData> cache;
	
	@PostConstruct
	private void init() {
		cache = new HashMap<>();
		if (storePath.exists()) {
			File[] files = storePath.listFiles((dir, name)-> name.endsWith(DATA_FILE_POSTFIX));
			if (files != null && files.length > 0) {
				Stream.of(files).filter(file->file.isFile()).forEach(file->{
					try {
						ElectricVehicleData vehicleData = objectMapper.readValue(file, ElectricVehicleData.class);
						if (vehicleData != null) {
							String filename = file.getName();
							String sn = filename.substring(0, filename.length() - 3);
							cache.put(sn, vehicleData);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
			}
		} else {
			storePath.mkdirs();
		}
	}
	
	public void save(String sn, ElectricVehicleData electricVehicleData) {
		
	}
}
