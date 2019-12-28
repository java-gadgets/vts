package com.clouderwok.vts.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/vo", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleOperationController {
	
	public Map<String, Object> saveAttrOnPost() {
		return null;
	}
	
}
