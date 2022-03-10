package preconditions;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.xml.sax.SAXException;

import capital.capital.CustomKeywords;
import capital.capital.GlobalVariable;

public class preconditions {
	
	@Parameters("OS")
	@AfterSuite
	public void aftersuite(String OS) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
		
		GlobalVariable.OS_Name = OS;
		
		CustomKeywords CustomKeywords = new CustomKeywords();
		
		String userDirectory = System.getProperty("user.dir");
		
		if(GlobalVariable.OS_Name.equalsIgnoreCase("Windows")) {
			
			CustomKeywords.resetting_all_suites_names(userDirectory+"\\suitesNames\\suitesReportsPaths.txt", "smokeSuite");
			
		}else {
			if(GlobalVariable.OS_Name.equalsIgnoreCase("macOS")) {
				
				CustomKeywords.resetting_all_suites_names(userDirectory+"//suitesNames//suitesReportsPaths.txt", "smokeSuite");
				
			}
		}
		
	}

}
