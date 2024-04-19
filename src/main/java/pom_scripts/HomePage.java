package pom_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.JavaScriptUtil;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	// login text 
	@FindBy(xpath="//div[@class='accGeoNavbar']//label[text()='Login']")
	private WebElement Login_text;
	public WebElement getLogin_text() {
		return Login_text;
	}
	public Object[]  getLogin_textWithName() {
		Object [] l={Login_text,"Login_text"};
		return l ;
	}
	
	// EmailTextFeild
	@FindBy(xpath = "//input[contains(@name,'username')]")
	private WebElement Email_TextField;
	public WebElement getEmail_TextField() {
		return Email_TextField;
	}
	public Object[]  getEmail_TextFieldWithName() {
		Object [] l={Email_TextField,"Email_TextField"};
		return l ;
	}
	// PasswordTExtField
	@FindBy(xpath = "//input[contains(@name,'password')]")
	private WebElement passwordTextField;
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	public Object[]  getPassword_TextFieldWithName() {
		Object [] l={passwordTextField,"password_TextField"};
		return l ;
	}
	
	// SignIN button
	@FindBy(xpath="//div[@class='logInHome']//button[text()='Sign in']")
	private WebElement signIn_Button;
	public WebElement getSignIn_Button() {
		return signIn_Button;
	}
	public Object[]  getSignIn_ButtonWithName() {
		Object [] l={signIn_Button,"password_TextField"};
		return l ;
	}
	
	
	

}
