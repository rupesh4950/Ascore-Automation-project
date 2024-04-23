package extentReporter;

import generic.DriverIsNullException;

import generic.Utility;


//import com.Pantaloons.Enums.ConfigProperties;
//import com.Pantaloons.FrameworkConstants.FrameworkConstants;
//import com.Pantaloons.Utils.PropertyUtils;
//import com.Pantaloons.Utils.Utility;
//
import com.aventstack.extentreports.MediaEntityBuilder;

public final class ExtentLogger 
{
	private ExtentLogger(){}

	//Pass logger and we can control screenshot is needed or no 
	public static void pass(String logMessage)
	{
		//	System.out.println("pass1");
		try {
			ExtentConfig.getExtentTest().pass(logMessage);
		} catch (Exception e) {
			ExtentConfig.getExtentTest().pass("no message passed");
		}
			
		//	System.out.println("pass2");
	}
	public static void info(String logMessage) {
		try {
			ExtentConfig.getExtentTest().info(logMessage);
		} catch (Exception e) {
			ExtentConfig.getExtentTest().info("no message passed");
		}
	}
	public static void pass(String logMessage,boolean b)
	{
			try {
				ExtentConfig.getExtentTest().pass(logMessage, 
						MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.getBase64Image()).build());
			} catch (DriverIsNullException e) {
				// TODO Auto-generated catch block
				pass(logMessage);
				e.printStackTrace();
			}
	}

	//Fail logger and we can control screenshot is needed or no
	public static void fail(String logMessage)
	{
			//Attach screenshot with log message, exceptionName, stackTrace
			try {
				ExtentConfig.getExtentTest().fail(logMessage, 
						MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.getBase64Image()).build());
			} catch (DriverIsNullException e) {
				ExtentConfig.getExtentTest().fail(logMessage);
				e.printStackTrace();
			}
	}


	
	//Skip logger and we can control screenshot is needed or no
		public static void skip(String logMessage, boolean isScreenshotNeeded)
		{
			if(isScreenshotNeeded)
			{
				//Attach screenshot with log message, exceptionName, stackTrace
				try {
					ExtentConfig.getExtentTest().skip(logMessage, 
							MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.getBase64Image()).build());
				} catch (DriverIsNullException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else //Do not attach screenshot
			{
				ExtentConfig.getExtentTest().skip(logMessage);
			}
		}
}
