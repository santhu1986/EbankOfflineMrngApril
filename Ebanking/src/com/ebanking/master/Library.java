package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Library 
{

	public static WebDriver driver;
	public static String Expval,Actval;
	public static FileInputStream FIS;
	public static Properties PR;
	
	public String OpenApp(String URL) throws IOException
	{
		FIS=new FileInputStream("D:\\EbankingmrngMarch\\Ebanking\\src\\com\\ebanking\\properties\\Rep.properties");
		PR=new Properties();
		PR.load(FIS);
		
         Expval="Ranford Bank";
		
		//Launch Firefox
		
		driver=new FirefoxDriver();
		
		//Maximise
		
		driver.manage().window().maximize();
		
		//URL
		
		driver.get(URL);
		
	    Actval=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		
		//Comparision
		
		if (Expval.equalsIgnoreCase(Actval))
	    {
	 	System.out.println("Application Launch succ");	
		}
		else
		{
			System.out.println("Application Failed to Launch");
		}
		
		return "Pass";
	}
	
	public String AdminLgn(String Un,String Pwd) throws InterruptedException
	{
        Expval="Welcome to Admin";
		
		driver.findElement(By.id(PR.getProperty("Uname"))).sendKeys(Un);
		driver.findElement(By.id(PR.getProperty("Pswd"))).sendKeys(Pwd);
		Thread.sleep(3000);
		driver.findElement(By.xpath(PR.getProperty("Lgn"))).click();

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
				return "Pass";
			
		
	}
	
	public String BranchCre() throws InterruptedException
	{
		Expval="Sucessfully";
		
driver.findElement(By.xpath(PR.getProperty("Bbutton"))).click();

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
   //Home
   driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
   return Actval;
	}
	
	public String RoleCre(String Rn,String Rt) throws InterruptedException
	{
	
		Expval="Sucessfully";
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		   Thread.sleep(3000);
		driver.findElement(By.id("btnRoles")).click();
		driver.findElement(By.id("txtRname")).sendKeys(Rn);
		//driver.findElement(By.id("txtRDesc")).sendKeys(Rd);
		Select rt=new Select(driver.findElement(By.id("lstRtypeN")));
		rt.selectByVisibleText(Rt);
		   Thread.sleep(3000);
		driver.findElement(By.id("btninsert")).click();
		Actval=driver.switchTo().alert().getText();
		   Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		   Thread.sleep(3000);
		
	    driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();
		if (Actval.contains(Expval)) 
		{
			System.out.println("Role Craeted");
			}
		else
		{
			System.out.println("Role Already Exist");
		}
		return Actval;
	}

	public void admlgt() throws InterruptedException

	{
		   Thread.sleep(3000);
		 driver.findElement(By.xpath(".//*[@id='Table_02']/tbody/tr/td[3]/a/img")).click();
		 
		 }

	public void Appc()
	{
		 driver.close();
	}
}
