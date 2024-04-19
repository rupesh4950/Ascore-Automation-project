package pom_scripts.stepGroups;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import CustomExceptions.CustomException;
import generic.GlobalVariables;

public class PersonalDetails extends GlobalVariables{
	
	public void selectKnownLanugaes(String[] languages) {
		
		for(int i=0;i< languages.length;i++) {
			String lan = languages[i].trim();
			lan=lan.substring(0,1).toUpperCase()+lan.substring(1,lan.length());
			nlp.enterInputIntoElemenet(repo.personalDetailsPage.getknownLanguagesInputFieldWithName(),lan);
			nlp.Click(repo.personalDetailsPage.getknownLanguageDropDownWithName(lan));
		}
	}
	public void selectCurrentAddress(ArrayList<String> valuesList) throws Exception {
		String permentOrCurrent="Current Address";
		String Country=nlp.getValueAtIndex(valuesList, 9);// 9 is the current addreess country index
		currentAddressClick(permentOrCurrent,"Country",Country);
		
		String state=nlp.getValueAtIndex(valuesList, 10);//10 is the index of current address state
		currentAddressClick(permentOrCurrent,"State",state);
		String city=nlp.getValueAtIndex(valuesList, 11);//11 is the index of current address city
		currentAddressClick(permentOrCurrent,"City",city);
		// address
		String Address=nlp.getValueAtIndex(valuesList, 13);//13 is the index of current address  Address\
		System.out.println("Address is ="+ Address);
		nlp.Click(repo.personalDetailsPage.getAddressTextAreaWithName(permentOrCurrent));
		action.moveToElement(repo.personalDetailsPage.getAddressTextArea(permentOrCurrent)).sendKeys(Address).build().perform();
		String enteredValue=repo.personalDetailsPage.getAddressTextArea(permentOrCurrent).getText();
		if(enteredValue.equals(""))
			nlp.enterInputIntoElemenet(repo.personalDetailsPage.getAddressTextAreaWithName(permentOrCurrent), Address);
		
		///
		String pincode=nlp.getValueAtIndex(valuesList, 12);//12 is the index of current address  pincode
		if(pincode.contains(".")) {
			int in=pincode.indexOf('.');
			pincode=pincode.substring(0, in);
		}
		System.out.println(pincode);
		nlp.enterInputIntoElemenet(repo.personalDetailsPage.getpincodeInputFeildWithName(permentOrCurrent), pincode);
		
		
	
		
	}
	private void	currentAddressClick(String permentOrCurrent,String feild, String value) throws Exception {
		// to enter the values to the text feild
				Object[] eleWithName = repo.personalDetailsPage.getInputFieldWithName(permentOrCurrent, feild.strip());
				nlp.enterInputIntoElemenet(eleWithName, value.strip());
				Thread.sleep(1000);
				// to clcik the exptected text value
				eleWithName=repo.personalDetailsPage.getRequriredDropDownWithName(value.strip());
				wait.until(ExpectedConditions.elementToBeClickable((WebElement)eleWithName[0]));
				Thread.sleep(1000);
				nlp.Click(eleWithName);
	}
	public void selectPermanentAddress(ArrayList<String> valuesList) throws Exception {
		String permentOrCurrent="Permanent Address";
		String Country=nlp.getValueAtIndex(valuesList, 14);// 14 is the permanent  addreess country index
		currentAddressClick(permentOrCurrent,"Country",Country);
		
		String state=nlp.getValueAtIndex(valuesList, 15);//15 is the index of permanent address state
		currentAddressClick(permentOrCurrent,"State",state);
		String city=nlp.getValueAtIndex(valuesList, 16);//16 is the index of Permanent address city
		currentAddressClick(permentOrCurrent,"City",city);
		// address
		String Address=nlp.getValueAtIndex(valuesList, 18);//18 is the index of Permanent address  Address
		System.out.println("Address is ="+ Address);
		nlp.Click(repo.personalDetailsPage.getAddressTextAreaWithName(permentOrCurrent));
		action.moveToElement(repo.personalDetailsPage.getAddressTextArea(permentOrCurrent)).sendKeys(Address).build().perform();
		String enteredValue=repo.personalDetailsPage.getAddressTextArea(permentOrCurrent).getText();
		if(enteredValue.equals(""))
			nlp.enterInputIntoElemenet(repo.personalDetailsPage.getAddressTextAreaWithName(permentOrCurrent), Address);
		
		///
		String pincode=nlp.getValueAtIndex(valuesList, 17);//17 is the index of Permanent address  pincode
		if(pincode.contains(".")) {
			int in=pincode.indexOf('.');
			pincode=pincode.substring(0, in);
		}
		System.out.println(pincode);
		nlp.enterInputIntoElemenet(repo.personalDetailsPage.getpincodeInputFeildWithName(permentOrCurrent), pincode);
		
	}
}
