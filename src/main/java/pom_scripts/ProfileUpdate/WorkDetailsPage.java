package pom_scripts.ProfileUpdate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class WorkDetailsPage extends BasePage{

	public WorkDetailsPage(WebDriver driver) {
		super(driver);
	}

	// fresher or experiesed radiobutton
	String FEXpath="//input[@id=\"%s\"]";
	WebElement fresherOrExperiecedRadioButton;

	public WebElement getfresherOrExperiecedRadioButton(String DynamicValue) {
		String xp = String.format(FEXpath, DynamicValue);
		fresherOrExperiecedRadioButton = driver.findElement(By.xpath(xp));
		return fresherOrExperiecedRadioButton;
	}

	public Object[] getfresherOrExperiecedRadioButtonWithName(String DynamicValue) {
		String xp = String.format(FEXpath, DynamicValue);
		fresherOrExperiecedRadioButton = driver.findElement(By.xpath(xp));
		Object[] l = { fresherOrExperiecedRadioButton, DynamicValue+" radio button" };
		return l;
	}
	
	// Are you currently employed 
	String currentlyEmp="//span[contains(text(),'Are your currently employed')]/../..//div[text()='%s']";
	WebElement areYouCurrentlyEmployedYesOrNoButton;

	public WebElement getareYouCurrentlyEmployedYesOrNoButton(String DynamicValue) {
		String xp = String.format(currentlyEmp, DynamicValue);
		areYouCurrentlyEmployedYesOrNoButton = driver.findElement(By.xpath(xp));
		return areYouCurrentlyEmployedYesOrNoButton;
	}

	public Object[] getareYouCurrentlyEmployedYesOrNoButtonWithName(String DynamicValue) {
		String xp = String.format(currentlyEmp, DynamicValue);
		areYouCurrentlyEmployedYesOrNoButton = driver.findElement(By.xpath(xp));
		Object[] l = { areYouCurrentlyEmployedYesOrNoButton,"currently employed is status is "+ DynamicValue };
		return l;
	}
	
	// all input feilds in the company 
	

	WebElement companyDetailsInputFeild;

	public WebElement getcompanyDetailsInputFeild(String DynamicValue1, String DynamicValue2) {
		String xp = getInputFieldXpath(DynamicValue1, DynamicValue2);
		System.out.println(xp);
		companyDetailsInputFeild = driver.findElement(By.xpath(xp));
		return companyDetailsInputFeild;
	}

	private String getInputFieldXpath(String dynamicValue1, String dynamicValue2) {
		String companyDetailsInputFeildXpath="(//span[contains(text(),'%s')]//ancestor::div[contains(@class,'individual')]//input)["+dynamicValue2+"]";
		String xp = String.format(companyDetailsInputFeildXpath, dynamicValue1);
		return xp;

	}

	public Object[] getcompanyDetailsInputFeildWithName(String DynamicValue1, String DynamicValue2) {// d1 is input feild name  and d2 is witch company like first or second integer we need to give
		String xp = getInputFieldXpath(DynamicValue1, DynamicValue2);
		System.out.println(xp);
		companyDetailsInputFeild = driver.findElement(By.xpath(xp));
		
		Object[] l = { companyDetailsInputFeild,DynamicValue1+"  "+ DynamicValue2 + " InputField" };
		return l;
	}
	
	// Dynamic element for all dropdown in the workdetaisl dropdown
			WebElement requriredDropDown;

			String requriredDropDownXpath = "//div[@role=\"listbox\"]//*[text()=\"%s\"]";

			public WebElement getRequriredDropDown(String DynamicValue) {
				String xp = String.format(requriredDropDownXpath, DynamicValue);
				requriredDropDown = driver.findElement(By.xpath(xp));
				return requriredDropDown;
			}

			public Object[] getRequriredDropDownWithName(String DynamicValue) {
				String xp = String.format(requriredDropDownXpath, DynamicValue);
				requriredDropDown = driver.findElement(By.xpath(xp));
			//	System.out.println("element identified "+ xp);
				Object[] l = { requriredDropDown, DynamicValue+"Dropdown" };
				return l;
			}
			
	// job options 
			WebElement jobOptionsDropDown;

			String jobOptionsDropDownXpath = "//div[contains(@class,'options-dropdown')]//div[text()='%s']";

			public WebElement getjobCityOptionsDropDown(String DynamicValue) {
				String xp = String.format(jobOptionsDropDownXpath, DynamicValue);
				jobOptionsDropDown = driver.findElement(By.xpath(xp));
				return jobOptionsDropDown;
			}

			public Object[] getjobCityOptionsDropDownWithName(String DynamicValue) {
				String xp = String.format(jobOptionsDropDownXpath, DynamicValue);
				jobOptionsDropDown = driver.findElement(By.xpath(xp));
				System.out.println("element identified "+ xp);
				Object[] l = { jobOptionsDropDown, DynamicValue+"Dropdown" };
				return l;
			}
			
			
			//input all 
			 
			WebElement workDetailsInputFeild;

			String workInputfeild = "//*[contains(text(),'%s')]//ancestor::div[contains(@class,'individual')]//input";

			public WebElement getworkDetialsInputfeild(String DynamicValue) {
				String xp = String.format(workInputfeild, DynamicValue);
				workDetailsInputFeild = driver.findElement(By.xpath(xp));
				return workDetailsInputFeild;
			}

			public Object[] getworkDetailsInputfeildWithName(String DynamicValue) {
				String xp = String.format(workInputfeild, DynamicValue);
				workDetailsInputFeild = driver.findElement(By.xpath(xp));
				//System.out.println("element identified "+ xp);
				Object[] l = { workDetailsInputFeild, DynamicValue+ "input feild" };
				return l;
			}
			
		// calandericon
			WebElement calanderIcon;

			public WebElement getcalanderIcon(String DynamicValue1, String DynamicValue2) {
				String xp = getcalanderIconXpath(DynamicValue1, DynamicValue2);
				System.out.println(xp);
				calanderIcon = driver.findElement(By.xpath(xp));
				return calanderIcon;
			}

			private String getcalanderIconXpath(String dynamicValue1, String dynamicValue2) {
				String companyDetailsInputFeildXpath="(//span[contains(text(),'%s')]//ancestor::div[contains(@class,'individual')]//button)["+dynamicValue2+"]";
				String xp = String.format(companyDetailsInputFeildXpath, dynamicValue1);
				return xp;

			}

			public Object[] getcalanderIconWithName(String DynamicValue1, String DynamicValue2) {// d1 is input feild name  and d2 is witch company like first or second integer we need to give
				String xp = getcalanderIconXpath(DynamicValue1, DynamicValue2);
				System.out.println(xp);
				calanderIcon = driver.findElement(By.xpath(xp));
				
				Object[] l = { calanderIcon,DynamicValue1+"  "+ DynamicValue2 + " calander icon" };
				return l;
			}
			
		// Is this the current company
			@FindBy(xpath = "//*[contains(text(),'Is this the current company')]/..//input")
			private  WebElement isThisYourCurrentCompany;
			public WebElement getisThisYourCurrentCompany() {
				
				return isThisYourCurrentCompany;
			}
			public Object[] getisThisYourCurrentCompanyWithName() {
				Object[] l = { isThisYourCurrentCompany, " isThisYourCurrentCompany check box" };
				return l;
			} 
			
			
		// + company button
			@FindBy(xpath = "//button[contains(text(),'+ Company')]")
			private  WebElement plusCompanyButton;
			public WebElement getplusCompanyButton() {
				
				return plusCompanyButton;
			}
			public Object[] getplusCompanyButtonWithName() {
				Object[] l = { plusCompanyButton, " plusCompanyButton" };
				return l;
			} 
			
	
			
			
			
			
			
}
