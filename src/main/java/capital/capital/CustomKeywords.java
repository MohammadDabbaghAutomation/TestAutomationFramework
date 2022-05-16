package capital.capital;

import capital.capital.App;
import static capital.capital.App.driverprovider;
import static capital.capital.App.driver;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.google.common.base.Function;

import java.sql.RowIdLifetime;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.nio.charset.*;
import java.util.*;

public class CustomKeywords extends App{

	public String theuser;
	public String thepass;
	public static String theurl;



	//////////////////////////////

	// Fluent wait for element to be selected
//		public void fluentWaitIsEnabled(final By by) {
//		FluentWait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)
//	    .withTimeout(30, TimeUnit.SECONDS)
//	    .pollingEvery(5, TimeUnit.SECONDS)
//	    .ignoring(NoSuchElementException.class);
//
//	    WebElement groupNameInput = wait2.until(new Function<WebDriver, WebElement>() {
//	    public WebElement apply(WebDriver driver) {
//	    WebElement groupNameInput = driver.findElement(by);
//	    int i = 0;
//	    if(groupNameInput.isSelected()){
//	    return groupNameInput;
//	    }else{
//	    System.out.println("FluentWait IS Enabled Failed"+i++);
//	    return null;
//	    }
//	   }
//	  });
//	}



	//////////////////////////////Waiting Methods //////////////////////////////

	// wait for element to be present
//	public boolean waitForPresence(By by) {
//		wait = new WebDriverWait(driver, 10);
//		boolean elementIsPresent = false;
//		try {
//			wait.until(ExpectedConditions.presenceOfElementLocated(by));
//			elementIsPresent = true;
//		}catch(Throwable t) {
//			t.printStackTrace();
//		}
//		return elementIsPresent;
//	}
//
//	// wait for element to be visible
//	public boolean waitForVisibility(By by) {
//		wait = new WebDriverWait(driver, 10);
//		boolean elementIsVisible = false;
//		try {
//			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
//			elementIsVisible = true;
//		}catch(Throwable t) {
//			t.printStackTrace();
//		}
//
//		return elementIsVisible;
//	}


	////////////////////

	// wait for element to be visible WE
//		public boolean waitForVisibilityWE(WebElement WE) {
//
//			//HomePage homePage = new HomePage();
//			wait = new WebDriverWait(driver, 20);
//			boolean elementIsVisible = false;
//			try {
//				wait.until(ExpectedConditions.visibilityOf(WE));
//				elementIsVisible = true;
//			}catch(Throwable t) {
//				t.printStackTrace();
//			}
//
//			return elementIsVisible;
//		}
//
//	///////////////
//
//
//
//	// wait for element to be invisible
//		public boolean waitForInVisibility(WebElement WE) {
//			wait = new WebDriverWait(driver, 20);
//			boolean elementIsInVisible = false;
//			try {
//				wait.until(ExpectedConditions.invisibilityOf(WE));
//				elementIsInVisible = true;
//			}catch(Throwable t) {
//				t.printStackTrace();
//			}
//
//			return elementIsInVisible;
//		}
//
//		// wait for element to be invisible By
//				public boolean waitForInVisibilityBy(By by) {
//					wait = new WebDriverWait(driver, 20);
//					boolean elementIsInVisible = false;
//					try {
//						wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
//						elementIsInVisible = true;
//					}catch(Throwable t) {
//						t.printStackTrace();
//					}
//
//					return elementIsInVisible;
//				}
//
//	// wait for element to be clickable
//	public boolean waitForElementClickable(WebElement WE) {
//		wait = new WebDriverWait(driver, 10);
//		boolean elementIsclickable = false;
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(WE));
//			elementIsclickable = true;
//		}catch(Throwable t) {
//			t.printStackTrace();
//		}
//		return elementIsclickable;
//	}


	////////////////////////////// Waiting Methods End Here //////////////////////////////




	//////////////////////////////////////////////// Generating random values functions ////////////////////////////////////////////////

	// Generating a random string consisted of chars only from A-Z whether upper or lower case
	public String getRandomString(int i) {

		// bind the length
        //bytearray = new byte[256];
 	   byte[] bytearray = new byte[256];
        String mystring;
        StringBuffer thebuffer;
        String theAlphaNumericS;

        new Random().nextBytes(bytearray);

        mystring = new String(bytearray, Charset.forName("UTF-8"));

        thebuffer = new StringBuffer();

        //remove all spacial char
        theAlphaNumericS = mystring.replaceAll("[^A-Za-z]", "");

        //random selection
        for (int m = 0; m < theAlphaNumericS.length(); m++) {

            if (Character.isLetter(theAlphaNumericS.charAt(m))
                    && (i > 0)
                || Character.isDigit(theAlphaNumericS.charAt(m))
                    && (i > 0)) {

                thebuffer.append(theAlphaNumericS.charAt(m));
                i--;
            }
        }

        // the resulting string

        return thebuffer.toString();

	}

	//////////////////////////////////////////////// Generating random values functions end here




	//////////////////////////////////////////////// Date & Time functions ////////////////////////////////////////////////

	// Getting date with increased one month
	public String getting_date_inFuture_OneMonth() {
		 Date date= new Date();
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 cal.add(Calendar.MONTH, 1);

		 date = cal.getTime();

		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		 return formatter.format(date);
	}


	// Getting date with increased two month
	public String getting_date_inFuture_TwoMonths() {
		 Date date= new Date();
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 cal.add(Calendar.MONTH, 2);

		 date = cal.getTime();

		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		 return formatter.format(date);
	}


	 //DDMMYYYYhhmmssms" For testing only
    public String customTimeStamp() {

    	 Date date= new Date();
    	 long time = date.getTime();
    	 Timestamp ts = new Timestamp(time);
    	 SimpleDateFormat formatter = new SimpleDateFormat("DDMMYYYYhhmmssms");

    	 return formatter.format(ts);
    }



    // Geeting the current time and add an hour
    public String addhourTime() {

    	Date date= new Date();
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	cal.add(Calendar.HOUR_OF_DAY, 1);
    	date = cal.getTime();

    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    	return formatter.format(date);
    }

    //////////////////////////////////////////////// Date & Time functions end here


//////////////////////////////////////////////// Getting Credentials and Urls functions ////////////////////////////////////////////////



	// The following function is for getting the url address for the destination, the destination should be taken from the sheet
    public String navigateto(String Destination) throws IOException, InterruptedException {

    	 String userDirectory = System.getProperty("user.dir");
    	 String filePath = userDirectory + "\\users and urls\\credentials and urls.xlsx"; // For Windows
    	 String tab = null;
    	 if(GlobalVariable.OS_Name.equalsIgnoreCase("macOS")) {
    		 filePath = filePath.replace("\\", "//");
    	 }


    	 switch (GlobalVariable.env) {

    	 case "dev":
    		 tab = "Dev URLs";


    		 break;

    	 case"qa":
    		 tab= "QA URLs";
    		 break;

    	 }


    	 FileInputStream fileXlsx = new FileInputStream(filePath);

    	 XSSFWorkbook workbook = new XSSFWorkbook(fileXlsx);

    	 XSSFSheet sheet = workbook.getSheet(tab);



    	 //////


    	 String urlAddress = null;
    	 boolean rowfound = false;

    	 for(int r = 0; r < sheet.getPhysicalNumberOfRows(); r++) {



			   XSSFRow row = sheet.getRow(r);
			   for(int c = 0; c < row.getPhysicalNumberOfCells(); c++) {


				   XSSFCell cell = row.getCell(c);

				   String  cellValue =null;

				   cell.setCellType(CellType.STRING);

				   cellValue = cell.getStringCellValue();

				   //System.out.println(cellValue);

				   // Checking for desired row

				   if(cellValue.equalsIgnoreCase(Destination)) {

					   //System.out.println(row);

					   rowfound = true;

					   row.getCell(1).setCellType(CellType.STRING);
					   urlAddress = row.getCell(1).getStringCellValue();
					   theurl = urlAddress;
					   System.out.println("The url address value is:  "+urlAddress);

					   break;

				   }


				// Checking for desired row ends here


			   }

			   if (rowfound == true) {
			   break;
			   }
		   }


    	 //////




    	String urladdress = theurl;

		System.out.println(urladdress);

		return urladdress;

    }







    // Returning username only
    public void getUsername() throws IOException, InterruptedException {
    	xlsxReadingForCreds(GlobalVariable.cred);
    	GlobalVariable.userName = theuser;

    }

    // Returning password only
    public void getPassword() throws IOException, InterruptedException {
    	xlsxReadingForCreds(GlobalVariable.cred);
    	GlobalVariable.passWord = thepass;
    }




 // Reading from xlsx file and retrieving username and password
    public void xlsxReadingForCreds(String user) throws IOException, InterruptedException  {

 	   String userDirectory = System.getProperty("user.dir");
 	   String filePath = userDirectory + "\\users and urls\\credentials and urls.xlsx"; //For Windows
 	   if(GlobalVariable.OS_Name.equalsIgnoreCase("macOS")) {
 		  filePath = filePath.replace("\\", "//");
 	   }


 	   FileInputStream fileXlsx = new FileInputStream(filePath);

 	   //System.out.println(filePath);

 	   //System.out.println(fileXlsx);

 	   ////////////////////////////////////
 	   boolean rowfound = false;

 	   String username = null;
 	   String password = null;

 	   ///////////////////////////////////


 	   XSSFWorkbook workbook = new XSSFWorkbook(fileXlsx);

 		   XSSFSheet sheet = workbook.getSheet("Credentials");
 		   for(int r = 0; r < sheet.getPhysicalNumberOfRows(); r++) {



 			   XSSFRow row = sheet.getRow(r);
 			   for(int c = 0; c < row.getPhysicalNumberOfCells(); c++) {


 				   XSSFCell cell = row.getCell(c);

 				   String  cellValue =null;

 				   cell.setCellType(CellType.STRING);

 				   cellValue = cell.getStringCellValue();

 				   //System.out.println(cellValue);

 				   // Checking for desired row

 				   if(cellValue.equalsIgnoreCase(user)) {

 					   //System.out.println(row);

 					   rowfound = true;

 					   row.getCell(1).setCellType(CellType.STRING);
 					   username = row.getCell(1).getStringCellValue();
 					   theuser = username;
 					   System.out.println("Username value is:  "+username);

 					   row.getCell(2).setCellType(CellType.STRING);
 					   password = row.getCell(2).getStringCellValue();
 					   thepass = password;
 					   System.out.println("Password value is:  "+password);

 					   break;

 				   }


 				// Checking for desired row ends here


 			   }

 			   if (rowfound == true) {
 			   break;
 			   }
 		   }


    }

    ////////////////////////////////////////////// Suites Names handling  //////////////////////////////////////////////
	////////////////////////////////////// For Reporting Emails - excel files functions //////////////////////////////////////
	// 3 functions

	public static void resetting_all_suites_names_excel(String suite_name) throws IOException {

		boolean rowfound = false;

		String oldValue="";
		String  suite_value="";

		String userDirectory = System.getProperty("user.dir");
		String filePath = userDirectory + "\\suitesNames\\suiteNames.xlsx"; //For Windows
		if(GlobalVariable.OS_Name.equalsIgnoreCase("macOS")) {
			filePath = filePath.replace("\\", "//");
		}

		FileInputStream fileXlsx = new FileInputStream(filePath);

		XSSFWorkbook workbook = new XSSFWorkbook(fileXlsx);

		XSSFSheet sheet = workbook.getSheet("suites");

		for(int r = 0; r < sheet.getPhysicalNumberOfRows(); r++) {


			XSSFRow row = sheet.getRow(r);

			for(int c = 0; c < row.getPhysicalNumberOfCells(); c++) {

				XSSFCell cell = row.getCell(c);

				String  cellValue =null;

				cell.setCellType(CellType.STRING);

				cellValue = cell.getStringCellValue();

				if(cellValue.equalsIgnoreCase(suite_name)) {

					rowfound = true;

					row.getCell(1).setCellType(CellType.STRING);

					oldValue = row.getCell(1).getStringCellValue();

					System.out.println("oldValue value is:  "+oldValue);

					// Here to reset/overwrite

					row.getCell(1).setCellValue("null");

					suite_value = row.getCell(1).getStringCellValue();
					System.out.println("new suite_value value is:  "+suite_value);

					FileOutputStream out = new FileOutputStream(filePath);

					workbook.write(out);

					out.close();

				}
			}

			if (rowfound == true) {
				break;
			}
		}
	}


	// Replacing null values by new suites paths
	public static void replacing_all_suites_names_value_excel(String suite_name, String suitePath) throws IOException {

		String oldValue="";
		String  suite_value= "";

		boolean rowfound = false;

		String userDirectory = System.getProperty("user.dir");
		String filePath = userDirectory + "\\suitesNames\\suiteNames.xlsx"; //For Windows
		if(GlobalVariable.OS_Name.equalsIgnoreCase("macOS")) {
			filePath = filePath.replace("\\", "//");
		}

		FileInputStream fileXlsx = new FileInputStream(filePath);

		XSSFWorkbook workbook = new XSSFWorkbook(fileXlsx);

		XSSFSheet sheet = workbook.getSheet("suites");

		for(int r = 0; r < sheet.getPhysicalNumberOfRows(); r++) {

			XSSFRow row = sheet.getRow(r);

			for(int c = 0; c < row.getPhysicalNumberOfCells(); c++) {

				XSSFCell cell = row.getCell(c);

				String  cellValue =null;

				cell.setCellType(CellType.STRING);

				cellValue = cell.getStringCellValue();

				if(cellValue.equalsIgnoreCase(suite_name)) {

					rowfound = true;

					row.getCell(1).setCellType(CellType.STRING);

					oldValue = row.getCell(1).getStringCellValue();

					System.out.println("oldValue value is:  "+oldValue);

					// Here to reset/overwrite

					row.getCell(1).setCellValue(suitePath);

					suite_value = row.getCell(1).getStringCellValue();
					System.out.println("new suite_value value is:  "+suite_value);

					FileOutputStream out = new FileOutputStream(filePath);

					workbook.write(out);

					out.close();

				}

			}

			if (rowfound == true) {
				break;
			}
		}
	}



	// Taking the suite paths from the sheet and assign them to the related global variables
	public static String setting_GBs_suites_paths_excel(String suite_name)throws IOException{

		String value="";

		boolean rowfound = false;

		String userDirectory = System.getProperty("user.dir");
		String filePath = userDirectory + "\\suitesNames\\suiteNames.xlsx"; //For Windows
		if(GlobalVariable.OS_Name.equalsIgnoreCase("macOS")) {
			filePath = filePath.replace("\\", "//");
		}

		FileInputStream fileXlsx = new FileInputStream(filePath);

		XSSFWorkbook workbook = new XSSFWorkbook(fileXlsx);

		XSSFSheet sheet = workbook.getSheet("suites");

		for(int r = 0; r < sheet.getPhysicalNumberOfRows(); r++) {

			XSSFRow row = sheet.getRow(r);

			for(int c = 0; c < row.getPhysicalNumberOfCells(); c++) {

				XSSFCell cell = row.getCell(c);

				String  cellValue =null;

				cell.setCellType(CellType.STRING);

				cellValue = cell.getStringCellValue();

				if(cellValue.equalsIgnoreCase(suite_name)) {

					rowfound = true;

					row.getCell(1).setCellType(CellType.STRING);

					value = row.getCell(1).getStringCellValue();

					System.out.println("oldValue value is:  "+value);

					break;

				}

			}

		}


		return value;

	}

	////////////////////////////////////////////// Suites Names handling ends here //////////////////////////////////////////////













	/*
    // The following function is used for after executing the suite  to set suite report path at text file to be an external globalvariable
    public static void replacing_all_suites_names_value(String fileName, String text, String suitePAth) throws IOException {

 	   String oldValue="";
		   String  oldtext ="";
		   String  suite_value= "";


		   String value="";
		   Path path = Paths.get(fileName);
  	   Scanner scanner = new Scanner(path,"UTF-8");

  	   //process each line

  	   while(scanner.hasNextLine()){
  		   String line = scanner.nextLine();

  		   if(line.contains(text)){
  			   value=line.trim().split(":")[1];
  			   if(value.equals("null")) {
  				  suite_value= value.replace(value, suitePAth);
	     			   break;
  			   }

  		   }
  	   }
  	   scanner.close();

  	  try
			{
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				String line = "";
				if((line = reader.readLine()) != null && line.contains(text))
				{
					oldtext += line + "\r\n";
				}
				reader.close();

				//To replace a line in a file
				oldValue=line.split(":")[1];

				System.out.println("oldValue  is  ==  "+oldValue);


				String newtext = oldtext.replace(oldValue+"", suite_value+"");
				System.out.println("newtext is  ==  "+newtext); //I added it
				FileWriter writer = new FileWriter(fileName);
				writer.write(newtext);
				writer.close();



			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}

    }




    ////////////////////////////////////// For Emails txt files functions //////////////////////////////////////

    public static void resetting_all_suites_names(String fileName,String text) throws IOException {

 	   ////////////////////////
		   // Here's the code of increasing the counter for choosing a different row each run
		   // The counter has a public variable located on the top of this class and its value will be taken from txt file
		   String oldValue="";
		   String  oldtext ="";
		   String  suite_value="";


		   String value="";
  	   Path path = Paths.get(fileName);
  	   Scanner scanner = new Scanner(path,"UTF-8");

  	   //process each line

  	  while(scanner.hasNextLine()){

  	   String line = scanner.nextLine();

  		   if(line.contains(text)){
  			   value=line.trim().split(":")[1];
  			  suite_value= value.replace(value, "null");
  			  System.out.println("The line is: "+ line);
  			   break;
  		   }
  	   }
  	   scanner.close();

  	  try
			{
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				String line = "";
				if((line = reader.readLine()) != null && line.contains(text))
				{
					oldtext += line + "\r\n";

				}
				reader.close();

				//To replace a line in a file
				oldValue=line.split(":")[1];

				System.out.println("oldValue  is  ==  "+oldValue);


				String newtext = oldtext.replace(oldValue+"", suite_value+"");
				System.out.println("newtext is  ==  "+newtext);


				FileWriter writer = new FileWriter(fileName);
				writer.write(newtext);
				writer.close();



			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}

    }


    public static String setting_GBs_suites_pathes(String fileName,String text) throws IOException {

 	   ////////////////////////
		   // Here's the code of increasing the counter for choosing a different row each run
		   // The counter has a public variable located on the top of this class and its value will be taken from txt file

		   String value="";
  	   Path path = Paths.get(fileName);
  	   Scanner scanner = new Scanner(path,"UTF-8");

  	   //process each line

  	   while(scanner.hasNextLine()){
  		   String line = scanner.nextLine();

  		   if(line.contains(text)){
  			  value=line.trim().split(":")[1];
  			   break;
  		   }
  	   }
  	   scanner.close();

  	   return value;
}

    */

}
