package com.MavenProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class OR {
	static Logger log = Logger.getLogger(OR.class) ;
	public static String getProperty(String obj) {
		FileInputStream fis = null ;
		try {
			fis = new FileInputStream("./OR.properties") ;
		} catch (FileNotFoundException e) {
			System.out.println(obj+" path not found");
			log.error(obj+" path not found");			
		}
		Properties prop = new Properties() ;		
		try {
			prop.load(fis);
		} catch (IOException e) {			
			System.out.println("File format is not correct.");
			log.error("File format is not correct.");
		}
		String path = prop.getProperty(obj) ;
		return path ;
	}
	

}
