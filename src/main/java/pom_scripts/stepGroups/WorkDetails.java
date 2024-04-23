package pom_scripts.stepGroups;

import java.util.ArrayList;

import CustomExceptions.CustomException;
import generic.GlobalVariables;

public class WorkDetails extends GlobalVariables {

	public void fill1StCompanyDetails(ArrayList<String> valuesList, Boolean currentlyEmployedStaues) throws Exception {
		String noOFCommpany1="1";
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		String companyName = nlp.getValueAtIndex(valuesList, 63);// 63 is the index for the first company
		nlp.enterInputIntoElemenet(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Company ", noOFCommpany1),
				companyName);

		// to enter the company name
		boolean isDisplayed = false;
		try {
			isDisplayed = nlp.isDisplayed(repo.workDetailsPage.getRequriredDropDownWithName(companyName));
			System.out.println(" inside try " + isDisplayed);
			nlp.Click(repo.workDetailsPage.getRequriredDropDownWithName(companyName));
			isDisplayed = true;
		} catch (Exception e) {
			String others = "others";
			nlp.clearTextFromInputField(
					repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Company ", noOFCommpany1));
			nlp.enterInputIntoElemenet(
					repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Company ", noOFCommpany1), others);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(others));
			System.out.println(" inside catch " + isDisplayed);
			nlp.enterInputIntoElemenet(
					repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Company Name", noOFCommpany1),
					companyName);
		}

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// to enter the Job Title
		String jobTitle = nlp.getValueAtIndex(valuesList, 64);// 64 is the index for the job title
		String jobis=jobTitle;
		if(jobTitle.toUpperCase().contains("TEST")||jobTitle.toUpperCase().contains("TESTING")||jobTitle.toUpperCase().contains("TEST ENGINEER")||jobTitle.toUpperCase().contains("QA")) {
			jobis="Software Testing";
		}
		nlp.Click(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Job Title", noOFCommpany1));
		nlp.enterInputIntoElemenet(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Job Title", noOFCommpany1),jobis);
		nlp.Click(repo.workDetailsPage.getjobCityOptionsDropDownWithName(jobis));
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// city
		nlp.scrollTtillElementVisible(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("City", noOFCommpany1));
		String city=nlp.getValueAtIndex(valuesList, 65);// city index is 65
		city=checkCity(city);
		
		nlp.Click(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("City", noOFCommpany1));
		nlp.enterInputIntoElemenet(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("City", noOFCommpany1),city);
		nlp.Click(repo.workDetailsPage.getjobCityOptionsDropDownWithName(city));
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Start Date
		String startDate=nlp.getValueAtIndex(valuesList, 66);// start date index is 65
		String endDate=nlp.getValueAtIndex(valuesList, 67);// start date index is 67
		sg.profileDetails.clickOnDate(repo.workDetailsPage.getcalanderIcon("Start Date", noOFCommpany1),repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),startDate);
		if(currentlyEmployedStaues) {
			// check Is this the current company
			String isThisCurrentCompany=nlp.getValueAtIndex(valuesList, 68);//68 is the index for currnet emploued
			if(isThisCurrentCompany.toUpperCase().contains("YES")||isThisCurrentCompany.toUpperCase().contains("Y")) {
				// click on the check box
				nlp.Click(repo.workDetailsPage.getisThisYourCurrentCompanyWithName(noOFCommpany1));
			}
			else {
				sg.profileDetails.clickOnDate(repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),endDate);
			}
		}
		else {
			// fill the end date
			sg.profileDetails.clickOnDate(repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),endDate);
		}
				
		
	}

	private String checkCity(String city) {
		if (city.equalsIgnoreCase("Bangalore")) {
			return ("Bangalore Urban");
		
		}
		if (city.equalsIgnoreCase("Mumbai")) {
			return("Mumbai City");
			
		}
		return city;
		
	}

	public void fill2ndCompanyDetails(ArrayList<String> valuesList, Boolean currentlyEmployedStaues) throws CustomException, InterruptedException {
		String noOFCommpany1="2";
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		String companyName = nlp.getValueAtIndex(valuesList, 69);// 69 is the index for the name company
		nlp.enterInputIntoElemenet(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Company ", noOFCommpany1),
				companyName);

		// to enter the company name
		boolean isDisplayed = false;
		try {
			isDisplayed = nlp.isDisplayed(repo.workDetailsPage.getRequriredDropDownWithName(companyName));
			System.out.println(" inside try " + isDisplayed);
			nlp.Click(repo.workDetailsPage.getRequriredDropDownWithName(companyName));
			isDisplayed = true;
		} catch (Exception e) {
			String others = "others";
			nlp.clearTextFromInputField(
					repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Company ", noOFCommpany1));
			nlp.enterInputIntoElemenet(
					repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Company ", noOFCommpany1), others);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(others));
			System.out.println(" inside catch " + isDisplayed);
			nlp.enterInputIntoElemenet(
					repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Company Name", noOFCommpany1),
					companyName);
		}

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// to enter the Job Title
		String jobTitle = nlp.getValueAtIndex(valuesList, 70);// 70 is the index for the job title
		String jobis=jobTitle;
		if(jobTitle.toUpperCase().contains("TEST")||jobTitle.toUpperCase().contains("TESTING")||jobTitle.toUpperCase().contains("TEST ENGINEER")||jobTitle.toUpperCase().contains("QA")) {
			jobis="Software Testing";
		}
		nlp.Click(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Job Title", noOFCommpany1));
		nlp.enterInputIntoElemenet(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Job Title", noOFCommpany1),jobis);
		nlp.Click(repo.workDetailsPage.getjobCityOptionsDropDownWithName(jobis));
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// city
		nlp.scrollTtillElementVisible(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("City", noOFCommpany1));
		String city=nlp.getValueAtIndex(valuesList, 71);// city index is 71
		city=checkCity(city);
		nlp.Click(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("City", noOFCommpany1));
		nlp.enterInputIntoElemenet(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("City", noOFCommpany1),city);
		nlp.Click(repo.workDetailsPage.getjobCityOptionsDropDownWithName(city));
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Start Date
		String startDate=nlp.getValueAtIndex(valuesList, 72);// start date index is 72
		String endDate=nlp.getValueAtIndex(valuesList, 73);// start date index is 73
		sg.profileDetails.clickOnDate(repo.workDetailsPage.getcalanderIcon("Start Date", noOFCommpany1),repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),startDate);
		if(currentlyEmployedStaues) {
			// check Is this the current company
			String isThisCurrentCompany=nlp.getValueAtIndex(valuesList, 74);//68 is the index for currnet emploued
			if(isThisCurrentCompany.toUpperCase().contains("YES")||isThisCurrentCompany.toUpperCase().contains("Y")) {
				// click on the check box
				nlp.Click(repo.workDetailsPage.getisThisYourCurrentCompanyWithName(noOFCommpany1));
			}
			else {
				sg.profileDetails.clickOnDate(repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),endDate);
			}
		}
		else {
			// fill the end date
			sg.profileDetails.clickOnDate(repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),endDate);
		}
		
	}

	public void fill3rdCompanyDetails(ArrayList<String> valuesList, Boolean currentlyEmployedStaues) throws Exception {
		
		String noOFCommpany1="3";
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		String companyName = nlp.getValueAtIndex(valuesList, 75);// 75 is the index for the name company
		nlp.enterInputIntoElemenet(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Company ", noOFCommpany1),
				companyName);

		// to enter the company name
		boolean isDisplayed = false;
		try {
			isDisplayed = nlp.isDisplayed(repo.workDetailsPage.getRequriredDropDownWithName(companyName));
			System.out.println(" inside try " + isDisplayed);
			nlp.Click(repo.workDetailsPage.getRequriredDropDownWithName(companyName));
			isDisplayed = true;
		} catch (Exception e) {
			String others = "others";
			nlp.clearTextFromInputField(
					repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Company ", noOFCommpany1));
			nlp.enterInputIntoElemenet(
					repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Company ", noOFCommpany1), others);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(others));
			System.out.println(" inside catch " + isDisplayed);
			nlp.enterInputIntoElemenet(
					repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Company Name", noOFCommpany1),
					companyName);
		}

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// to enter the Job Title
		String jobTitle = nlp.getValueAtIndex(valuesList, 76);// 76 is the index for the job title
		String jobis=jobTitle;
		if(jobTitle.toUpperCase().contains("TEST")||jobTitle.toUpperCase().contains("TESTING")||jobTitle.toUpperCase().contains("TEST ENGINEER")||jobTitle.toUpperCase().contains("QA")) {
			jobis="Software Testing";
		}
		nlp.Click(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Job Title", noOFCommpany1));
		nlp.enterInputIntoElemenet(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("Job Title", noOFCommpany1),jobis);
		nlp.Click(repo.workDetailsPage.getjobCityOptionsDropDownWithName(jobis));
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// city
		nlp.scrollTtillElementVisible(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("City", noOFCommpany1));
		String city=nlp.getValueAtIndex(valuesList, 77);// city index is 77
		city=checkCity(city);
		nlp.Click(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("City", noOFCommpany1));
		nlp.enterInputIntoElemenet(repo.workDetailsPage.getcompanyDetailsInputFeildWithName("City", noOFCommpany1),city);
		nlp.Click(repo.workDetailsPage.getjobCityOptionsDropDownWithName(city));
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Start Date
		String startDate=nlp.getValueAtIndex(valuesList, 78);// start date index is 72
		String endDate=nlp.getValueAtIndex(valuesList, 79);// start date index is 73
		sg.profileDetails.clickOnDate(repo.workDetailsPage.getcalanderIcon("Start Date", noOFCommpany1),repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),startDate);
		if(currentlyEmployedStaues) {
			// check Is this the current company
			String isThisCurrentCompany=nlp.getValueAtIndex(valuesList, 80);//68 is the index for currnet emploued
			if(isThisCurrentCompany.toUpperCase().contains("YES")||isThisCurrentCompany.toUpperCase().contains("Y")) {
				// click on the check box
				nlp.Click(repo.workDetailsPage.getisThisYourCurrentCompanyWithName(noOFCommpany1));
			}
			else {
				sg.profileDetails.clickOnDate(repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),endDate);
			}
		}
		else {
			// fill the end date
			sg.profileDetails.clickOnDate(repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),repo.workDetailsPage.getcalanderIcon("End Date", noOFCommpany1),endDate);
		}
		
		
	}
}
