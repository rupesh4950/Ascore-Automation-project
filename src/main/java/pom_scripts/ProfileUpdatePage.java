package pom_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileUpdatePage extends BasePage{

	public ProfileUpdatePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Acrossgeo_Image
	@FindBy(xpath="//*[@class=\"app-navbar\"]/div//img")
	private WebElement Acrossgeo_Image;
	public WebElement getAcrossgeo_Image() {
		return Acrossgeo_Image;
	}
	public Object[]  getAcrossgeo_ImageWithName() {
		Object [] l={Acrossgeo_Image,"Acrossgeo_Image"};
		return l ;
	}
	
	// Next button
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(),'Next')]")
	private WebElement Next_Button;
	public WebElement getNext_Button() {
		return Next_Button;
	}
	public Object[]  getNext_ButtonWithName() {
		Object [] l={Next_Button,"Next_Button"};
		return l ;
	}
	
	// add button
	@FindBy(xpath="//button[text()='ADD']")
	private WebElement Add_Button;
	public WebElement getAdd_Button() {
		return Add_Button;
	}
	public Object[]  getAdd_ButtonWithName() {
		Object [] l={Add_Button,"Next_Button"};
		return l ;
	}

}
