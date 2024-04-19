package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import CustomExceptions.CustomException;

import static extentReporter.ExtentLogger.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom_scripts.Reopsitory;
import pom_scripts.stepGroups.Home;

public class UtilityMethod extends GlobalVariables implements FrameworkConstants, NLP {
//variables need all over the project

	public static ArrayList<String> arr = new ArrayList<String>();

//////////EXCEL///////
	public static ReadExcel excel = new ReadExcel();

	public void initObjects() {
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	public static String name() {
		LocalDateTime sysdate = LocalDateTime.now();
		String name = sysdate.toString().replace(":", "-");
		return name;
	}

	public String get_Title() {
		String title = driver.getTitle();
		return title;
	}

	public String get_Url() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public void clickAction(WebElement element_To_Click) {
		element_To_Click.click();
	}

	public void enter_Value(WebElement textfield, String value) {
		textfield.sendKeys(value);
	}

	public void switchToSpecificTitleWindow(String title) {
		String parentWindowId = driver.getWindowHandle();

		Set<String> allWindow = driver.getWindowHandles();
		allWindow.remove(parentWindowId);

		for (String windowId : allWindow) {
			driver.switchTo().window(windowId);
			if (driver.getTitle().equalsIgnoreCase(title))
				break;
		}
	}

	public void switchToSpecificWindow(WebElement element) {
		String parent = driver.getWindowHandle();
		Set<String> allWid = driver.getWindowHandles();
		allWid.remove(parent);
		for (String sessionId : allWid) {
			driver.switchTo().window(sessionId);
			if (element.isDisplayed())
				break;
		}
	}

	public static String getPhoto(WebDriver driver) {
		String imgpath = SCREENSHOT_PATH + name() + ".png";
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File(imgpath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "." + imgpath;
	}

	public String getValueProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream(PROPERTIES_PATH);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}

	////////////// EXCEL///////////////////
	public void createWorkBook(String filePath) throws Exception {
		excel.createWorkBook(filePath);
		pass("Excel is initilized ");
	}

	public Workbook getWrokBook() {
		// pass(" Excel sheet is ");
		return excel.getWrokBook();

	}

	public String getDataAtCell(String sheetName, int row, int column) throws Exception {

		return excel.getDataAtCell(sheetName, row, column);
	}

	public int getColomnCount(Workbook workbook, String sheeetName, int row) {
		return excel.getColomnCount(workbook, sheeetName, row);
	}

	public ArrayList<String> getRowData(Workbook workbook, String SheeetName, int row) {
		return excel.getRowData(workbook, SheeetName, row);
	}

	/////////// LIST NLPS///////////////////////////////////////
	public String getValueAtIndex(ArrayList<String> values, int i) throws CustomException {
		String val = null;
		if (i >= values.size()) {
			fail("Index is out of bound Check the index given the actual size is " + values.size());
			throw new CustomException(
					"Index is out of bound Check the index given the actual size is " + values.size());
		}
		try {
			val = values.get(i);
			pass(val + " is fetched at the given index " + i + "      " + "from \n" + values);
		} catch (Exception e) {
			fail("failed to fetch the value at the index " + i + " the values of list is " + values.size());
			throw new CustomException(
					"failed to fetch the value at the index " + i + " the values of list is " + values.size());
		}
		return val;
	}

	public String[] convertStringToList(String values, String c) {
		String[] va = null;
		try {
			va = values.split(c);
			pass(values + " conveted to list as " + va);

		} catch (Exception e) {
			fail(values + " is valied to convet as list ");
		}
		return va;
	}

	//////////////////// NLPS//////////////////////////////////////////////////////
	public void OpenBrowser() {
		System.out.println("open browser");
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions cp = new ChromeOptions();
		// cp.addArguments("--headless");
		driver = new ChromeDriver(cp);
		System.out.println("Browser  lounhed");
		// test.log(Status.PASS, "Browser is opened successfully ");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, TIMEOUTS_WAIT);
		bool = false;
		initObjects();

	}

	// Parametrized
	public void NavigateToUrl(String URL) {
		try {
			driver.navigate().to(URL);
			pass("Navigated to URL :  " + URL);

		} catch (Exception e) {
			fail("Failed to Navigated to URL :  " + URL);
		}
	}

	// Un paramaterized
	public void NavigateToUrl() {
		try {
			driver.navigate().to(URL);
			pass("Navigated to URL :  " + URL);

		} catch (Exception e) {
			fail("Failed to Navigated to URL :  " + URL);
		}

	}

	public WebDriver getDriver() {
		return driver;

	}

	public void Click(Object[] elementWithName) {
		WebElement ele = (WebElement) elementWithName[0];
		String eleName = (String) elementWithName[1];
		try {
			ele.click();
			pass("Clicked On  " + eleName);

		} catch (Exception e) {
			fail("falied to click on the element " + eleName + " log is " + e.toString());
		}

	}

	public void enterInputIntoElemenet(Object[] elementWithName, String value) {
		WebElement ele = (WebElement) elementWithName[0];
		String eleName = (String) elementWithName[1];
		try {
			ele.sendKeys(value);
			pass(value + " entered into " + eleName);
		} catch (Exception e) {
			fail("falied to enter values into the " + eleName);
		}

	}

	public boolean isDisplayed(Object[] elementWithName) {
		
		WebElement ele = (WebElement) elementWithName[0];
		String eleName = (String) elementWithName[1];
		try {
			if (ele.isDisplayed()) {
				pass(eleName + " is displayed");
				return true;
			}
			else {
				fail(eleName + " is not displayed");
				return false;
			}
		} catch (Exception e) {
			fail(eleName + " is not displayed");
			return false;
		}
	}

	public void scrollTtillElementVisible(Object[] elementWithName) {
		try {
			action.moveToElement((WebElement) elementWithName[0]).build().perform();
			pass("Moved mouse on to the element " + elementWithName[1]);
		} catch (Exception e) {
			fail("Failed to Moved mouse on to the element " + elementWithName[1]);
		}

	}

	public void clearTextFromInputField(Object[] elementWithName) {
		try {
			((WebElement)elementWithName[0]).clear();
			pass("successfully cleared from "+ elementWithName[1]);
		} catch (Exception e) {
			fail("failed to cleared from "+ elementWithName[1]);
		}
		
		
	}

}
