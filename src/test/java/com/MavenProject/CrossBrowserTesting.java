package com.MavenProject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class CrossBrowserTesting 
{	
	static Logger log = Logger.getLogger(CrossBrowserTesting.class) ;		
	
	@Parameters(value="browserType")
	@BeforeMethod
	public void launchApplication(String browserType)
	{
		Keyword.launchApplication(browserType, "http://demo.automationtesting.in/Register.html");				
	}
	
	@Test
	public void Test1() throws InterruptedException
	{	
		log.info("TestCase 1 is started for execution.");
		Keyword.navigate("SwitchTo", "Alerts");
		WebElement actual = Keyword.dr.findElement(By.xpath("//*[@id='OKTab']/button")) ;
		Keyword.CMPValidatior("Button", "enabled", actual, "true");
		log.info("TestCase 1 is executed.");
	}
	
	@Test(enabled=false)
	public void Test2() throws InterruptedException
	{	
		log.info("TestCase 2 is started for execution.");
		Keyword.navigate("SwitchTo", "Windows");
		WebElement actual = Keyword.dr.findElement(By.xpath("//*[@id='Tabbed']/a/button")) ;
		Keyword.CMPValidatior("Button", "label", actual, "clicke");	
		log.info("TestCase 2 is executed.");
	}
	
	
	@AfterMethod
	public void tearOut()
	{		
		Keyword.dr.quit();
		log.info("Application closed.");
		
	}

}
