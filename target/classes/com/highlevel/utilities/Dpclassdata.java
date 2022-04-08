package com.highlevel.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dpclassdata {
	@DataProvider(name="teamDetails")
	Object[][] addcustomer() throws IOException
	{
		
		Excel e = new Excel();
	Object[][] data = e.getdata();
	return data;
	}
}
