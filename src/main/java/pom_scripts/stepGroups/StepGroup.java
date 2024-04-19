package pom_scripts.stepGroups;

public class StepGroup {
	public Home home;
	public ProfileDetails profileDetails;
	public PersonalDetails personalDetails;
	public EducationDetails educationDetails;
	public WorkDetails workDetails;
	public StepGroup(){
		 home=new Home();
		 profileDetails=new ProfileDetails();
		 personalDetails=new PersonalDetails();
		 educationDetails=new EducationDetails();
		 workDetails=new WorkDetails();
		 
	}
}
