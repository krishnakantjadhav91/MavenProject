package com.MavenProject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeShot 
{
	static Logger log = Logger.getLogger(TakeShot.class) ;
	public static void takeShot(String filename)
	{
		TakesScreenshot shot = (TakesScreenshot)Keyword.dr ;
		File src = shot.getScreenshotAs(OutputType.FILE) ;
		try 
		{
			FileUtils.copyFile(src, new File(OR.getProperty("screenshotPath")+"\\"+filename+"_"+getTime()+".png"));			
		}
		catch (IOException e) 
		{			
			log.error("Path is invalid.");
		}		
	}
	
	public static String getTime()
	{
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy_hh_mm_ss_aa") ;
		
		return format.format(new Date()) ;		
	}

}
