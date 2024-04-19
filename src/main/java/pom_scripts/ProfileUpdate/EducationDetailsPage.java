package pom_scripts.ProfileUpdate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class EducationDetailsPage extends BasePage{

	public EducationDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Highest Education input Field
		@FindBy(xpath = "//span[text()='Highest Education']//ancestor::div[contains(@class,'individual-field')]//input")
		private WebElement HighestEducationInputFiled;

		public WebElement getHighestEducationInputFiled() {
			return HighestEducationInputFiled;
		}

		public Object[] getHighestEducationInputFiledWithName() {
			Object[] l = { HighestEducationInputFiled, "HighestEducationInputFiled" };
			return l;
		}
	/// Higest Eduction DropDown
		String HigestEducationDropDownXpath="//div[contains(@class,'options-dropdown')]//div[text()=\"%s\"]";
		WebElement HigestEducationDropDown;

		public WebElement getHigestEducationDropDown(String DynamicValue) {
			String xp = String.format(HigestEducationDropDownXpath, DynamicValue);
			HigestEducationDropDown = driver.findElement(By.xpath(xp));
			return HigestEducationDropDown;
		}

		public Object[] getHigestEducationDropDownWithName(String DynamicValue) {
			String xp = String.format(HigestEducationDropDownXpath, DynamicValue);
			HigestEducationDropDown = driver.findElement(By.xpath(xp));
			Object[] l = { HigestEducationDropDown, "genderField" };
			return l;
		}
		
		/// all first input feilds 
		// here dynamicvalue 1 should be degree wether it is ssc or masters like 
		// dynamic value2 is the respective text feild 
		// In the element we need to give the value witch is present in the classs name not the actual name
		
		
		WebElement InputField;

		public WebElement getInputField(String DynamicValue1, String DynamicValue2) {
			String xp = getInputFieldXpath(DynamicValue1, DynamicValue2);

			InputField = driver.findElement(By.xpath(xp));
			return InputField;
		}

		private String getInputFieldXpath(String dynamicValue1, String dynamicValue2) {
			String InputFieldXpath="//div[contains(@class,\"%s\")]//span[text()=\""+dynamicValue2+"\"]/ancestor::div[contains(@class,\"individual-field\")]//input";
			String xp = String.format(InputFieldXpath, dynamicValue1);
			return xp;

		}

		public Object[] getInputFieldWithName(String DynamicValue1, String DynamicValue2) {// d1 is current or permment  and d2 is the coutry or state
			String xp = getInputFieldXpath(DynamicValue1, DynamicValue2);
			//System.out.println(xp);
			InputField = driver.findElement(By.xpath(xp));
			Object[] l = { InputField,DynamicValue1+"  "+ DynamicValue2 + " InputField" };
			return l;
		}
		
		// Dynamic element for all dropdown in the Eductaion dropdown
		WebElement requriredDropDown;

		String requriredDropDownXpath = "//div[@role=\"listbox\"]/div[text()=\"%s\"]";

		public WebElement getRequriredDropDown(String DynamicValue) {
			String xp = String.format(requriredDropDownXpath, DynamicValue);
			requriredDropDown = driver.findElement(By.xpath(xp));
			return requriredDropDown;
		}

		public Object[] getRequriredDropDownWithName(String DynamicValue) {
			String xp = String.format(requriredDropDownXpath, DynamicValue);
			requriredDropDown = driver.findElement(By.xpath(xp));
			System.out.println("element identified "+ xp);
			Object[] l = { requriredDropDown, DynamicValue+"Dropdown" };
			return l;
		}
		
		
		// Percentage or CGPA input text feildXpth
		String PercentageORCGPAInputFeildXpath="//div[contains(@class,\"%s\")]//span[text()=\"Percentage / CGPA\"]/ancestor::div[contains(@class,\"individual-field\")]//input[contains(@name,\"Grade\")]";
				
		WebElement PercentageORCGPAInputFeild;

		public WebElement getPercentageORCGPAInputFeild(String DynamicValue) {
			String xp = String.format(PercentageORCGPAInputFeildXpath, DynamicValue);
			PercentageORCGPAInputFeild = driver.findElement(By.xpath(xp));
			return PercentageORCGPAInputFeild;
		}

		public Object[] getPercentageORCGPAInputFeildWithName(String DynamicValue) {
			String xp = String.format(PercentageORCGPAInputFeildXpath, DynamicValue);
			PercentageORCGPAInputFeild = driver.findElement(By.xpath(xp));
			Object[] l = { PercentageORCGPAInputFeild, "PercentageORCGPAInputFeild" };
			return l;
		}
		///////////////////////////
		/// diploma 12th input feilds//in put tag id we need to give
		WebElement DPICheckBox;
		String DPICheckBoxXpath="//div[contains(@class,\"pre-degree\")]//div[contains(@class,'preDegree-checkbox')]//input[@id=\"%s\"]";

		public WebElement getDPICheckBoxXpath(String DynamicValue) {
			String xp = String.format(DPICheckBoxXpath, DynamicValue);
			DPICheckBox = driver.findElement(By.xpath(xp));
			return requriredDropDown;
		}

		public Object[] getDPICheckBoxXpathWithName(String DynamicValue) {
			String xp = String.format(DPICheckBoxXpath, DynamicValue);
			DPICheckBox = driver.findElement(By.xpath(xp));
			System.out.println("element identified "+ xp);
			Object[] l = { DPICheckBox, DynamicValue+"DPICheckBoxXpath" };
			return l;
		}
		
		////////////////////////Diploma . 12th (PUC) . ITI input feilds
		WebElement DPIInputField;

		public WebElement getDPIInputField(String DynamicValue1, String DynamicValue2) {
			String xp = getDPIInputFieldXpath(DynamicValue1, DynamicValue2);

			DPIInputField = driver.findElement(By.xpath(xp));
			return DPIInputField;
		}

		private String getDPIInputFieldXpath(String dynamicValue1, String dynamicValue2) {
			String InputFieldXpath="//div[contains(@class,\"pre-degree-course\")]//div[contains(text(),'%s')]//..//span[text()=\""+dynamicValue2+"\"]/ancestor::div[contains(@class,\"individual-field\")]//input";
			String xp = String.format(InputFieldXpath, dynamicValue1);
			return xp;

		}

		public Object[] getDPIInputFieldWithName(String DynamicValue1, String DynamicValue2) {// d1 is current or permment  and d2 is the coutry or state
			String xp = getDPIInputFieldXpath(DynamicValue1, DynamicValue2);
			//System.out.println(xp);
			DPIInputField = driver.findElement(By.xpath(xp));
			Object[] l = { DPIInputField,DynamicValue1+"  "+ DynamicValue2 + " DPIInputField" };
			return l;
		}
		// DPIPercentage or CGPA input text feildXpth
				String DPIPercentageORCGPAInputFeildXpath="(//div[contains(@class,\"pre-degree-course\")]//div[contains(text(),'%s')]//..//span[text()=\"Percentage / CGPA\"]/ancestor::div[contains(@class,\"individual-field\")]//input)[2]";
						
				WebElement DPIPercentageORCGPAInputFeild;

				public WebElement getDPIPercentageORCGPAInputFeild(String DynamicValue) {
					String xp = String.format(DPIPercentageORCGPAInputFeildXpath, DynamicValue);
					DPIPercentageORCGPAInputFeild = driver.findElement(By.xpath(xp));
					return DPIPercentageORCGPAInputFeild;
				}

				public Object[] getDPIPercentageORCGPAInputFeildWithName(String DynamicValue) {
					String xp = String.format(DPIPercentageORCGPAInputFeildXpath, DynamicValue);
					DPIPercentageORCGPAInputFeild = driver.findElement(By.xpath(xp));
					Object[] l = { DPIPercentageORCGPAInputFeild, "DPIPercentageORCGPAInputFeild" };
					return l;
				}
}
