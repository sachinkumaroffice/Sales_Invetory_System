   package com.sis.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	
	
	public int getRanDomNumber() {
		
		Random random = new Random();
		int intRandom = random.nextInt(1000);
		return intRandom;
	}
	
	public String getSystemDate() {
		Date date = new Date();
		String dateAndTime = date.toString();
		return dateAndTime;	
	}
	
	public String getSystemDateAndTimeFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY hh:mm:ss");
		Date systemDate = new Date();
		String getDateAndTime = dateFormat.format(systemDate);
		System.out.println(getDateAndTime);
		return getDateAndTime.replaceAll(":", "-");
	}
}
