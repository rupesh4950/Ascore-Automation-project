package test_Scripts;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static extentReporter.ExtentLogger.*;

import java.io.FileInputStream;
import java.util.ArrayList;

import com.aventstack.extentreports.Status;

import CustomExceptions.CustomException;
import extentReporter.ExtentConfig;
import generic.Base_Test;
import generic.NLP;
import generic.ReadExcel;
import generic.Utility;
import lombok.val;
import pom_scripts.BasePage;
import pom_scripts.Reopsitory;
import pom_scripts.stepGroups.StepGroup;

public class AcrossGeo extends Base_Test {
	@Test(priority = 1)
	public void Ascore() throws Exception {
		
		boolean te = true;
		nlp = new Utility();// which containas all the utilitys and nlps
		nlp.OpenBrowser();
		// fist i s to create all these

	for(int times=1;times<=noOfIterations;times++) {
		className = "testign + "+ (times);
		ExtentConfig.createTest(className);// it will create a new test
		try {
		
		repo = new Reopsitory(driver);// need to call once after the driver is created only
		sg = new StepGroup();// to get all the step groups
		nlp.NavigateToUrl();
		//////////

		

		nlp.createWorkBook(EXCEL_PATH);
		Workbook book = nlp.getWrokBook();
		ArrayList<String> header = nlp.getRowData(book, EXCEL_SHEETNAME, 0);
		valuesList = nlp.getRowData(book, EXCEL_SHEETNAME, times);// TO FETCH THE ROW VALUES
		for (int i = 0; i < header.size(); i++) {
			System.out.println(i + " " + header.get(i) + "  =  " + valuesList.get(i));
		}

		String email = nlp.getValueAtIndex(valuesList, 5);// email index is 5
	//	email = "pranavlondhe111@gmail.com";
		System.out.println(email);
		
		sg.home.sigin(email, "Password@123");
		//////////////////////////////////////////////////////////////////////
		nlp.isDisplayed(repo.profileUpdatePage.getAcrossgeo_ImageWithName());

		String date = nlp.getValueAtIndex(valuesList, 7);// DOB index is 7
		try {
			sg.profileDetails.clickOnDate(repo.personalDetailsPage.getDOB_Button(),
					repo.personalDetailsPage.getPincodeText("Current Address"), date);
			pass("clicked on the date given " + date);
		} catch (Exception e) {
			fail("falied to click on the date");
		}

		String gender = nlp.getValueAtIndex(valuesList, 6);// gender index is 6
		nlp.Click(repo.personalDetailsPage.getGenderFieldWithName(gender));

		String knownLanguages = nlp.getValueAtIndex(valuesList, 8);
		String[] languageArray = nlp.convertStringToList(knownLanguages, ",");
		sg.personalDetails.selectKnownLanugaes(languageArray);

		// fill the current address
		sg.personalDetails.selectCurrentAddress(valuesList);
		// fill the perment address
		nlp.scrollTtillElementVisible(repo.personalDetailsPage.getAddressTextAreaWithName("Permanent Address"));
		sg.personalDetails.selectPermanentAddress(valuesList);
		// Click on Next button
		nlp.Click(repo.profileUpdatePage.getNext_ButtonWithName());
		System.out.println("clcikd on next button");

		// enter educational details
		fillEducationalDetails(valuesList);
		// Click on Next button
		nlp.Click(repo.profileUpdatePage.getNext_ButtonWithName());

		// need to fill the work details
		fillWorkDetails(valuesList);

		// to click on the next button
		nlp.Click(repo.profileUpdatePage.getNext_ButtonWithName());
		// need to fill the Technical Details
		String domine = nlp.getValueAtIndex(valuesList, 88).strip();// Domine index is 88
		nlp.enterInputIntoElemenet(repo.technicalDetailsPage.getInputFeildsWithName("Domain"), domine);
		nlp.Click(repo.technicalDetailsPage.getOptionWithName(domine));
		// job role
		String jobRole = nlp.getValueAtIndex(valuesList, 89).strip();// jobRole index is 89
		nlp.enterInputIntoElemenet(repo.technicalDetailsPage.getInputFeildsWithName("Job Role"), jobRole.strip());
		//nlp.Click(repo.technicalDetailsPage.getOptionWithName(jobRole));
		String xpath="//div[@role=\"listbox\"]//div[contains(text(),'%s')]";
		try {
		driver.findElement(By.xpath(String.format(xpath, jobRole.strip()))).click();
		}catch (Exception e) {
			info("failed to fine the job role in the ui");
			action.sendKeys(Keys.ENTER).build().perform();
		}
		
		pass("clicked on the job role "+ jobRole);
		enterSkills(valuesList);
		// click on add button
		nlp.Click(repo.profileUpdatePage.getAdd_ButtonWithName());
		Thread.sleep(2000);

		bool = true;
		}
		catch (Exception e) {
			
			fail(e.toString());
			bool = true;
			ExtentConfig.removeExtentTest();
		}
	}

	}

	private void enterSkills(ArrayList<String> valuesList) throws CustomException {
		String skilss = nlp.getValueAtIndex(valuesList, 90).strip();// Skills  index is 90
		String[] skils = nlp.convertStringToList(skilss, ",");
		for (String skil : skils) {
			nlp.enterInputIntoElemenet(repo.technicalDetailsPage.getInputFeildsWithName("Skills"), skil);
			nlp.Click(repo.technicalDetailsPage.getOptionWithName(skil));
		}
		
		
	}

	private void fillWorkDetails(ArrayList<String> valuesList) throws Exception {
		String currentlyEmployed = nlp.getValueAtIndex(valuesList, 62);// 62 is the index for the currently employed
		String company1 = nlp.getValueAtIndex(valuesList, 63).strip();// 63 is the index for the first company
		//////////////////////////////////////////////////////////////////////////////////////
		// fill the currently employed field
		boolean experienced = false;
		String fE = "";
		if (company1.equalsIgnoreCase("NA") || company1.toUpperCase().strip().contains("NA")) {
			fE = "fresher";

		} else {
			fE = "experienced";
			experienced = true;
		}
		nlp.Click(repo.workDetailsPage.getfresherOrExperiecedRadioButtonWithName(fE));
		//////////////////////////////////////////////////////////////////////////////////////
		// if experenced only we need to fill all the date
		if (experienced) {
			// next need to chech for currently employed or not
			String yesORNO = "";
			Boolean currentlyEmployedStaues = false;
			if (currentlyEmployed.equalsIgnoreCase("YES") || currentlyEmployed.toUpperCase().strip().contains("YES")) {
				yesORNO = "Yes";
				currentlyEmployedStaues = true;
			} else {
				yesORNO = "No";
			}
			nlp.Click(repo.workDetailsPage.getareYouCurrentlyEmployedYesOrNoButtonWithName(yesORNO));

			// fill the company details
			String noOFCommpany1 = "1";
			sg.workDetails.fill1StCompanyDetails(valuesList, currentlyEmployedStaues);
			String company2 = nlp.getValueAtIndex(valuesList, 69);// 69 is the index for the second company
			if (company2.equalsIgnoreCase("NA")) {
				// skip
			} else {
				// fill second company details
				nlp.Click(repo.workDetailsPage.getplusCompanyButtonWithName());
				sg.workDetails.fill2ndCompanyDetails(valuesList, currentlyEmployedStaues);
				String company3 = nlp.getValueAtIndex(valuesList, 75);// 75 is the index for the 3rd company
				if (!company3.equalsIgnoreCase("NA")) {
					nlp.Click(repo.workDetailsPage.getplusCompanyButtonWithName());
					sg.workDetails.fill3rdCompanyDetails(valuesList, currentlyEmployedStaues);
				}
			}

			//////// company details completed
			// need to fill the the total experience and all the other fields'
			String totalExpreince = nlp.getValueAtIndex(valuesList, 81); // is the total experience
			System.out.println("total expereince is " + totalExpreince);
			nlp.enterInputIntoElemenet(repo.workDetailsPage.getworkDetailsInputfeildWithName("Total Work Exp"),
					totalExpreince.strip());
			// fill the notice period
			String noticePeroid = nlp.getValueAtIndex(valuesList, 82); // 82 is the notice period
			nlp.Click(repo.workDetailsPage.getworkDetailsInputfeildWithName("Notice Period"));
		//	nlp.enterInputIntoElemenet(repo.workDetailsPage.getworkDetailsInputfeildWithName("Notice Period"),		noticePeroid);
			nlp.Click(repo.workDetailsPage.getjobCityOptionsDropDownWithName(noticePeroid.strip()));
			//////////////
			// fill prefered location
			fillPreferedLocation(valuesList);
			/////////////////////
			// fill prefered anual salary
			String preferedAnualSal = nlp.getValueAtIndex(valuesList, 84);// 84 is the prefered anual salary
			nlp.enterInputIntoElemenet(repo.workDetailsPage.getworkDetailsInputfeildWithName("Preferred Annual Salary"),
					preferedAnualSal);
			// fill prefered work mode
			String prerferedWorkMode = nlp.getValueAtIndex(valuesList, 85);// work mode 85
			nlp.Click(repo.workDetailsPage.getworkDetailsInputfeildWithName("Preferred WorkMode"));
			Thread.sleep(500);
			nlp.enterInputIntoElemenet(repo.workDetailsPage.getworkDetailsInputfeildWithName("Preferred WorkMode"),
					prerferedWorkMode.strip());
			nlp.Click(repo.workDetailsPage.getjobCityOptionsDropDownWithName(prerferedWorkMode.strip()));
			// fill the Preferred Shift
			String preferedShift = nlp.getValueAtIndex(valuesList, 86).strip().toUpperCase();// work mode 86
			String shift = "";
			if (preferedShift.contains("DAY") || preferedShift.contains("General")) {
				shift = "Day";
			} else {
				shift = "Night";
			}
			nlp.Click(repo.workDetailsPage.getworkDetailsInputfeildWithName("Preferred Shift"));
			nlp.enterInputIntoElemenet(repo.workDetailsPage.getworkDetailsInputfeildWithName("Preferred Shift"),
					shift.strip());
			nlp.Click(repo.workDetailsPage.getjobCityOptionsDropDownWithName(shift.strip()));
			/// to fill the anual salary
			String currentAnualSal = nlp.getValueAtIndex(valuesList, 84);// 84 is the prefered anual salary
			nlp.enterInputIntoElemenet(repo.workDetailsPage.getworkDetailsInputfeildWithName("Current Annual Salary"),
					currentAnualSal);

		} else {
			// need to fill the fresher data here
			// need to full prefered location only
			fillPreferedWorLocation(valuesList);
		}
	

	}

	private void fillPreferedWorLocation(ArrayList<String> valuesList) throws Exception {
		String location = nlp.getValueAtIndex(valuesList, 83); // 83 is the prefered location index
		if(location.strip().toUpperCase().equalsIgnoreCase("NA")) {
			nlp.enterInputIntoElemenet(repo.workDetailsPage.getworkDetailsInputfeildWithName("Preferred work location"),
					"Any Location");
			nlp.Click(repo.workDetailsPage.getRequriredDropDownWithName("Any Location"));
			return;
		}
		String[] loc = nlp.convertStringToList(location, ",");
		if (loc[0].equalsIgnoreCase("Any Location")) {
			nlp.enterInputIntoElemenet(repo.workDetailsPage.getworkDetailsInputfeildWithName("Preferred work location"),
					"Any Location");
			nlp.Click(repo.workDetailsPage.getRequriredDropDownWithName("Any Location"));
			return;

		}
		for (int i = 0; i < loc.length; i++) {
			nlp.enterInputIntoElemenet(repo.workDetailsPage.getworkDetailsInputfeildWithName("Preferred work location"),
					loc[i]);

			if (loc[i].equalsIgnoreCase("Bangalore")) {
				nlp.Click(repo.workDetailsPage.getRequriredDropDownWithName("Bangalore Urban"));
				continue;
			}
			if (loc[i].equalsIgnoreCase("Mumbai")) {
				nlp.Click(repo.workDetailsPage.getRequriredDropDownWithName("Mumbai City"));
				continue;
			}
			nlp.Click(repo.workDetailsPage.getRequriredDropDownWithName(loc[i]));
		}

	}

	private void fillPreferedLocation(ArrayList<String> valuesList) throws Exception {
		String location = nlp.getValueAtIndex(valuesList, 83); // 83 is the prefered location index
		String[] loc = nlp.convertStringToList(location, ",");
		if (loc[0].equalsIgnoreCase("Any Location")) {

		}
		for (int i = 0; i < loc.length; i++) {
			nlp.enterInputIntoElemenet(repo.workDetailsPage.getworkDetailsInputfeildWithName("Preferred Location"),
					loc[i]);

			if (loc[i].equalsIgnoreCase("Bangalore")) {
				nlp.Click(repo.workDetailsPage.getRequriredDropDownWithName("Bangalore Urban"));
				continue;
			}
			if (loc[i].equalsIgnoreCase("Mumbai")) {
				nlp.Click(repo.workDetailsPage.getRequriredDropDownWithName("Mumbai City"));
				continue;
			}
			nlp.Click(repo.workDetailsPage.getRequriredDropDownWithName(loc[i]));
		}

	}

	private void fillEducationalDetails(ArrayList<String> valuesList) throws Exception {
		/// now need to enter the educational details
		String higestDegree = nlp.getValueAtIndex(valuesList, 19).toUpperCase();// higest degree index is 19
		higestDegree = higestDegree.toUpperCase();
		String msA = "Master's Degree", degree = "Degree", diplomOrPUCorITI = "Diploma/PUC/ITI", ssc = "SSLC (10th)";
		String ms = msA.toUpperCase();
		String ms1 = "MASTER";
		String degree1 = degree.toUpperCase();
		String diplomOrPUCorITI1 = diplomOrPUCorITI.toUpperCase();
		String ssc1 = ssc.toUpperCase();
		nlp.Click(repo.educationDetailsPage.getHighestEducationInputFiledWithName());
		if (higestDegree.contains(ms) || higestDegree.contains(ms1)) {
//			nlp.Click(repo.educationDetailsPage.getHighestEducationInputFiledWithName());
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getHighestEducationInputFiledWithName(), ms1);
			nlp.Click(repo.educationDetailsPage.getHigestEducationDropDownWithName(msA));// msA means its actual
			// Masters Degree
			sg.educationDetails.fillMasterDegree(valuesList);
			sg.educationDetails.fillDegree(valuesList);
			dipllomoCheckAndFill(valuesList, diplomOrPUCorITI, diplomOrPUCorITI);// it will auto fill the values
		} else if (higestDegree.contains(degree1)) {// if it is degree the we need to fill the degreea and need to fill
													// the values fo diploma or inter or 12 or 12th or puc
//			nlp.Click(repo.educationDetailsPage.getHighestEducationInputFiledWithName());
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getHighestEducationInputFiledWithName(), degree);
			nlp.Click(repo.educationDetailsPage.getHigestEducationDropDownWithName(degree));
			// till here select degree form the drop down
			sg.educationDetails.fillDegree(valuesList);
			dipllomoCheckAndFill(valuesList, diplomOrPUCorITI, diplomOrPUCorITI);

		} else if (higestDegree.contains("DIPLOMA") || higestDegree.contains("PUC") || higestDegree.contains("ITI")
				|| higestDegree.contains("12") || higestDegree.contains("12.00") || higestDegree.contains("12th")) {
//			nlp.Click(repo.educationDetailsPage.getHighestEducationInputFiledWithName());
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getHighestEducationInputFiledWithName(),
					diplomOrPUCorITI);
			nlp.Click(repo.educationDetailsPage.getHigestEducationDropDownWithName(diplomOrPUCorITI));
			dipllomoCheckAndFill(valuesList, diplomOrPUCorITI, diplomOrPUCorITI);

		} else if (higestDegree.contains("SSLC") || higestDegree.contains("SSC")) {
//			nlp.Click(repo.educationDetailsPage.getHighestEducationInputFiledWithName());	
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getHighestEducationInputFiledWithName(), ssc);
			nlp.Click(repo.educationDetailsPage.getHigestEducationDropDownWithName(ssc));
		}

		sg.educationDetails.fillSSC(valuesList);

	}

	private void dipllomoCheckAndFill(ArrayList<String> valuesList, String diplomOrPUCorITI, String diplomOrPUCorITI2)
			throws Exception {

		String diplomaBoard = nlp.getValueAtIndex(valuesList, 42);// diploma board index
		String itiBoard = nlp.getValueAtIndex(valuesList, 49);// ITI board index
		String puc = nlp.getValueAtIndex(valuesList, 56);// 12th or PUC
		if (!diplomaBoard.equalsIgnoreCase("NA")) {// logic to fill diploma

			System.out.println("diploma selected");
			nlp.Click(repo.educationDetailsPage.getDPICheckBoxXpathWithName("diploma"));
			sg.educationDetails.fillDiploma(valuesList);
		}
		if (!itiBoard.equalsIgnoreCase("NA")) {// logic for diploma

			nlp.Click(repo.educationDetailsPage.getDPICheckBoxXpathWithName("iti"));
			sg.educationDetails.fillITI(valuesList);
		}
		if (!puc.equalsIgnoreCase("NA")) {// logic for puc logic

			nlp.Click(repo.educationDetailsPage.getDPICheckBoxXpathWithName("twelfth"));
			sg.educationDetails.fillPUC(valuesList);

		}
		System.out.println(diplomaBoard + " " + itiBoard + " " + puc);

	}

}
