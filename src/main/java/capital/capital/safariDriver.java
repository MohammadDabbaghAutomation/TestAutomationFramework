package capital.capital;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class safariDriver {
	
	public static WebDriver driverprovider() {
		
		WebDriver driver;
		
		/*
		SafariOptions options = new SafariOptions();
		// options go here
		options.setUseTechnologyPreview(true);
		*/
		
		App.driver = new SafariDriver();
		
		driver = App.driver;
		
		return driver;
	
	}
		
		
}
