package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertiesFileTest {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
	Properties pobj = new Properties();
	pobj.load(fis);
	String URL = pobj.getProperty("url");
	String Browser = pobj.getProperty("browser");
	String Username = pobj.getProperty("username");
	String Password = pobj.getProperty("password");
	
	System.out.println(URL);
	System.out.println(Browser);
	System.out.println(Username);
	System.out.println(Password);
}
}
