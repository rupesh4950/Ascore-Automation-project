package pom_scripts.stepGroups;

import java.util.ArrayList;

import CustomExceptions.CustomException;
import generic.GlobalVariables;

import static extentReporter.ExtentLogger.*;



public class Home extends GlobalVariables {
		public void sigin(String email, String password) {
			nlp.Click(repo.homePage.getLogin_textWithName());
			nlp.enterInputIntoElemenet(repo.homePage.getEmail_TextFieldWithName(), email);
			nlp.enterInputIntoElemenet(repo.homePage.getPassword_TextFieldWithName(),password );
			nlp.Click(repo.homePage.getSignIn_ButtonWithName());
		}

}
