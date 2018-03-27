package com.clouderwok.vts.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clouderwok.vts.utils.Constant;
import com.clouderwok.vts.utils.ResHelper;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class SystemController {
	
	@GetMapping
	public Map<String, Object> getVersion() {
		return ResHelper.success(Constant.SYSTEM_INFO);
	}
	
}
