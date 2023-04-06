package com.ebanking.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleNG 
{
     WebDriver driver;
     
	@BeforeMethod
	public void xyz() throws InterruptedException
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
    @Test
	public void abc() throws InterruptedException
	{
		driver.get("http://192.168.1.4/ranford2");
		Thread.sleep(3000);
	}
    
    @Test
	public void bcd() throws InterruptedException
	{
		driver.get("http://192.168.1.4/ranford1");
		Thread.sleep(3000);
	}
	
    @AfterMethod
	public void pqr()
	{
		driver.close();
	}
}
