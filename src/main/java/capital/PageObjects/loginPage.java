package capital.PageObjects;

import static capital.capital.App.driver;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	public loginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	// Here's getting the selector using Page Factory methodology and the selectors get retrieved as WebElement type  
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(css = "[type = submit]")
	private WebElement submit;
	

	// Getters go here
	
	public WebElement getusername() {
		return username;
	}
	
	public WebElement getpassword() {
		return password;
	}
	
	public WebElement getsubmit() {
		return submit;
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	// Another way of getting selectors, it depends on getting them as By type
	
	private static By selector = null;
	
	
	public static By username() {
		selector = (By.id("username"));
		return selector;
	}
	
	public static By password() {
		selector = (By.id("password"));
		return selector;
	}
	
	public static By submit() {
		selector = (By.cssSelector("[type = submit]"));
		return selector;
	}
	
	
	
	
	
	
	

}
