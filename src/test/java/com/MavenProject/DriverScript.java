package com.MavenProject;

public class DriverScript 
{	
	public static void main(String[] args)
	{			
		String url = "http://demo.automationtesting.in/Register.html" ;
		Keyword.launchApplication("chrome",url);
	}

}
