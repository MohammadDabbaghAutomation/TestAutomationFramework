package capital.capital;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class firefoxDriver {
	
	public static WebDriver driverprovider() {
		
		WebDriver firefoxdriver;
		
		WebDriverManager.firefoxdriver().setup();

		firefoxdriver = new FirefoxDriver();
		firefoxdriver.manage().window().maximize();
			
		App.driver = firefoxdriver;
			
		return firefoxdriver;
		
	}

}
