package reportingFunction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JTable;
import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.Jsoup;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.xml.sax.SAXException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import capital.capital.APIGlobalVariable;
import capital.capital.App;
import capital.capital.CustomKeywords;
import capital.capital.GlobalVariable;

public class reportingFunction extends capital.capital.App{
	
	CustomKeywords CustomKeywords = new CustomKeywords();
	
	 String browserName;
	 
	 @Parameters({ "OS", "browser" })
	    @BeforeTest
	    public void startReport(String OS, String browser) {
	    	    	
	    	GlobalVariable.OS_Name = OS;
	    	GlobalVariable.browserName = browser;	
	    	browserName = browser;
	    	
	    	driver = driver;
	    	
	 }
	 
	 
	 @AfterSuite
	  public void aftersuite() throws ParserConfigurationException, SAXException, IOException, InterruptedException {
		 
		 Properties props = new Properties();
     	 
			// this will set host of server- you can change based on your requirement 
			props.put("mail.smtp.host", "smtp.gmail.com");
	 
			// set the port of socket factory 
			props.put("mail.smtp.socketFactory.port", "587"); // 587 for TLS  OR  465 for SSL
				 
			// set socket factory
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
				 
			// set the authentication to true
			props.put("mail.smtp.auth", "true");
				 
			// set the port of SMTP server
			props.put("mail.smtp.port", "587"); //465
						
			props.put("mail.smtp.starttls.enable", true);  // true
	 
			// This will handle the complete authentication
			Session session = Session.getDefaultInstance(props,
	 
					new javax.mail.Authenticator() {
	 
						protected PasswordAuthentication getPasswordAuthentication() {
	 
							return new PasswordAuthentication("sender Email goes here", "password goes here");
	 
						}
	 
					});
	 
			try {
	 
				// Create object of MimeMessage class
				Message message = new MimeMessage(session);
	 
				// Set the from address
				message.setFrom(new InternetAddress("mohammad.d@sitech.me"));
	 
				// Set the recipient address
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("Recipient Email address"));
				
				////////////////// Gmail properties end here ////////////////////
				
				
				// Setting GlobalVariables of Reports' Paths
				String userDirectory = System.getProperty("user.dir");
				/*
				if(GlobalVariable.OS_Name.equalsIgnoreCase("macOS")) {
				GlobalVariable.smoke_suite_Report_Path = CustomKeywords.setting_GBs_suites_pathes(userDirectory+"//suitesNames//suitesReportsPaths.txt", "smokeSuite");
				APIGlobalVariable.travelInsurance_Report_Path = CustomKeywords.setting_GBs_suites_pathes(userDirectory+"//suitesNames//travelInsurance.txt", "apiSuite");
				}else {
					GlobalVariable.smoke_suite_Report_Path = CustomKeywords.setting_GBs_suites_pathes(userDirectory+"\\suitesNames\\suitesReportsPaths.txt", "smokeSuite");
					APIGlobalVariable.travelInsurance_Report_Path = CustomKeywords.setting_GBs_suites_pathes(userDirectory+"\\suitesNames\\travelInsurance.txt", "apiSuite");
				}*/
				
				
				GlobalVariable.smoke_suite_Report_Path = CustomKeywords.setting_GBs_suites_paths_excel("smokeSuite");
				APIGlobalVariable.travelInsurance_Report_Path = CustomKeywords.setting_GBs_suites_paths_excel("travelInsurance");
		 
				
				
				// Mention the file which you want to send
				
				String SS = userDirectory + GlobalVariable.smoke_suite_Report_Path;
				String apiS = userDirectory + APIGlobalVariable.travelInsurance_Report_Path;
				
				
				String SSJR =  userDirectory + GlobalVariable.smoke_suite_JUnitReport_path;
				if(GlobalVariable.OS_Name.equalsIgnoreCase("macOS")) {
					SSJR = SSJR.replace("\\","//");
				}
				
				String apiSJR =  userDirectory + APIGlobalVariable.travelInsurance_JUnitReport_Path;
				if(GlobalVariable.OS_Name.equalsIgnoreCase("macOS")) {
					apiSJR = apiSJR.replace("\\","//");
				}
				
				String reportURL_SS = null;
				String reportURL_apiS = null;
				
				
				// Add the subject link
				message.setSubject("Capital Bank Automation Test Report");
				
				//Multipart multipart = new MimeMultipart();
				
				BodyPart messageBodyPart2 = new MimeBodyPart();
				BodyPart messageBodyPart3 = new MimeBodyPart();
				
				if(!GlobalVariable.smoke_suite_Report_Path.equals("null")) {
				
					// The code of uploading the html report on drive goes here with the use of reportURL_SS
					// reportURL_SS will hold the report url from drive 
					
					// Mention the file which you want to send
					
					//Create another object to add another content
					
					// Create data source and pass the filename
					DataSource source = new FileDataSource(SS);
					// set the handler
					messageBodyPart2.setDataHandler(new DataHandler(source));
		 
					// set the file
					messageBodyPart2.setFileName(SS);
					
					
				}
				
				if(!APIGlobalVariable.travelInsurance_Report_Path.equals("null")) {
					
					// The code of uploading the html report on drive goes here with the use of reportURL_SS
					// reportURL_SS will hold the report url from drive 
					
					// Mention the file which you want to send
					
					//Create another object to add another content
					
					// Create data source and pass the filename
					DataSource source = new FileDataSource(apiS);
					// set the handler
					messageBodyPart3.setDataHandler(new DataHandler(source));
		 
					// set the file
					messageBodyPart3.setFileName(apiS);
					
					
				}
				
				
				
				// Create object to add multimedia type content
				BodyPart messageBodyPart = new MimeBodyPart();
				
				// add body part 1
//				Multipart multipart = new MimeMultipart();
//				multipart.addBodyPart(messageBodyPart2);
//				multipart.addBodyPart(messageBodyPart3);
				
				
				// Collecting suites' results go here
				 
				 String html_fixed_values = "<style>\r\n"
					  		+ "				table, th, td {\r\n"
					  		+ "				  border:1px solid #9F2C83;\r\n"
					  		+ "				}\r\n"
					  		+ "				</style>\r\n"
					  		+ "				<body>\r\n"
					  		+ "\r\n"
					  		+ "				<table style=\"width:50%\">\r\n"
					  		+ "				  <tr>\r\n"
					  		+ "				    <th style= 'color: #9F2C83;'>Suite Name</th>\r\n"
					  		+ "				    <th style= 'color: gray; text-align:center; padding-right: 2px; padding-left: 2px;'>Scenarios</th>\r\n"
					  		+ "				    <th style= 'color: gray; text-align:center; padding-right: 2px; padding-left: 2px;'>Total</th>\r\n"
					  		+ "				    <th style= 'color: green; text-align:center; padding-right: 2px; padding-left: 2px;'>Passed</th>\r\n"
					  		+ "				    <th style= 'color: red; text-align:center; padding-right: 2px; padding-left: 2px;'>Failed</th>\r\n"
					  		+ "				    <th style= 'color: #F6C603; text-align:center; padding-right: 2px; padding-left: 2px;'>Skipped</th>    \r\n"
					  		+ "				    <th style= 'color: black; text-align:center; padding-right: 2px; padding-left: 2px;'>Report Link</th>    \r\n"
					  		+ "				  </tr>\r\n";
				 
				 
				 
				 
				 String html_dynamic_values = " ";
				 
				 if(!GlobalVariable.smoke_suite_Report_Path.equals("null")) {
						reading_junitReports(SSJR);
						reading_HTMLReport(SS);
						
						html_dynamic_values = html_dynamic_values
								+ "				  <tr>\r\n"
						  		+ "				    <td style= 'color: #9F2C83' >capital Smoke Suite</td>\r\n"
						  		+ "				    <td style= 'color: gray'>1</td>\r\n"
						  		+ "				    <td style= 'color: gray'>"+totalTests+"</td>\r\n"
						  		+ "				    <td style= 'color: green'>"+passedTests+"</td>\r\n"
						  		+ "				    <td style= 'color: red'>"+failedTests+"</td>\r\n"
						  		+ "				    <td style= 'color: #F6C603'>"+skippedTests+"</td>    \r\n"
						  		+ "				    <td style= 'color: black'> <a href="+reportURL_SS+">Click here</a></td>    \r\n"
						  		+ "				  </tr>\r\n";
					}
				 
				 if(!APIGlobalVariable.travelInsurance_Report_Path.equals("null")) {
						reading_junitReports(apiSJR);
						reading_HTMLReport(apiS);
						
						html_dynamic_values = html_dynamic_values
								+ "				  <tr>\r\n"
						  		+ "				    <td style= 'color: #9F2C83' >capital APIs Suite</td>\r\n"
						  		+ "				    <td style= 'color: gray'>1</td>\r\n"
						  		+ "				    <td style= 'color: gray'>"+totalTests+"</td>\r\n"
						  		+ "				    <td style= 'color: green'>"+passedTests+"</td>\r\n"
						  		+ "				    <td style= 'color: red'>"+failedTests+"</td>\r\n"
						  		+ "				    <td style= 'color: #F6C603'>"+skippedTests+"</td>    \r\n"
						  		+ "				    <td style= 'color: black'> <a href="+reportURL_apiS+">Click here</a></td>    \r\n"
						  		+ "				  </tr>\r\n";
					}
				 
				 
				 
				 
				 
				 String html_end_of_table  = 
				  		 "				</table>\r\n"
				  		+ "				</body>";
				 
				 messageBodyPart.setContent("<p>Dears,</p>\r\n"+"<p>Here're automation test results of capital bank for your kind perusal.</p>\r\n"+html_fixed_values+html_dynamic_values+html_end_of_table+ "<p>Best regards,</p>"+"<p>SiTech Test Automation Team</p>", "text/html");

				 Multipart multipart = new MimeMultipart();
				 multipart.addBodyPart(messageBodyPart2);
				 //multipart.addBodyPart(messageBodyPart3);
				 multipart.addBodyPart(messageBodyPart);

					
					
					// set the content
				message.setContent(multipart);

									 
					
					// finally send the email

					Transport.send(message);
		 
					System.out.println("\n\n"+" ========== EMAIL HAS BEEN GENERATED AND SENT ========== "+"\n\n");
											
		 
				} catch (MessagingException e) {
		 
					throw new RuntimeException(e);
		 
				}
			
	 }
	 
	 static String totalTests;
		static String passedTests;
		static String failedTests;
		static String skippedTests;
		static JTable container;
		
		public static String reading_HTMLReport(String report_Path){

			// Reading HTML file
			StringBuilder contentBuilder = new StringBuilder();
			try {
			    BufferedReader in = new BufferedReader(new FileReader(report_Path));
			    String str;
			    while ((str = in.readLine()) != null) {
			        contentBuilder.append(str);
			    }
			    in.close();
			} catch (IOException e) {
			}
			String content = contentBuilder.toString();
			
			
			
			 org.jsoup.nodes.Document doc = Jsoup.parse(content);
			JsonObject jsonObject = new JsonObject();
			 JsonArray list = new JsonArray();
			
			 org.jsoup.nodes.Element Script = doc.select("script").get(0);
			 

			 
			 String valueOfPass = Script.toString();
			 
		
			 
			 if (valueOfPass.contains("passParent:")){
				
				 
				 valueOfPass= valueOfPass.split("passParent:")[1];
				 
				  
				 valueOfPass = valueOfPass.replaceFirst(",", "@");
				  
				 valueOfPass = valueOfPass.split("@")[0];
				  
				  System.out.println("valueOfPass is =="+valueOfPass);
				  
				 }
			 
			 
			 String valueOfFail = Script.toString();
			 if (valueOfFail.contains("failParent:")){
				 
				 valueOfFail= valueOfFail.split("failParent:")[1];
				 
				 valueOfFail = valueOfFail.replaceFirst(",", "@");
				  
				 valueOfFail = valueOfFail.split("@")[0];
				  
				  System.out.println("valueOfFail is =="+valueOfFail);
				  			 
			 }
			 
			 
			 /*String valueOfSkip = Script.toString();
			 if (valueOfSkip.contains("skipParent:")){
				//skipParent//exceptionsParent

				 valueOfSkip= valueOfSkip.split("skipParent:")[1];
				 
				 valueOfSkip = valueOfSkip.replaceFirst(",", "@");
				  
				 valueOfSkip = valueOfSkip.split("@")[0];
				  
				  System.out.println("valueOfSkip is =="+valueOfSkip);
			 
			 }*/
			  
			 passedTests = valueOfPass; failedTests = valueOfFail;
			 
			 return "Passed Test Cases: "+valueOfPass + "   / "+"Failed Test Cases: "+valueOfFail;		 
			 
		}
		

		

		////////////////////////////////////////////////////////
		//File file = new File(user_Directory+"\\target\\surefire-reports\\junitreports\\TEST-RESTAssured.Strength_Not_Divisible.Scenario_Strength_Not_Divisible.xml");    
		//NodeList nodeList = (NodeList) ((org.w3c.dom.Document) doc).getElementsByTagName("testsuite");
		
		public static String reading_junitReports(String junitreport_Path)  throws ParserConfigurationException, SAXException, IOException{
			
			 String user_Directory = System.getProperty("user.dir");
			 
			 File xmlFile = new File(junitreport_Path);
			 // Let's get XML file as String using BufferedReader 
			 // FileReader uses platform's default character encoding
			 // if you need to specify a different encoding,
			 // use InputStreamReader
			 Reader fileReader = new FileReader(xmlFile);
			 BufferedReader bufReader = new BufferedReader(fileReader);
			 StringBuilder sb = new StringBuilder();
			 String line = bufReader.readLine();
			 while( line != null){
				 sb.append(line).append("\n"); line = bufReader.readLine();
				 }
			 
			 String xml2String = sb.toString();
			 //System.out.println("XML to String using BufferedReader : ");
			 //System.out.println(xml2String); bufReader.close();
			 
			 String valueOfTests = xml2String;
			 if(valueOfTests.contains("tests=")) {
				 
				 valueOfTests = valueOfTests.split("tests=")[1]; 

				 //System.out.println(valueOfTests);
				 
				 valueOfTests = valueOfTests.replaceFirst("\"", "@"); 
				
				// System.out.println(valueOfTests);
				 
				 valueOfTests = valueOfTests.replaceFirst("@", "").trim();
				 
				 //System.out.println(valueOfTests);
				 
				 valueOfTests = valueOfTests.replaceFirst("\"", "@");
				 
				// System.out.println(valueOfTests);
				 
				 valueOfTests = valueOfTests.split("@")[0];
				 
				 System.out.println("valueOfTests is =="+valueOfTests);
			 }
			 
			 String valueOfFail = xml2String;
			 if(valueOfFail.contains("failures=")) {
				 
				 valueOfFail = valueOfFail.split("failures=")[1];
				 
				 //System.out.println(valueOfFail);
				 
				 valueOfFail = valueOfFail.replaceFirst("\"", "@"); 
				
				 //System.out.println(valueOfFail);
				 
				 valueOfFail = valueOfFail.replaceFirst("@", "").trim();
				 
				 //System.out.println(valueOfFail);
				 
				 valueOfFail = valueOfFail.replaceFirst("\"", "@");
				 
				 //System.out.println(valueOfFail);
				 
				 valueOfFail = valueOfFail.split("@")[0];
				 
				 //System.out.println(valueOfFail);
			 }
			 
			 String valueOfSkip = xml2String;
			 if(valueOfSkip.contains("skipped=")) {
				 
				 valueOfSkip = valueOfSkip.split("skipped=")[1];
				 
				 //System.out.println(valueOfSkip);
				 
				 valueOfSkip = valueOfSkip.replaceFirst("\"", "@"); 
				 
				 //System.out.println(valueOfSkip);
				 
				 valueOfSkip = valueOfSkip.replaceFirst("@", "").trim();
				 
				 //System.out.println(valueOfSkip);
				 
				 valueOfSkip = valueOfSkip.replaceFirst("\"", "@");
				 
				 //System.out.println(valueOfSkip);
				 
				 valueOfSkip = valueOfSkip.split("@")[0];
				 
				 System.out.println("valueOfSkip is =="+valueOfSkip);
			 }
			 
			 totalTests = valueOfTests; skippedTests = valueOfSkip;
			 return "Total Test Cases: "+valueOfTests + "   / "+"Skipped Test Cases: "+valueOfSkip+"   / ";
			 
		  }
	
	
	
	
	

}
