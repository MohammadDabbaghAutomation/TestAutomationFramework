package APIs_Test.Tavel_insurance;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

import capital.capital.CustomKeywords;

import capital.capital.APIGlobalVariable;
import capital.capital.GlobalVariable;

public class travelInsuranceSuite {

   CustomKeywords CustomKeywords = new CustomKeywords();
   
   String ReportName_with_path;	

	ExtentHtmlReporter htmlReporter;
   ExtentReports extent;
   
   //helps to generate the logs in test report.
   ExtentTest test;
   
   // Report code //
   
   //@Parameters({"OS", "environment", "credentials"})
   @Parameters("OS")
   @BeforeTest
   //public void startReport(String OS, String environment, String credentials) throws IOException, InterruptedException {
   public void startReport(String OS) throws IOException, InterruptedException {
	   
	   GlobalVariable.OS_Name = OS;
	   
	   String reportRename = CustomKeywords.getRandomString(16);
   	//ReportName_with_path = "/target/capital_bank_api_travelInsurance"+reportRename+".html";
       ReportName_with_path = "/target/find_orchards_api"+reportRename+".html";
   	
   	// initialize the HtmlReporter
      
   	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +ReportName_with_path);
   	
       //initialize ExtentReports and attach the HtmlReporter
       extent = new ExtentReports();
       extent.attachReporter(htmlReporter);
        	    
       
       //configuration items to change the look and feel
       //add content, manage tests etc
       htmlReporter.config().setChartVisibilityOnOpen(true);
       htmlReporter.config().setDocumentTitle("REST Assured API Test");
       //htmlReporter.config().setReportName("Travel Insurance Suite");  // To be changed to the suite name
       htmlReporter.config().setReportName("Del Monte APIs suite");  // To be changed to the suite name
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
   

   //////////////////////Creating objects for the test cases./////////////////////////
   
   getCustomerInfo getcustomerinfo = new getCustomerInfo();
   
   postrequestPolicyQuotation postrequestpolicyquotation = new postrequestPolicyQuotation();
   
   postCreatePolicy createpolicy = new postCreatePolicy();

    getJsonScheme getjsonsheme = new getJsonScheme();

    postJsonScheme postjsonscheme = new postJsonScheme();

    patchJsonScheme patchjsonscheme = new patchJsonScheme();

    deleteJsonScheme deletejsonscheme = new deleteJsonScheme();

    PostToken postToken = new PostToken();

   /////////////////// Test cases list starts here///////////////////////////////////
   
/*
   @Test (priority = 0)
   public void customer_info_tc() throws InterruptedException, IOException{
	   test = extent.createTest("Get Customer Information");
	   getcustomerinfo.get_customer_info();
   }

   @Test (priority = 1)
   public void request_policy_quotation() throws InterruptedException, IOException{
	   
	   test = extent.createTest("Post Request Policy Quotation");
	   postrequestpolicyquotation.post_request_policy_quotation();
   }

  @Test (priority = 2)
   public void create_policy() throws InterruptedException, IOException{
	   test = extent.createTest("Post Create Policy");
	   createpolicy.post_create_policy();
	   
   }
*/


    @Test(priority= 2)
    public void post_token() throws InterruptedException, IOException{
        test = extent.createTest("post API for getting access token");
        postToken.postToken();
    }
    @Test(priority= 3) // To be Removed is only for Del Monte
    public void get_json_scheme() throws InterruptedException, IOException {
        test = extent.createTest("get find orchards");
        getjsonsheme.get_Json_Scheme();
    }
//   @Test(priority= 3)
//   public void get_json_scheme() throws InterruptedException, IOException {
//       test = extent.createTest("get Json Scheme");
//       getjsonsheme.get_Json_Scheme();
//   }

//    @Test(priority= 4)
//    public void post_json_scheme() throws InterruptedException, IOException {
//        test = extent.createTest("post Json Scheme");
//        postjsonscheme.post_Json_Scheme();
//    }

//    @Test(priority= 5)
//    public void patch_json_scheme() throws InterruptedException, IOException {
//        test = extent.createTest("patch Json Scheme");
//        patchjsonscheme.patch_Json_Scheme();
//    }
//
//    @Test(priority= 6)
//    public void delete_json_scheme() throws InterruptedException, IOException {
//        test = extent.createTest("delete Json Scheme");
//        deletejsonscheme.delete_Json_Scheme();
//    }

   
   // After test cases running is done 
   
   @AfterMethod	
   public void getResult(ITestResult result) throws Throwable {
		
	   String RequestBody = "Request Body\n"+APIGlobalVariable.requestBody;
	   String responseLabel = "Response Body\n"+APIGlobalVariable.Consol; 
		
       if(result.getStatus() == ITestResult.FAILURE) {
           test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
           test.fail(result.getThrowable());
           test.fail(MarkupHelper.createCodeBlock(RequestBody));
           test.fail(MarkupHelper.createCodeBlock(responseLabel));
       }
       else if(result.getStatus() == ITestResult.SUCCESS) {
           test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
           test.pass(MarkupHelper.createCodeBlock(RequestBody));
           test.pass(MarkupHelper.createCodeBlock(responseLabel));
       }
       else {
           test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
           test.skip(result.getThrowable());
       }
       
       APIGlobalVariable.requestBody =  null;
       APIGlobalVariable.Consol = null;
   }
       
    // Reset APIGlobalVariable.requestBody value
       
       
       @AfterTest
       public void tearDown() {
       	//to write or update test information to reporter
           extent.flush();
       }
       
       @AfterSuite
       public void aftersuite() throws IOException {
    	   
    	   APIGlobalVariable.travelInsurance_Report_Path = ReportName_with_path;
    	  
    	   if(GlobalVariable.OS_Name.equalsIgnoreCase("Windows")) {
    	   APIGlobalVariable.travelInsurance_JUnitReport_Path = "\\target\\surefire-reports\\junitreports\\TEST-APIs_Test.Tavel_insurance.travelInsuranceSuite.xml";
    	   }else {
        	   APIGlobalVariable.travelInsurance_JUnitReport_Path = "//target//surefire-reports//junitreports//TEST-APIs_Test.Tavel_insurance.travelInsuranceSuite.xml";

    	   }
    	   
    	// Calling the method which replacing the null value by the path value
       	/*String userDirectory = System.getProperty("user.dir");
       	
       	if(GlobalVariable.OS_Name.equals("macOS")){
       		CustomKeywords.replacing_all_suites_names_value(userDirectory+"//suitesNames//travelInsurance.txt", "travelInsurance", ReportName_with_path);
       	}else {
       		CustomKeywords.replacing_all_suites_names_value(userDirectory+"\\suitesNames\\travelInsurance.txt", "travelInsurance", ReportName_with_path);
       		
       	}*/
    	   
    	   capital.capital.CustomKeywords.replacing_all_suites_names_value_excel("travelInsurance", ReportName_with_path);
    	   
    	   
       }
   

}
