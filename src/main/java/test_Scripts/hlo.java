package test_Scripts;

import static extentReporter.ExtentLogger.pass;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class hlo {
public static void main(String[] args) throws Exception {
	
	String date="01-Sep-2023";
	System.out.println(date);
	String date1[] = date.split("-");
	int day = Integer.parseInt(date1[0]);
	System.out.println(day);
	int month = 0;
	System.out.println(date1[1].charAt(0)>47 );
	System.out.println((char)57);
	//////////////////////////
	if(!(date1[1].charAt(0)>47 && date1[1].charAt(0)<58)) {
		System.out.println(true);
	DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH);
	TemporalAccessor temporalAccessor = dtFormatter.parse(date1[1]);
	month = temporalAccessor.get(ChronoField.MONTH_OF_YEAR);
	}
	else {
		month=(Integer.parseInt(date1[1]));
	}

	/////////////////////////
	
	System.out.println(month);
	int year = Integer.parseInt(date1[2]);
	System.out.println(date1[2]);
	System.out.println("day" + day + " " + month + " " + year);
//	String val="91.76 cgps";
//	String text="";
//	for(int i=0;i<val.length();i++) {
//		char c=val.charAt(i);
//		if((c>=48 &&c<58)|| c==46) {
//			text+=c;
//		}
//		
//	}
//	if((Double.parseDouble(text))<10) {// its cpga
//		DecimalFormat decfor = new DecimalFormat("0.0");  
//		String d=decfor.format((Double.parseDouble(text)));
//		System.out.println("its cgpa " + d);
//	}
//	else {
//		System.out.println("percentage " +text);
//		
//	}
//	
//	System.out.println(text);
}
}
