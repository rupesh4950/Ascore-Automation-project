package pom_scripts.stepGroups;

import java.time.Duration;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.GlobalVariables;

public class ProfileDetails extends GlobalVariables {
	public void clickOnDate(WebElement ele, WebElement reference, String date) throws InterruptedException {
		//try {

			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			Actions a = new Actions(driver);
			a.moveToElement(reference).build().perform();

			ele.click();// to click on the calander icon
			System.out.println("clciked on date");
			System.out.println(date);
			String date1[] = date.split("-");
			int day = Integer.parseInt(date1[0]);
			System.out.println(day);
			int month = 0;
			//////////////////////////
			if(!(date1[1].charAt(0)>47 && date1[1].charAt(0)<58)) {
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
			////////////////////////////////////////////////

			driver.findElement(By.xpath("//button[contains(@aria-label,'calendar view')]")).click();// to clcik on the
																									// year drop down

			// to move till pincode dropdown
			a.moveToElement(reference).build().perform();
			a.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'MuiDateCalendar')]"))).build()
					.perform();
			// finding xpath for the year
			String yearXpath = "//div[contains(@class,'MuiPickersYear') ]/button[ contains(text(),'%s')]";
			yearXpath = String.format(yearXpath, year);
			System.out.println(yearXpath);
			a.moveToElement(driver.findElement(By.xpath(yearXpath))).perform();
			driver.findElement(By.xpath(yearXpath)).click();
			System.out.println("year navigated");

			// click on month
			String onScreenMonth = driver
					.findElement(By.xpath("//div[contains(@class,'MuiPickersFadeTransitionGrou') ]/div")).getText();
			int monthPresnt = Month.valueOf((onScreenMonth.split(" ")[0]).toUpperCase()).getValue();
			// to get where to clcik
			int click = monthPresnt - month;
			WebElement montheClickEle = null;
			WebElement clickForward = driver.findElement(By.xpath("//button[@aria-label=\"Next month\"]"));
			WebElement clickBackwared = driver.findElement(By.xpath("//button[@aria-label=\"Previous month\"]"));
			if (click >= 0) {
				montheClickEle = clickBackwared;
				System.out.println("back");
			} else {
				montheClickEle = clickForward;
				System.out.println("front");
				click = 0 - click;
			}
			wait.until(ExpectedConditions.elementToBeClickable(montheClickEle));
			for (int i = 0; i < click; i++) {
				montheClickEle.click();
			}
			System.out.println("number of clicks needed is " + click);
			System.out.println("month navigated");

			/// day click
			String dayClick = "//button[@role=\"gridcell\" and text()='%s']";

			dayClick = String.format(dayClick, day);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dayClick)));
			Thread.sleep(1000);
			System.out.println(dayClick);
			driver.findElement(By.xpath(dayClick)).click();
			Thread.sleep(1000);
			System.out.println("day clicked");
		//} catch (Exception e) {
	//		e.printStackTrace();
		//}
	}
}
