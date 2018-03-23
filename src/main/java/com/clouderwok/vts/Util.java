package com.clouderwok.vts;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;

public class Util {
	public final static DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static String formateDateTime(Date date) {
		return DATETIME_FORMATTER.format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
	}
	
	public static String base64Encode(String src) {
		try {
			return Base64.encodeBase64String(src.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Never should throw this exception");
		}
	} 
}
