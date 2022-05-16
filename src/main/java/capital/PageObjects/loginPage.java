package capital.PageObjects;

//import static capital.capital.App.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;
import java.util.Optional;

public class loginPage {

	WebDriver driver;

	public loginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
		
	}


	// Temp for google

	public WebElement getGoogleSearchField() {

		return googleSearchField;
	}


	@FindBy(css = "input[title='Search']")
	private WebElement googleSearchField;

	public void insertTextToSearch(String textToSeach){
		googleSearchField.sendKeys(textToSeach);
	}


	////////
	@FindBy(css = "input[value='Google Search']")
	private WebElement googleSearchButton;

	public void clickingOnSearchBtn(){
		googleSearchButton.click();
	}

	// This way is to handle verifying non-existing element
	private Optional<WebElement> webElementName(){
		try{
			return Optional.of(driver.findElement(By.cssSelector(".selector")));
		}catch(NoSuchElementException noElement){
			return Optional.empty();
		}
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
