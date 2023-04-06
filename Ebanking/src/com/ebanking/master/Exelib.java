package com.ebanking.master;

import java.io.IOException;

public class Exelib {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		//Instance Class
		
		Library Lb=new Library();
		
		String Rval=Lb.OpenApp("http://192.168.1.4/ranford2");
		System.out.println(Rval);
		Rval=Lb.AdminLgn("Admin","Admin");
		System.out.println(Rval);
		Rval=Lb.BranchCre();
		System.out.println(Rval);
		Lb.RoleCre("Tellerdd","E");
	}

}
