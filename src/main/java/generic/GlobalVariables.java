package generic;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pom_scripts.Reopsitory;
import pom_scripts.stepGroups.StepGroup;

public class GlobalVariables {
	public static ArrayList<String> valuesList;

	public static int waitTime = 20;
	public static StepGroup sg;
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public static WebDriverWait wait;

	public static String browserName;
	public static JavascriptExecutor js;
	public static Actions action;
	public static String className = "";
	public static boolean bool;
	public static int shs, she, sms, sme, sss, sse, ihs, ihe, ims, ime, iss, ise;
	public static Reopsitory repo;
	public static Utility nlp;
}
