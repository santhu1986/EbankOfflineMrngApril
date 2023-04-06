package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Instance Class
		
		Library LB=new Library();
		
		LB.OpenApp("http://192.168.1.4/ranford2");
		LB.AdminLgn("Admin","Admin");
		
		//To Get Test data File
		
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
			
			String Res=LB.RoleCre(Rname,Rty);
			WC2.setCellValue(Res);
			
		}
		
		//Results
		
		FileOutputStream FOS=new FileOutputStream("D:\\EbankingmrngMarch\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.xlsx");
		WB.write(FOS);
		WB.close();
		
		
	}

}
