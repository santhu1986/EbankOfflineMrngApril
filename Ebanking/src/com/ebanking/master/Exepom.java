package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exepom
{
	
	WebDriver driver;
	
    @BeforeTest
	public void Alogin() throws InterruptedException
	{
		
    	driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.1.4/ranford2");
		
		//Login
		  
		RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
	    RHP.Login();
	    
	}
	@Test
    public void Rolecre() throws InterruptedException, IOException
    {
		
FileInputStream FIS=new FileInputStream("D:\\EbankingmrngMarch\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
		
		//WorkBook
		
		XSSFWorkbook WB=new XSSFWorkbook(FIS);
		
		//Sheet
		
		XSSFSheet WS=WB.getSheet("RData");
		
		//Row Count
		
		int Rcount=WS.getLastRowNum();
		
		//Multiple Iterations
		
		for (int i=1;i<=Rcount;i++)
		{
	
			//Rows
			
			XSSFRow WR=WS.getRow(i);
			
			//Cell
			
			XSSFCell WC=WR.getCell(0);
			XSSFCell WC1=WR.getCell(1);
			
			XSSFCell WC2=WR.createCell(2);
			
			//Cell values
			
			String Rname=WC.getStringCellValue();
			String Rty=WC1.getStringCellValue();
			
	    
	    AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
	    AHP.Rol();
	    Thread.sleep(3000);
	    //New Role
	    Thread.sleep(3000);
	    Roledetails RD=PageFactory.initElements(driver,Roledetails.class);
	    RD.Nrole();
	    Thread.sleep(3000);
	    //Role Creation
	    
	    Rolecreation RC=PageFactory.initElements(driver,Rolecreation.class);
	    RC.Rcreation(Rname,Rty);
	    
	    Thread.sleep(3000);
	    
	    //Alert
	    
	    driver.switchTo().alert().accept();
	    Thread.sleep(3000);
	    //Home
	    
	    RD.Rhom();
	
		}
    }

}