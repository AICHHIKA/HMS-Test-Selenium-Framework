package com.comcast.hms.generic.fileutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		int ranDomNumber=random.nextInt(1000);
		return ranDomNumber;
	}
	
	public int getRandomNumber(int no) {
		Random random = new Random();
		int ranDomNumber=random.nextInt(1, no);
		return ranDomNumber;
	}
	public String getSystemDateYYYYDDMM() {
		//Current date
		Date dateObj = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
		}
	public String getRequireDateYYYYDDMM(int days) {
	Date dateObj = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		 //Required date (ither plus or minus)
	    
	     
	     Calendar cal=sdf.getCalendar();
	     cal.add(Calendar.DAY_OF_MONTH,days);
	     String reqDate=sdf.format(cal.getTime());
		 return reqDate;
	}

}
