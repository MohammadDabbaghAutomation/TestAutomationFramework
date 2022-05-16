package capital.capital;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import capital.capital.App;

import java.lang.reflect.Method;



public class App {
	
	public static WebDriver driver;

	public JavascriptExecutor js;
	
	public Actions action;
	
	public WebDriverWait wait;
	
	chromeDriver chromedriver = new chromeDriver();
	

	
	public static WebDriver driverprovider() {
		
		switch(GlobalVariable.browserName) {
		
		case"Chrome":
			driver = chromedriver();
			break;
			
		case"Edge":
			driver = edgedriver();
			break;
			
		case "Firefox":
			driver = firefoxdriver();
			break;
			
		case"Safari":
			driver = safaridriver();
			break;
		
		}	
		
		return driver ;
		
	}
	
	
	
	
	private static WebDriver chromedriver() {
		return chromeDriver.driverprovider();
	}
	
	private static WebDriver edgedriver() {
		return edgeDriver.driverprovider();
	}
	
	private static WebDriver firefoxdriver() {
		return firefoxDriver.driverprovider();
	}
	
	private static WebDriver safaridriver() {
		return safariDriver.driverprovider();
	}
	
	
	
	
	
	
	
	
	
	
}
