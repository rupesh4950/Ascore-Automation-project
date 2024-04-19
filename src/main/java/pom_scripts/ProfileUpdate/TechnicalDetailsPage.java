package pom_scripts.ProfileUpdate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pom_scripts.BasePage;

public class TechnicalDetailsPage extends BasePage {

	public TechnicalDetailsPage(WebDriver driver) {
		super(driver);
	}
	// all input feilds in technical details
	String techinacalDetailsXpath="//*[text()='%s']//ancestor::div[contains(@class,'individual-field')]//input";
	WebElement inputFields;
	public WebElement getInputFeild(String DynamicValue) {
		String xp = String.format(techinacalDetailsXpath, DynamicValue);
		inputFields = driver.findElement(By.xpath(xp));
		return inputFields;
	}

	public Object[] getInputFeildsWithName(String DynamicValue) {
		String xp = String.format(techinacalDetailsXpath, DynamicValue);
		inputFields = driver.findElement(By.xpath(xp));
		System.out.println("element identified "+ xp);
		Object[] l = { inputFields, DynamicValue+" input feild" };
		return l;
	}
	// all options in the techinacal details
	String optionsXpath="//div[@role=\"listbox\"]/div[contains(text(),\"%s\")]";
	WebElement options;
	public WebElement getOption(String DynamicValue) {
		String xp = String.format(optionsXpath, DynamicValue);
		options = driver.findElement(By.xpath(xp));
		return options;
	}

	public Object[] getOptionWithName(String DynamicValue) {
		String xp = String.format(optionsXpath, DynamicValue);
		options = driver.findElement(By.xpath(xp));
	
		Object[] l = { options, DynamicValue+" option" };
		return l;
	}
	

}
