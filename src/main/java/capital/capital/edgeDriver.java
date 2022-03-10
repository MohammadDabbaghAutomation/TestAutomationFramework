package capital.capital;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class edgeDriver {
	
	public static WebDriver driverprovider() {
		
		
		WebDriver driver;
		
		WebDriverManager.edgedriver().setup();
		
		driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		
		App.driver = driver;
		
		return driver;
	}

}
