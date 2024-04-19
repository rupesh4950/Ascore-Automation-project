package pom_scripts.stepGroups;

import java.text.DecimalFormat;
import java.util.ArrayList;

import CustomExceptions.CustomException;
import generic.GlobalVariables;

public class EducationDetails extends GlobalVariables {

	public void fillMasterDegree(ArrayList<String> valuesList) throws Exception {
		String dynamicVlaue1 = "masterDegree";
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		String university = nlp.getValueAtIndex(valuesList, 20);// 20 is the university name
		// university="dkgyhbjnkmllj";
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "University"),
				university);
		boolean isDisplayed = false;
		try {
			isDisplayed = nlp.isDisplayed(repo.educationDetailsPage.getRequriredDropDownWithName(university));
			System.out.println(" inside try " + isDisplayed);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(university));
			isDisplayed = true;
		} catch (Exception e) {
			isDisplayed = false;
			nlp.clearTextFromInputField(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "University"));
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "University"),
					"Others");
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName("Others"));
			System.out.println(" inside catch " + isDisplayed);
			nlp.enterInputIntoElemenet(
					repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "University Name"), university);
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// College Name 21 is the index
		// Emntreing college name has two ways if the university is there it will be a
		// drop down if not text feild
		String collegeName = nlp.getValueAtIndex(valuesList, 21);// 21 is the university name
		if (isDisplayed) {
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "College Name"),
					collegeName);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(collegeName));
		} else {
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "College Name"),
					collegeName);
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///// String course name 22
		String courseName = nlp.getValueAtIndex(valuesList, 22);// 22 is the course name
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Course"),
				courseName);
		isDisplayed = false;
		try {
			isDisplayed = nlp.isDisplayed(repo.educationDetailsPage.getRequriredDropDownWithName(courseName));
			System.out.println(" inside try " + isDisplayed);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(courseName));
			isDisplayed = true;
		} catch (Exception e) {
			isDisplayed = false;
			nlp.clearTextFromInputField(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Course"));
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Course"),
					"Others");
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName("Others"));
			System.out.println(" inside catch " + isDisplayed);
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Course Name"),
					courseName);
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////// Specialization 23
		// if course is there it will be dropdown if not it will be textfeild
		String specialization = nlp.getValueAtIndex(valuesList, 23);// 23 is the specilization
		if (isDisplayed) {
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Specialization"),
					specialization);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(specialization));
		} else {
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Specialization"),
					specialization);
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Country 24
		String country = nlp.getValueAtIndex(valuesList, 24);// 24 is the Country
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Country"), country);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(country));

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// State 25
		String state = nlp.getValueAtIndex(valuesList, 25);// 25 is the State
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "State"), state);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(state));

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// City 26
		String city = nlp.getValueAtIndex(valuesList, 26);// 26 is the city
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "City"), city);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(city));

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Percentage / CGPA 27
		String PCGpa = nlp.getValueAtIndex(valuesList, 27);// 27 is the percenteage or cpp
		String[] perValue = checkPercentageOrCgpa(PCGpa);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Percentage / CGPA"),
				perValue[0]);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(perValue[0]));
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getPercentageORCGPAInputFeildWithName(dynamicVlaue1),
				perValue[1]);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Year of Joining 28
		String yearOFJoining = nlp.getValueAtIndex(valuesList, 28);// 28 is the Year of Joining
		yearOFJoining = convertToString(yearOFJoining);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Year of Joining"),
				yearOFJoining);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Year of Passing 29
		String yearOFPassing = nlp.getValueAtIndex(valuesList, 29);// 29 is the Year of Passing
		yearOFPassing = convertToString(yearOFPassing);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Year of Passing"),
				yearOFPassing);
		// Course type
		String presentValue1 = "Regular", actualValue1 = "Full Time";
		String presentValue2 = "", actualValue2 = "Part Time";
		String courseType = nlp.getValueAtIndex(valuesList, 30);// 30 is the Course type
		String val = "";
		if (courseType.toUpperCase().contains(presentValue1.toUpperCase())
				|| courseType.toUpperCase().contains(actualValue1.toUpperCase())) {
			val = actualValue1;
		} else {
			val = actualValue2;
		}
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Course Type"), val);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(val));

	}

	private String convertToString(String text) {
		if (text.contains(".")) {
			int in = text.indexOf('.');
			text = text.substring(0, in);
		}
		System.out.println("inside method " + text);
		return text;

	}

	private String[] checkPercentageOrCgpa(String val) {
		String text = "", type = "";
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			if ((c >= 48 && c < 58) || c == 46) {
				text += c;
			}

		}
		
		if ((Double.parseDouble(text)) < 10) {// its cpga
			DecimalFormat decfor = new DecimalFormat("0.0");
			text = decfor.format((Double.parseDouble(text)));
			System.out.println("its cgpa " + text);
			type = "CGPA";
		} else {
			int i=text.indexOf(".");
			String s=text.substring(i+1);
			if((Integer.parseInt(s)>0)) {
				DecimalFormat decfor = new DecimalFormat("0.00");
				text=decfor.format((Double.parseDouble(text)));
			}
			type = "Percentage";
			
			System.out.println("========================================================================================================");
			System.out.println("type is "+ type +" valuue is "+text);
			System.out.println("========================================================================================================");


		}

		String values[] = { type, text };
		return values;
	}

	public void fillDegree(ArrayList<String> valuesList) throws Exception {
		String dynamicVlaue1 = "degree";
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		String university = nlp.getValueAtIndex(valuesList, 31);// 31 is the university name
		// university="dkgyhbjnkmllj";
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "University"),
				university);
		boolean isDisplayed = false;
		try {
			isDisplayed = nlp.isDisplayed(repo.educationDetailsPage.getRequriredDropDownWithName(university));
			System.out.println(" inside try " + isDisplayed);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(university));
			isDisplayed = true;
		} catch (Exception e) {
			isDisplayed = false;
			nlp.clearTextFromInputField(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "University"));
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "University"),
					"Others");
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName("Others"));
			System.out.println(" inside catch " + isDisplayed);
			nlp.enterInputIntoElemenet(
					repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "University Name"), university);
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// College Name 32 is the index
		// Emntreing college name has two ways if the university is there it will be a
		// drop down if not text feild
		String collegeName = nlp.getValueAtIndex(valuesList, 32);// 32 is the university name
		if (isDisplayed) {
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "College Name"),
					collegeName);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(collegeName));
		} else {
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "College Name"),
					collegeName);
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///// String course name 33
		String courseName = nlp.getValueAtIndex(valuesList, 33);// 33 is the course name
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Course"),
				courseName);
		isDisplayed = false;
		try {
			isDisplayed = nlp.isDisplayed(repo.educationDetailsPage.getRequriredDropDownWithName(courseName));
			System.out.println(" inside try " + isDisplayed);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(courseName));
			isDisplayed = true;
		} catch (Exception e) {
			isDisplayed = false;
			nlp.clearTextFromInputField(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Course"));
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Course"),
					"Others");
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName("Others"));
			System.out.println(" inside catch " + isDisplayed);
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Course Name"),
					courseName);
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////// Specialization 34
		// if course is there it will be dropdown if not it will be textfeild
		String specialization = nlp.getValueAtIndex(valuesList, 34);// 34 is the specilization
		if (isDisplayed) {
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Specialization"),
					specialization);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(specialization));
		} else {
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Specialization"),
					specialization);
		}

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Country 35
		String country = nlp.getValueAtIndex(valuesList, 35);// 35 is the Country
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Country"), country);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(country));

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// State 36
		String state = nlp.getValueAtIndex(valuesList, 36);// 36 is the State
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "State"), state);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(state));

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// City 37
		String city = nlp.getValueAtIndex(valuesList, 37);// 37 is the city
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "City"), city);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(city));

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Percentage / CGPA 38
		String PCGpa = nlp.getValueAtIndex(valuesList, 38);// 38 is the percenteage or cpp
		String[] perValue = checkPercentageOrCgpa(PCGpa);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Percentage / CGPA"),
				perValue[0]);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(perValue[0]));
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getPercentageORCGPAInputFeildWithName(dynamicVlaue1),
				perValue[1]);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Year of Joining 39
		String yearOFJoining = nlp.getValueAtIndex(valuesList, 39);// 39 is the Year of Joining
		yearOFJoining = convertToString(yearOFJoining);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Year of Joining"),
				yearOFJoining);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Year of Passing 40
		String yearOFPassing = nlp.getValueAtIndex(valuesList, 40);// 40 is the Year of Passing
		yearOFPassing = convertToString(yearOFPassing);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Year of Passing"),
				yearOFPassing);
		// Course type 41
		String presentValue1 = "Regular", actualValue1 = "Full Time";
		String presentValue2 = "", actualValue2 = "Part Time";
		String courseType = nlp.getValueAtIndex(valuesList, 41);// 41 is the Course type
		String val = "";
		if (courseType.toUpperCase().contains(presentValue1.toUpperCase())
				|| courseType.toUpperCase().contains(actualValue1.toUpperCase())|| courseType.toUpperCase().contains(("Full-Time").toUpperCase())) {
			val = actualValue1;
		} else {
			val = actualValue2;
		}
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Course Type"), val);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(val));

	}

	public void fillDiploma(ArrayList<String> valuesList) throws Exception {
		String dynamicVlaue1 = "Diploma";
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		String Board = nlp.getValueAtIndex(valuesList, 42);// 42 is the Board

		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Board"), Board);
		boolean isDisplayed = false;
		try {
			isDisplayed = nlp.isDisplayed(repo.educationDetailsPage.getRequriredDropDownWithName(Board));
			System.out.println(" inside try " + isDisplayed);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(Board));
			isDisplayed = true;
		} catch (Exception e) {
			isDisplayed = false;
			nlp.clearTextFromInputField(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Board"));
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Board"),
					"Others");
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName("Others"));
			System.out.println(" inside catch " + isDisplayed);
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Board Name"),
					Board);
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// College Name 43 is the index(diploma college name
		// Emntreing college name has two ways if the university is there it will be a
		// drop down if not text feild
		String collegeName = nlp.getValueAtIndex(valuesList, 43);// 43 is the university name
		if (isDisplayed) {
			nlp.enterInputIntoElemenet(
					repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "College Name"), collegeName);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(collegeName));
		} else {
			nlp.enterInputIntoElemenet(
					repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "College Name"), collegeName);
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		String specialization = nlp.getValueAtIndex(valuesList, 44);// 44 is the specilization

		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Specialization"),
				specialization);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(specialization));
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Percentage / CGPA 45
		String PCGpa = nlp.getValueAtIndex(valuesList, 45);// 45 is the percenteage or cpp
		String[] perValue = checkPercentageOrCgpa(PCGpa);
		nlp.enterInputIntoElemenet(
				repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Percentage / CGPA"), perValue[0]);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(perValue[0]));
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIPercentageORCGPAInputFeildWithName(dynamicVlaue1),
				perValue[1]);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Year of Joining 46
		String yearOFJoining = nlp.getValueAtIndex(valuesList, 46);// 46 is the Year of Joining
		yearOFJoining = convertToString(yearOFJoining);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Year of Joining"),
				yearOFJoining);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Year of Passing 47
		String yearOFPassing = nlp.getValueAtIndex(valuesList, 47);// 47 is the Year of Passing
		yearOFPassing = convertToString(yearOFPassing);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Year of Passing"),
				yearOFPassing);

		// Course type 48
		String presentValue1 = "Regular", actualValue1 = "Full Time";
		String presentValue2 = "", actualValue2 = "Part Time";
		String courseType = nlp.getValueAtIndex(valuesList, 48);// 41 is the Course type
		String val = "";
		if (courseType.toUpperCase().contains(presentValue1.toUpperCase())
				|| courseType.toUpperCase().contains(actualValue1.toUpperCase())) {
			val = actualValue1;
		} else {
			val = actualValue2;
		}
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Course Type"),
				val);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(val));

	}

	public void fillITI(ArrayList<String> valuesList) throws CustomException {
		String dynamicVlaue1 = "ITI";
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		String Board = nlp.getValueAtIndex(valuesList, 49);// 49 is the Board

		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Board"), Board);
		boolean isDisplayed = false;
		try {
			isDisplayed = nlp.isDisplayed(repo.educationDetailsPage.getRequriredDropDownWithName(Board));
			System.out.println(" inside try " + isDisplayed);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(Board));
			isDisplayed = true;
		} catch (Exception e) {
			isDisplayed = false;
			nlp.clearTextFromInputField(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Board"));
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Board"),
					"Others");
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName("Others"));
			System.out.println(" inside catch " + isDisplayed);
			nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Board Name"),
					Board);
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// College Name 50 is the index(diploma college name
		// Emntreing college name has two ways if the university is there it will be a
		// drop down if not text feild
		String collegeName = nlp.getValueAtIndex(valuesList, 50);// 50 is the university name
		if (isDisplayed) {
			nlp.enterInputIntoElemenet(
					repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "College Name"), collegeName);
			nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(collegeName));
		} else {
			nlp.enterInputIntoElemenet(
					repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "College Name"), collegeName);
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		String specialization = nlp.getValueAtIndex(valuesList, 51);// 52 is the specilization

		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Specialization"),
				specialization);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(specialization));
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Percentage / CGPA 52
		String PCGpa = nlp.getValueAtIndex(valuesList, 52);// 52 is the percenteage or cpp
		String[] perValue = checkPercentageOrCgpa(PCGpa);
		nlp.enterInputIntoElemenet(
				repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Percentage / CGPA"), perValue[0]);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(perValue[0]));
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIPercentageORCGPAInputFeildWithName(dynamicVlaue1),
				perValue[1]);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Year of Joining 53
		String yearOFJoining = nlp.getValueAtIndex(valuesList, 53);// 53 is the Year of Joining
		yearOFJoining = convertToString(yearOFJoining);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Year of Joining"),
				yearOFJoining);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Year of Passing 54
		String yearOFPassing = nlp.getValueAtIndex(valuesList, 54);// 54 is the Year of Passing
		yearOFPassing = convertToString(yearOFPassing);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Year of Passing"),
				yearOFPassing);

		// Course type 55
		String presentValue1 = "Regular", actualValue1 = "Full Time";
		String presentValue2 = "", actualValue2 = "Part Time";
		String courseType = nlp.getValueAtIndex(valuesList, 55);// 55 is the Course type
		String val = "";
		if (courseType.toUpperCase().contains(presentValue1.toUpperCase())
				|| courseType.toUpperCase().contains(actualValue1.toUpperCase())) {
			val = actualValue1;
		} else {
			val = actualValue2;
		}
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Course Type"),
				val);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(val));

	}

	public void fillPUC(ArrayList<String> valuesList) throws Exception {
		String dynamicVlaue1 = "PUC";
		// Percentage / CGPA 56
		String PCGpa = nlp.getValueAtIndex(valuesList, 56);// 56 is the percenteage or cpp
		String[] perValue = checkPercentageOrCgpa(PCGpa);
		nlp.enterInputIntoElemenet(
				repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Percentage / CGPA"), perValue[0]);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(perValue[0]));
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIPercentageORCGPAInputFeildWithName(dynamicVlaue1),
				perValue[1]);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Year of Joining 57
		String yearOFJoining = nlp.getValueAtIndex(valuesList, 57);// 57 is the Year of Joining
		yearOFJoining = convertToString(yearOFJoining);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Year of Joining"),
				yearOFJoining);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Year of Passing 58
		String yearOFPassing = nlp.getValueAtIndex(valuesList, 58);// 58 is the Year of Passing
		yearOFPassing = convertToString(yearOFPassing);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getDPIInputFieldWithName(dynamicVlaue1, "Year of Passing"),
				yearOFPassing);

	}

	public void fillSSC(ArrayList<String> valuesList) throws Exception {
		String dynamicVlaue1="sslc";
		// Percentage / CGPA 59
		String PCGpa = nlp.getValueAtIndex(valuesList, 59);// 59 is the percenteage or cpp
		String[] perValue = checkPercentageOrCgpa(PCGpa);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Percentage / CGPA"),
				perValue[0]);
		nlp.Click(repo.educationDetailsPage.getRequriredDropDownWithName(perValue[0]));
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getPercentageORCGPAInputFeildWithName(dynamicVlaue1),
				perValue[1]);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Year of Joining 60
		String yearOFJoining = nlp.getValueAtIndex(valuesList, 60);// 60 is the Year of Joining
		yearOFJoining = convertToString(yearOFJoining);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Year of Joining"),
				yearOFJoining);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Year of Passing 40
		String yearOFPassing = nlp.getValueAtIndex(valuesList, 61);// 61 is the Year of Passing
		yearOFPassing = convertToString(yearOFPassing);
		nlp.enterInputIntoElemenet(repo.educationDetailsPage.getInputFieldWithName(dynamicVlaue1, "Year of Passing"),yearOFPassing);
	}

}
