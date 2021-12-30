package xyz.houye.ircbot.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GetProperties {

	Properties props = new Properties();
	Map<String, String> propmap = new HashMap<>();
	
	public GetProperties() {
		
	}
	public GetProperties(String path) {
		try {
			//props.load((InputStream) new BufferedInputStream(new FileInputStream(new File(path))));
			props.load((InputStream) getClass().getClassLoader().getResourceAsStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//printAllproperty(props);
		@SuppressWarnings("rawtypes")
		Enumeration en = props.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String value = props.getProperty(key);
			propmap.put(key,value);
		}
		
	}
	public Map<String, String> getContent() {
//		try {
//			//props.load((InputStream) new BufferedInputStream(new FileInputStream(new File("src/main/resources/config/app.properties"))));
//			props.load((InputStream) getClass().getClassLoader().getResourceAsStream("config/app.properties"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//printAllproperty(props);
//		@SuppressWarnings("rawtypes")
//		Enumeration en = props.propertyNames();
//		while (en.hasMoreElements()) {
//			String key = (String) en.nextElement();
//			String value = props.getProperty(key);
//			propmap.put(key,value);
//		}
		return propmap;
	}
	
	public String getValue(String key) {
		return (String) props.get(key);
	}
	
	private void printAllproperty(Properties props) {

		@SuppressWarnings("rawtypes")
		Enumeration en = props.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String value = props.getProperty(key);
			System.out.println(key + " : " + value);
		}
	}
}
