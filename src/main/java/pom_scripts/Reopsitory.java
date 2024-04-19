package pom_scripts;

import org.openqa.selenium.WebDriver;

import pom_scripts.ProfileUpdate.EducationDetailsPage;
import pom_scripts.ProfileUpdate.PersonalDetailsPage;
import pom_scripts.ProfileUpdate.TechnicalDetailsPage;
import pom_scripts.ProfileUpdate.WorkDetailsPage;

public class Reopsitory {
	public HomePage homePage;
	public ProfileUpdatePage profileUpdatePage;
	public PersonalDetailsPage personalDetailsPage;
	public EducationDetailsPage educationDetailsPage;
	public WorkDetailsPage workDetailsPage;
	public TechnicalDetailsPage technicalDetailsPage;
	public Reopsitory(WebDriver driver){
		homePage=new HomePage(driver);
		profileUpdatePage=new ProfileUpdatePage(driver);
		personalDetailsPage=new PersonalDetailsPage(driver); 
		educationDetailsPage=new EducationDetailsPage(driver);
		workDetailsPage=new WorkDetailsPage(driver);
		technicalDetailsPage=new TechnicalDetailsPage(driver);
		
	}
}
