package com.inetbanking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	static Properties prop;

	public ConfigDataProvider(String fname) {

		try {
			File fs = new File("./Config/" + fname + ".properties");
			FileInputStream fins = new FileInputStream(fs);

			prop = new Properties();
			prop.load(fins);

		} catch (Exception e) {

			System.out.println("File not found " + e);
		}

	}

	public String getUserName() {

		return prop.getProperty("username");
	}

	public String getUserPassword() {

		return prop.getProperty("password");
	}

	public String getAppURL() {

		return prop.getProperty("URL");
	}

	public String searchKey(String keyname) {

		return prop.getProperty(keyname);
	}
//
//	public static void main(String[] args) {
//
//		ConfigDataProvider configDataProvider = new ConfigDataProvider("config"); // config.properties
//		
//		
//		
//		String uname =configDataProvider.getUserName();
//		String upass = configDataProvider.getUserPassword();
//		
//		String url = configDataProvider.getAppURL();
//		
//		
//		System.out.println(uname+"    "+upass+"    "+url);
//		
//		
//		System.out.println(configDataProvider.searchKey("name"));
//		System.out.println(configDataProvider.searchKey("lastname"));
//		System.out.println(configDataProvider.searchKey("email"));
//	
//	}

}
