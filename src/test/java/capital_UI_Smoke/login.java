package capital_UI_Smoke;

import java.io.IOException;


import static capital.capital.App.driver;
import static capital.capital.App.driverprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import capital.capital.GlobalVariable;
import capital.PageObjects.loginPage;
import capital.capital.CustomKeywords;

public class login {
	
	public void log_in(JavascriptExecutor js, WebDriverWait wait) throws InterruptedException, IOException {
		
		// Creating an object for the page class that contains all selectors
		loginPage login = new loginPage();
		
		CustomKeywords CustomKeywords = new CustomKeywords();
		
		js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		
		driver.navigate().to(CustomKeywords.navigateto("retailLogin"));
		
		Thread.sleep(2000);
		
		login.getusername().sendKeys(GlobalVariable.userName);
		Thread.sleep(1000);
			
		login.getpassword().sendKeys(GlobalVariable.passWord);
		
		Thread.sleep(1000);

		login.getsubmit().click();
		
		
		
		
		
	}
	
	

}
