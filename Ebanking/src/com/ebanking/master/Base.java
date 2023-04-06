package com.ebanking.master;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.testng.annotations.AfterSuite;

public class Base {

	
	Library LB=new Library();
	
  @BeforeTest
  public void beforeTest() throws InterruptedException
  {
  LB.AdminLgn("Admin","Admin");
  }

  @AfterTest
  public void afterTest() throws InterruptedException 
  {
  LB.admlgt();
  }

  @BeforeSuite
  public void beforeSuite() throws IOException 
  {
  LB.OpenApp("http://192.168.1.4/ranford2");
  }

  @AfterSuite
  public void afterSuite() 
  {
  LB.Appc();
  }

}
