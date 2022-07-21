package capital_UI_Smoke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static capital.capital.App.driver;
import static capital.capital.App.driverprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;

import capital.capital.GlobalVariable;
import capital.PageObjects.loginPage;
import capital.capital.CustomKeywords;

import javax.swing.*;

public class login {
	
	public void log_in() throws InterruptedException, IOException {
		
		// Creating an object for the page class that contains all selectors
		loginPage login = new loginPage(driver);
		
		CustomKeywords CustomKeywords = new CustomKeywords();

		
		driver.manage().window().maximize();

		driver.navigate().to(CustomKeywords.navigateto("retailLogin"));

		login.entersUsername(GlobalVariable.userName);
		login.entersPassword(GlobalVariable.passWord);
		login.clickingOnSubmit();
		login.assertingThatUserIsLoggedin();





//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		Thread.sleep(2000);
//		login.getusername().sendKeys(GlobalVariable.userName);
//		Thread.sleep(1000);
//		login.getpassword().sendKeys(GlobalVariable.passWord);
//		Thread.sleep(1000);
//		login.getsubmit().click();
		/////////////////////////////////////////////////////////////////////////////
		// Homework goes here
		/*
		// Navigate to the website
		driver.navigate().to("https://www.bestbuy.ca/en-ca");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[data-automation='x-search-input']")));
		
		driver.findElement(By.cssSelector("[data-automation='x-search-input']")).sendKeys("ipad"); 
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".autocompleteContent_jYkqN")));
		
		driver.findElement(By.cssSelector(".autocompleteContent_jYkqN [data-automation='autocomplete-entry-0']")).click();
		
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[data-automation='facet'] span")));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".productList_31W-E")));
		
		WebElement products_list_container = driver.findElement(By.cssSelector(".productList_31W-E"));
		
		js.executeScript("arguments[0].scrollIntoView()", products_list_container);
		
		
		List<WebElement> filters_names = new ArrayList();
	
		filters_names = driver.findElements(By.cssSelector(".listItem_K0v0C")); 
		
		WebElement desired_element = null;
		
		for(int x = 0; x < filters_names.size(); x++) {
			
			if(filters_names.get(x).findElement(By.cssSelector("[data-automation='facet'] span")).getText().equalsIgnoreCase("Online Only")) {
				
				desired_element = filters_names.get(x).findElement(By.cssSelector("[type='checkbox']"));
				
				
				
				break;
				
			}
			
		}
		
		js.executeScript("arguments[0].scrollIntoView()", desired_element);
		
		desired_element.click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".pillList_31Ene ul li")));
		
		boolean got_selected = false;
		
		List<WebElement> filters_selected = new ArrayList();
	
		filters_selected = driver.findElements(By.cssSelector(".pillList_31Ene ul li"));
		
		
		for(int f = 0; f<filters_selected.size(); f++) {	
			
			if (filters_selected.get(f).getText().equalsIgnoreCase("Online Only")) {
								
				got_selected = true;
				
				break;
			
		}
		
		
	}
	
		// Assert that the Online Only filter got selected
		Assert.assertTrue(got_selected, "Online Only filetr didn't get selected");
		
		driver.findElements(By.cssSelector("[data-automation='image-slider-test']")).get(0).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type= 'submit']//span[text()='Add to Cart']")));
		
		//add the product to cart
		
		driver.findElement(By.xpath("//button[@type= 'submit']//span[text()='Add to Cart']")).click();	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-automation='view-cart-confirmation']")));
		
		driver.findElement(By.cssSelector("[data-automation='view-cart-confirmation']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-automation='continue-to-checkout']")));
		
		WebElement checkout_button = driver.findElement(By.cssSelector("[data-automation='continue-to-checkout']"));
		
		js.executeScript("arguments[0].scrollIntoView()", checkout_button);
		
		checkout_button.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-automation='guest-continue']")));
		
		driver.findElement(By.cssSelector("[data-automation='guest-continue'] span")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		driver.findElement(By.id("email")).sendKeys("helloItsMe@gmail.com");
		
		driver.findElement(By.id("firstName")).sendKeys("FirstName");
		
		driver.findElement(By.id("lastName")).sendKeys("LastName");
		
		driver.findElement(By.id("phoneNumber")).sendKeys("2262262772");
		
		driver.findElement(By.id("addressLine1")).sendKeys("27 Grandstand Dr");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pcaautocomplete.pcatext .pca.pcalist")));
	
		driver.findElement(By.id("addressLine1")).sendKeys(" ");
		Thread.sleep(1000);
		driver.findElement(By.id("addressLine1")).sendKeys(Keys.chord(" ", Keys.ENTER));
		
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.findElement(By.id("city")).getAttribute("value"), "Binbrook", "The Binbrook did not get filled automatically at the city field");
		
		
		// Here's the code of checking if the city get selected automatically within the drop down list
		
		boolean cityGotSelected = false;
		
				List<WebElement> Selectoptions = new ArrayList();
				
				WebElement ddlselector =  driver.findElement(By.id("regionCode"));
				
				Select select= new Select(ddlselector);
				
				Selectoptions=select.getOptions();
				
				for (int i=0;i<Selectoptions.size();i++) {
					if ((Selectoptions.get(i).getText().equals("Ontario"))) {
						
						if(Selectoptions.get(i).isSelected()) {
							cityGotSelected = true;
							
							break;
						}
						
						}
					}
		
		
				Assert.assertTrue(cityGotSelected, "Ontario city did not get selected automatically");
		
				// The following assertion is for checking if the postal code got filled in automatically within at the field
				Assert.assertEquals(driver.findElement(By.id("postalCode")).getAttribute("value"), "L0R 1C0", "Postal code did not get filled automatically");
				
				// Clicking on Continue button to proceed with payment
				driver.findElement(By.cssSelector("[data-automation='continue-to-payment'] span")).click();
		
				// Checking that the payment details page is open
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shownCardNumber")));
				
				// Filling in the card details
				driver.findElement(By.id("shownCardNumber")).sendKeys("5123456789012346");
				
				driver.findElement(By.id("cvv")).sendKeys("100");
				
				// Clicking on continue which is supposed to navigate you to review order details
				driver.findElement(By.cssSelector("[data-automation='review-order'] span")).click();
				
				// Checking that a message appears warning you that card number you just inserted is expired
				boolean error_message = false;
				String expected_error_msg_text = "The credit card you entered or selected is expired or will expire soon. Please select a different credit card, edit this credit card, or add a new one. (0115)";
				try {
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-automation='error']")));
					
					if(driver.findElement(By.cssSelector("[data-automation='error'] p")).getText().equals(expected_error_msg_text)) {
						error_message = true;
					}
					
				}catch(Throwable T) {
					T.printStackTrace();	
				}
				
				Assert.assertTrue(error_message, "The error message of card expiration didn't get thrown");
	*/


//		driver.navigate().to("https://www.google.com/?hl=en");
//		Thread.sleep(2000);
//		login.insertTextToSearch("trance music");
//		Thread.sleep(2000);
//		login.clickingOnSearchBtn();



	}
	

}
