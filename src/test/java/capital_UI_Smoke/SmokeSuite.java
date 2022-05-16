package capital_UI_Smoke;

//import static drivers_initializer.drivers.SelInstance.getWebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.testng.TestNGException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.agent.builder.AgentBuilder.CircularityLock.Global;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import capital.capital.GlobalVariable;
import capital.capital.CustomKeywords;

public class SmokeSuite extends capital.capital.App{
	
	CustomKeywords CustomKeywords = new CustomKeywords();
	

	String ReportName_with_path;

	ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    
    //helps to generate the logs in test report.
    ExtentTest test;
    String browserName;
    
    // Here we initialize the browser to keep it running all suite running time long
    @Parameters({"OS", "browser", "environment", "credentials"})
    @BeforeSuite
    public void setUp(String OS, String browser, String environment, String credentials)throws Exception{
    	
    	GlobalVariable.OS_Name = OS;
    	GlobalVariable.browserName = browser;	
    	browserName = browser;
    	
    	GlobalVariable.env = environment;
    	GlobalVariable.cred = credentials;
    	CustomKeywords.getUsername();
    	CustomKeywords.getPassword();
    	
    	driver = driverprovider();
    	
    }
    
    @BeforeTest
    public void startReport() {
    	
    	String reportRename = CustomKeywords.getRandomString(16);
    	ReportName_with_path = "/test-output/capital_bank_ui_smoke"+reportRename+".html";
    	
    	// initialize the HtmlReporter
    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +ReportName_with_path);
    	
    	//initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
      //To add system or environment info by using the setSystemInfo method.
        extent.setSystemInfo("OS", GlobalVariable.OS_Name);
        extent.setSystemInfo("Browser",GlobalVariable.browserName);
        
        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Capital Bank Automation Test");
        htmlReporter.config().setReportName("UI Smoke Suite");  // To be changed to the suite name
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        
        htmlReporter.config().getTestViewChartLocation();
        htmlReporter.config().setCSS("css-string");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setJS("js-string");
        htmlReporter.config().setProtocol(Protocol.HTTPS);
        
        htmlReporter.config().setCSS(".node.level-1  ul{ display:none;} .node.level-1.active ul{display:block;}  .card-panel.environment  th:first-child{ width:30%;}");
        htmlReporter.config().setJS("$(window).off(\"keydown\");");
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
    	
    }
    
  
    //This method is to capture the screenshot and return the path of the screenshot.
    
    public static String getScreenhot(String screenshotName, WebDriver driverprovider) throws Exception {
    	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
   		TakesScreenshot ts = (TakesScreenshot) driver;
   		File source = ts.getScreenshotAs(OutputType.FILE);
                   //after execution, you could see a folder "FailedTestsScreenshots" under src folder
   		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
   		File finalDestination = new File(destination);
   		FileUtils.copyFile(source, finalDestination);
   		return destination;
    }
    

    ////////////////////// Creating objects for the test cases /////////////////////////
    
    login login = new login();
    

    /////////////////// Test cases list starts here ///////////////////////////////////

    @Test (priority = 0)
    public void login_test() throws InterruptedException, IOException {
    	test = extent.createTest("Login");
    	login.log_in(js, wait);
    	
    }
    
    /////////////// Here's to get the global variables to their initial values /////////////
	
    @AfterClass 
    public static void resetGlobalVariables() {
    	
    	GlobalVariable.browserName = null;
    	//GlobalVariable.OS_Name = null;
    	
    }
    
    // Listening to the test results goes here
    @AfterMethod
    public void getResult(ITestResult result) throws Throwable {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
            String screenshotPath = getScreenhot(result.getName(), driver);
     
          //To add it in the extent report 
			test.addScreenCaptureFromPath(screenshotPath);
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
    
    
  
    //Either writing or updating test information to reporter
    @AfterTest
    public void tearDown() {
    	extent.flush();	
    }
    
    
    
    
    // Assigning the reports' final paths to reports' global variables
    @AfterSuite
    public void aftersuite() throws IOException {
    	
    	GlobalVariable.smoke_suite_Report_Path = ReportName_with_path;
    	
    	if(GlobalVariable.OS_Name.equalsIgnoreCase("Windows")) {
    	GlobalVariable.smoke_suite_JUnitReport_path = "\\target\\surefire-reports\\junitreports\\TEST-capital_UI_Smoke.SmokeSuite.xml";   
    	}else {
    		GlobalVariable.smoke_suite_JUnitReport_path = "//target//surefire-reports//junitreports//TEST-capital_UI_Smoke.SmokeSuite.xml";   
    	}
    	
    	// Calling the method which replacing the null value by the path value
    	/*String userDirectory = System.getProperty("user.dir");
    	
    	if(GlobalVariable.OS_Name.equals("macOS")){
    	CustomKeywords.replacing_all_suites_names_value(userDirectory+"//suitesNames//suitesReportsPaths.txt", "smokeSuite", ReportName_with_path);
    	}else {
        	CustomKeywords.replacing_all_suites_names_value(userDirectory+"\\suitesNames\\suitesReportsPaths.txt", "smokeSuite", ReportName_with_path);

    	}*/
    	
    	CustomKeywords.replacing_all_suites_names_value_excel("smokeSuite", ReportName_with_path);
    	
    }
	

}
