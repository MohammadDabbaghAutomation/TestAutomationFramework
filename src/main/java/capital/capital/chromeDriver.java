package capital.capital;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chromeDriver {
	
	public static WebDriver driverprovider() {
		
		WebDriver driver;
		
 WebDriverManager.chromedriver().setup();
	     
		 ChromeOptions options = new ChromeOptions();
	     options.addArguments("--start-maximize");
	     options.addArguments("enable-automation");
	     //options.addArguments("--incognito");
	   
	     
	     App.driver = new ChromeDriver(options);  
		      	
	      driver = App.driver;
	      
	      driver.manage().window().maximize();
	     	     
		return driver;
	      
	    
		
	}

}
