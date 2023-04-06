package com.ebanking.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Basicscript {

	public static void main(String[] args) throws InterruptedException 
	{
	
		String Expval="Ranford Bank";
		
		//Launch Firefox
		
		WebDriver driver=new FirefoxDriver();
		
		//Maximise
		
		driver.manage().window().maximize();
		
		//URL
		
		driver.get("http://192.168.1.4/ranford2");
		
		String Actval=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		
		//Comparision
		
		if (Expval.equalsIgnoreCase(Actval))
	    {
	 	System.out.println("Application Launch succ");	
		}
		else
		{
			System.out.println("Application Failed to Launch");
		}
		//Get Title
		
		String Tit=driver.getTitle();
		System.out.println(Tit);
		
		//Admin Login
		
		Expval="Welcome to Admin";
		
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='login']")).click();

		Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		
		//Comparision
		
				if (Expval.equalsIgnoreCase(Actval))
			    {
				System.out.println("Admin Login Succ");	
				}
				else
				{
					System.out.println("Admin login failed");
				}
		
		//Branch Creation
				
				Expval="Sucessfully";
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
		
		driver.findElement(By.id("BtnNewBR")).click();
		
		
		driver.findElement(By.id("txtbName")).sendKeys("srnagr1ghfg45fghf7");
		   
		   driver.findElement(By.id("txtAdd1")).sendKeys("hdfcbank");
		   
		   driver.findElement(By.xpath(".//*[@id='txtZip']")).sendKeys("50003");
		   Thread.sleep(3000);
		  
		   //DropDown
		   
		   Select cntry =new Select(driver.findElement(By.xpath(".//*[@id='lst_counrtyU']")));
		   cntry.selectByVisibleText("INDIA");
		   
		   Select state = new Select(driver.findElement(By.xpath(".//*[@id='lst_stateI']")));
		   state.selectByVisibleText("Delhi");
		   
		   Select city = new Select(driver.findElement(By.xpath(".//*[@id='lst_cityI']")));
		   city.selectByVisibleText("Delhi");
		   
		   Thread.sleep(3000);
		   
		   driver.findElement(By.xpath(".//*[@id='btn_insert']")).click();
		   Thread.sleep(3000);  
		
		//Alert	
		
		   Actval=driver.switchTo().alert().getText();
		   
		   //Comparision
		   
		   if (Actval.contains(Expval)) 
		   {
			System.out.println("Branch Created");
	    	}
		   else
		   {
			   System.out.println("Branch Already exist");
		   }
		   
		   driver.switchTo().alert().accept();
	}

	
}
