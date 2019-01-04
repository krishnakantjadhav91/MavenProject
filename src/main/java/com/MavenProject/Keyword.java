package com.MavenProject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class Keyword {
	public static WebDriver dr ;
	public static Logger log = Logger.getLogger(Keyword.class) ;
	public static void launchApplication(String browserType,String url)	{
		switch (browserType) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", OR.getProperty("chromeDriver")) ;
			dr = new ChromeDriver() ;
			dr.manage().window().maximize();
			dr.get(url);
			dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
			log.info("Application launched on Chrome Browser");
			TakeShot.takeShot("Homepage");	
			break;
		case "firefox" :
			System.setProperty("webdriver.gecko.driver", OR.getProperty("firefoxDriver")) ;
			dr = new FirefoxDriver() ;
			dr.manage().window().maximize();
			dr.get(url);
			dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
			log.info("Application launched on Firefox Browser");
			TakeShot.takeShot("Homepage");
			break;
		case "ie" :
			System.setProperty("webdriver.ie.driver", OR.getProperty("ieDriver")) ;
			dr = new InternetExplorerDriver() ;
			dr.manage().window().maximize();
			dr.get(url);
			dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
			log.info("Application launched on Internet Explorer Browser");
			TakeShot.takeShot("Homepage");
			break;
		default:			
			log.info("Invalid Browser");
			break;
		}
	}

	
	public static void navigate(String obj1, String obj2)	{
		Actions move = new Actions(dr) ; 
		WebElement switchTo = dr.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[4]/a")) ;
		switch (obj1) {
		case "SwitchTo":
			if (obj2.equals("Alerts")){				
				WebElement alert = dr.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[4]/ul/li[1]/a")) ;
				move.moveToElement(switchTo).moveToElement(alert).build().perform();
				alert.click();
				TakeShot.takeShot("Alert Page");
				
			}else if(obj2.equals("Windows")){				
				WebElement windows = dr.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[4]/ul/li[2]/a")) ;
				move.moveToElement(switchTo).moveToElement(windows).build().perform();
				windows.click(); 
				TakeShot.takeShot("Windows Page");
				
			}else if(obj2.equals("Frames")) {				
				WebElement frames = dr.findElement(By.xpath("//*[@id='header']/nav/div/div[2]/ul/li[4]/ul/li[3]/a")) ;
				move.moveToElement(switchTo).moveToElement(frames).build().perform();
				frames.click(); 
				TakeShot.takeShot("Frames Page");
			}
			
			break;

		default:
			break;
		}
		
		
	}

	public static void CMPValidatior(String objectType, String property, WebElement actual, String expected) {		
		if (objectType.equalsIgnoreCase("Label")) {	
			String actualTrim = actual.getText() ;
			if(actualTrim.trim().equals(expected)) {
				System.out.println("TestCase Passed.");
				log.info("Actual Result '"+actual.getText()+"' is matched with Expected Result '"+expected+"'");
				log.info(" TestCase Passed.");
			}else
			{
				System.out.println("TestCase Failed.");
				log.info("Actual Result '"+actual.getText()+"' is not matched with Expected Result '"+expected+"'");
				log.info(" TestCase Failed.");
			}
		}else if (objectType.equalsIgnoreCase("TextBox")) {
			
		}else if (objectType.equalsIgnoreCase("Button")) {
			if (property.equalsIgnoreCase("enabled")) {				
				if (String.valueOf(actual.isEnabled()).equals(expected)) {
					System.out.println("TestCase Passed.");
					log.info("Actual Result '"+actual.isEnabled()+"' is matched with Expected Result '"+expected+"'");
					log.info(" TestCase Passed.");
				}else {
					System.out.println("TestCase Failed.");
					log.info("Actual Result '"+actual.isEnabled()+"' is not matched with Expected Result '"+expected+"'");
					log.info(" TestCase Failed.");					
				}				
				
			}else if (property.equalsIgnoreCase("label")) {
				String actualTrim = actual.getText() ;
				if (actualTrim.trim().equals(expected)) {
					System.out.println("TestCase Passed.");
					log.info("Actual Result '"+actual.getText()+"' is matched with Expected Result '"+expected+"'");
					log.info(" TestCase Passed.");
				}else {
					System.out.println("TestCase Failed.");
					log.info("Actual Result '"+actual.getText()+"' is not matched with Expected Result '"+expected+"'");
					log.info(" TestCase Failed.");					
				}
				
			}
			
			
		}
		
		
		
	}
	

}
