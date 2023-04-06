package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notepad {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		   //Instance Class
		
	       Library LB=new Library();
				
		   LB.OpenApp("http://192.168.1.4/ranford2");
		   LB.AdminLgn("Admin","Admin");
			
		   //To Get Test Data File path
		   
		   String Fpath="D:\\EbankingmrngMarch\\Ebanking\\src\\com\\ebanking\\testdata\\Role.txt";
				
			//Results File Path	
	
	       String Rpath="D:\\EbankingmrngMarch\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.txt";
	       String Sd;
	       
	          //To Get Test Data File
	       
	       FileReader FR=new FileReader(Fpath);
	       BufferedReader BR=new BufferedReader(FR);
	       String Sread=BR.readLine();
	       System.out.println(Sread);
	       
	      //Writing Header into Results 
	       
	       FileWriter Fw=new FileWriter(Rpath);
	       BufferedWriter BW=new BufferedWriter(Fw);
	       BW.write(Sread);
	       BW.newLine();
	       
	       //Multiple Iterations -------------- Loop
	       
	       while ((Sd=BR.readLine())!=null) 
	       {
			  System.out.println(Sd);
			  
			  //Split
			  
			  String SR[]=Sd.split("###");
			  
			          String Rname=SR[0];
			          String Rty=SR[1];
			          
			  String Res=LB.RoleCre(Rname,Rty);
			  System.out.println(Res);
			  
			  //Results
			  
			  BW.write(Sd+"^$^$"+Res);
			  BW.newLine();
			
			  
	    	}
	       
	       BW.close();
	       BR.close();
	       
	    }

}
