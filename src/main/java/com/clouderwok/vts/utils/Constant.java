package com.clouderwok.vts.utils;

import java.sql.Timestamp;

public final class Constant {
	
	public static final SystemInfo SYSTEM_INFO = new SystemInfo();
	
	static class SystemInfo {
		public String name = "Vehicle Terminal Simulator(vts)";
		public String version = "0.8.2.0";
		public String startup = new Timestamp(System.currentTimeMillis()).toString();

		public SystemInfo() {
			super();
		}
	}

}
