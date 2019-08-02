package com.atmecs.falconrepoertdashboard.testscripts.recentruns;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.utils.DateUtils;

public class Check {
	
	public static void main(String[] args) {
		
		//String timeStamp = new SimpleDateFormat("MMddHHmm").format(new Date(System.currentTimeMillis()+5));
		//System.out.println(timeStamp);
		
		Calendar calendar = Calendar.getInstance();
	    System.out.println(calendar.getTime());
	    //calendar.add(Calendar.MINUTE, 5);
	    //System.out.println(calendar.getTime());
	    //Jul 31, 2019 4:29:20 PM
	    //Jul 31, 2019 5:32:38 PM
	    
	    LocalDateTime ldt = LocalDateTime.now().minusHours(1);
	    System.out.println("local "+ldt);
	    String d1 = ldt.format(DateTimeFormatter.ofPattern("MMM dd, YYYY h:mm:ss a"));
	    System.out.println("local time "+d1);
	    
	    
	    /*LocalDateTime dateStart = LocalDateTime.now();
	    String d1 = dateStart.format(DateTimeFormatter.ofPattern("MMM dd, YYYY h:mm:ss a"));
	    System.out.println("local time "+d1);
	    dateStart.minusMinutes(10);
	    System.out.println("minus min from local "+dateStart);
	    
	    Date d = new Date();
	    String newDate = DateUtils.formatDate(d);
	    System.out.println(newDate);*/
	    
	    
	    Random rand = new Random();

	 // Obtain a number between [0 - 49].
	 int n = rand.nextInt(4);

	 // Add 1 to the result to get a number from the required range
	 // (i.e., [1 - 50]).
	 n += 1;
	 
	 String str = Integer.toString(n);
	 System.out.println("sring "+str);

		  
	}

}
