package pom_scripts.ProfileUpdate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class PersonalDetailsPage extends BasePage {

	public PersonalDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// DateOfBirth
	@FindBy(xpath = "//*[contains(text(),'DOB')]//ancestor::div[contains(@class,'individual')]//button")
	private WebElement DOB_Button;

	public WebElement getDOB_Button() {
		return DOB_Button;
	}

	public Object[] getDOB_ButtonWithName() {
		Object[] l = { DOB_Button, "DOB_Button" };
		return l;
	}

	/// dynamic Gender
	WebElement genderField;
	String genderXpath = "//*[text()='Gender']/ancestor::div[contains(@class,\"individual-field\")]//div[contains(@class,\"genderField\") and contains(text(),'%s')]";

	public WebElement getGenderField(String DynamicValue) {
		String xp = String.format(genderXpath, DynamicValue);
		genderField = driver.findElement(By.xpath(xp));
		return genderField;
	}

	public Object[] getGenderFieldWithName(String DynamicValue) {
		String xp = String.format(genderXpath, DynamicValue);
		genderField = driver.findElement(By.xpath(xp));
		Object[] l = { genderField, "genderField" };
		return l;
	}

	// Known languages
	@FindBy(xpath = "//span[text()='Known Languages']//ancestor::div[contains(@class,\"individual-field\")]//input")
	private WebElement knownLanguagesInputField;

	public WebElement getknownLanguagesInputField() {
		return knownLanguagesInputField;
	}

	public Object[] getknownLanguagesInputFieldWithName() {
		Object[] l = { knownLanguagesInputField, "knownLanguagesInputField" };
		return l;
	}

	/// known language dropdown
	WebElement knownLanguageDropDown;
	String knownLanguageDropDownXpath = "//div[@role=\"listbox\"]/div[contains(text(),'%s')]";

	public WebElement getknownLanguageDropDown(String DynamicValue) {
		String xp = String.format(knownLanguageDropDownXpath, DynamicValue);
		knownLanguageDropDown = driver.findElement(By.xpath(xp));
		return knownLanguageDropDown;
	}

	public Object[] getknownLanguageDropDownWithName(String DynamicValue) {
		String xp = String.format(knownLanguageDropDownXpath, DynamicValue);
		knownLanguageDropDown = driver.findElement(By.xpath(xp));
		Object[] l = { knownLanguageDropDown, "knownLanguageDropDown" };
		return l;
	}

	/// common dynamic values for Current Address and Permanent Address

	// dynamic element for pincode
	WebElement PincodeText;
	String pincodeXpath = "//div[text()='%s']/..//*[text()='Pincode']";

	public WebElement getPincodeText(String DynamicValue) {
		String xp = String.format(pincodeXpath, DynamicValue);
		PincodeText = driver.findElement(By.xpath(xp));
		return PincodeText;
	}

	public Object[] getPincodeTextWithName(String DynamicValue) {
		String xp = String.format(pincodeXpath, DynamicValue);
		PincodeText = driver.findElement(By.xpath(xp));
		Object[] l = { PincodeText, "PincodeText" };
		return l;
	}

	// dynamic element for all input text feild
	WebElement InputField;

	public WebElement getInputField(String DynamicValue1, String DynamicValue2) {
		String xp = getInputFieldXpath(DynamicValue1, DynamicValue2);

		InputField = driver.findElement(By.xpath(xp));
		return InputField;
	}

	private String getInputFieldXpath(String dynamicValue1, String dynamicValue2) {
		String InputFieldXpath = "//div[text()='%s']/..//*[text()='" + dynamicValue2
				+ "']//ancestor::div[contains(@class,'individual-field')]//input";
		String xp = String.format(InputFieldXpath, dynamicValue1);
		return xp;

	}

	public Object[] getInputFieldWithName(String DynamicValue1, String DynamicValue2) {// d1 is current or permment  and d2 is the coutry or state
		String xp = getInputFieldXpath(DynamicValue1, DynamicValue2);
		InputField = driver.findElement(By.xpath(xp));
		Object[] l = { InputField, DynamicValue2 + " InputField" };
		return l;
	}

	// Dynamic elent for all dropdown in the current and the perment address
	WebElement requriredDropDown;

	String requriredDropDownXpath = "//div[@role=\"listbox\"]/div[contains(text(),'%s')]";

	public WebElement getRequriredDropDown(String DynamicValue) {
		String xp = String.format(knownLanguageDropDownXpath, DynamicValue);
		requriredDropDown = driver.findElement(By.xpath(xp));
		return requriredDropDown;
	}

	public Object[] getRequriredDropDownWithName(String DynamicValue) {
		String xp = String.format(knownLanguageDropDownXpath, DynamicValue);
		requriredDropDown = driver.findElement(By.xpath(xp));
		System.out.println("element identified "+ xp);
		Object[] l = { requriredDropDown, DynamicValue+"Dropdown" };
		return l;
	}
	
	////  text area for the textfeilds in current and the perment address
	
	String AddresstextAreaXpath="//div[text()='%s']/..//span[text()='Address']//ancestor::div[contains(@class,\"form-group\")]";
	
	WebElement AddressTextArea;
	public WebElement getAddressTextArea(String DynamicValue) {
		String xp = String.format(AddresstextAreaXpath, DynamicValue);
		AddressTextArea = driver.findElement(By.xpath(xp));
		return AddressTextArea;
	}

	public Object[] getAddressTextAreaWithName(String DynamicValue) {
		String xp = String.format(AddresstextAreaXpath, DynamicValue);
		AddressTextArea = driver.findElement(By.xpath(xp));
		//System.out.println("element identified "+ xp);
		Object[] l = { AddressTextArea, DynamicValue+" address Text area" };
		return l;
	}
	
	////// pincode text feild 
	WebElement pincodeInputFeild;
	String pincodeXpathDynamic="//div[text()='%s']/..//*[text()='Pincode']//ancestor::div[contains(@class,\"individual-field\")]//input";
	public WebElement getpincodeInputFeild(String DynamicValue) {
		String xp = String.format(pincodeXpathDynamic, DynamicValue);
		pincodeInputFeild = driver.findElement(By.xpath(xp));
		return pincodeInputFeild;
	}

	public Object[] getpincodeInputFeildWithName(String DynamicValue) {
		String xp = String.format(pincodeXpathDynamic, DynamicValue);
		pincodeInputFeild = driver.findElement(By.xpath(xp));
		//System.out.println("element identified "+ xp);
		Object[] l = { pincodeInputFeild, DynamicValue+" pincode input field " };
		return l;
	}
	
}
