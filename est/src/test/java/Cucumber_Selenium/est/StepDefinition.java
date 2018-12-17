package Cucumber_Selenium.est;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.deps.com.thoughtworks.xstream.io.path.Path;

public class StepDefinition {
	List<Result> details = new ArrayList<Result>();
	public static WebDriver objDriver = null;
	PageObjects objPajeObjects = new PageObjects();
	
	@Parameters("browser")
	@BeforeClass 
	@Given("^PHP Travels URL opened$")
	public void url_opened(String browser) throws Throwable {
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",Global.pathWebdrriver);

			objDriver = new ChromeDriver();			 
			  }else if (browser.equalsIgnoreCase("firefox")) { 
			 
			   // Here I am setting up the path for my IEDriver
				  Thread.sleep(6000);
			   System.setProperty("webdriver.gecko.driver", "E:\\Eclipse\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			 
			   objDriver = new FirefoxDriver();
			 
			  } 
		

		objDriver.manage().window().maximize();
		//ExpectedConditions.element
		objDriver.get("https://phptravels.org/clientarea.php");
		 String currentDate = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss").format(new Date());
		 String pathcurrentDate = ".\\TestReports\\"+currentDate;
		 //Global.pathReportFinal
		 try {
		
			 new File(pathcurrentDate).mkdirs();
			 new File(pathcurrentDate+"\\Screeenshots").mkdirs();
			 new File(pathcurrentDate+"\\Html").mkdirs();
			 new File(pathcurrentDate+"\\Html\\TestReport.txt");
			 //pathcurrentDate+"\\Html\\report_temp.txt"
			 
			 Global.screenshotPath = pathcurrentDate+"\\Screeenshots";
			 Global.pathReportFinal = pathcurrentDate+"\\Html\\";	
			 Global.templatePath = pathcurrentDate+"\\Temp.txt";
		 }
		 catch(Exception e)
		 {
			 
			 System.out.println("Error while creating files");
		 }

	}
	@Test (priority = 5)
	@Then("^Close browser$")
	public void close_browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
		objDriver.close();
		objDriver.quit();
		
	}
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
		 
        return new Object[][] { { "vamsi2787@gmail.com", "Vamsi22338" }};
 
  }
	
	@Test (priority = 2, dataProvider = "Authentication")
	@Then("^enter Valid user\"([^\"]*)\" and \"([^\"]*)\"$")
	//public void enter_Valid_user_and(String UserName, String Password) throws Throwable {
		
		public void enter_Valid_user_and(String sUsername, String sPassword) throws Throwable {
		//objPajeObjects.webObject(objDriver, "Sheet1", "WEDT_UserName").sendKeys(UserName);

		CommonFunctions.enterText("WEDT_UserName", "Sheet1", "username", sUsername);
		Thread.sleep(1000);
		CommonFunctions.enterText("WEDT_Password", "Sheet1", "Password", sPassword);
		Thread.sleep(1000);
		//objPajeObjects.webObject(objDriver, "Sheet1", "WEDT_Password").sendKeys(Password);
		Thread.sleep(2000);
		CommonFunctions.clickButton("WBTN_Login", "Sheet1", "Login", "CLICK");
		// objPajeObjects.webObject(objDriver,"Sheet1","WBTN_Login").click();
		Thread.sleep(2000);
		CommonFunctions.clickButton("WLNK_Invoice", "Sheet1", "Invoice", "CLICK");
		System.out.println(CommonFunctions.getCellDatainTable("WTBL_Invoice;1;1", "Sheet1","Table Data", "CLICK"));
	}
	@Test (priority = 4)
	@Then("^End of Scenario$")
	public void end_of_Scenario() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//new Reporter().commitReport();
	    
	}
	@Test (priority = 3)
	@Then("^Create Order$")
	public void create_Order() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		CommonFunctions.clickButton("wlnk_Home", "Sheet1", "Home", "CLICK");
		//Thread.sleep(2000);
		CommonFunctions.clickButton("WLNK_OrderNewServices", "Sheet1", "Oreder New Service", "CLICK");
		//Thread.sleep(3000);
		CommonFunctions.clickButton("WRD_complete", "Sheet1", "Complete", "CLICK");
		//Thread.sleep(2000);
		CommonFunctions.clickButton("WLK_continue", "Sheet1", "Contine", "CLICK");
		//Thread.sleep(2000);
		CommonFunctions.clickButton("WCB_Additional", "Sheet1", "Additional", "CLICK");
		//Thread.sleep(2000);
		CommonFunctions.clickButton("WLK_continue", "Sheet1", "Complete", "CLICK");
		CommonFunctions.clickButton("WBT_checkout", "Sheet1", "Checkout", "CLICK");
		CommonFunctions.clickButton("WBT_completeOrder", "Sheet1", "complete order", "CLICK");
		CommonFunctions.clickButton("WBT_PayNow", "Sheet1", "Pay Now", "CLICK");
		CommonFunctions.checkObjectExist("WBT_PayPal", "Sheet1", "Pay pal", "NO");
		CommonFunctions.clickButton("WBT_PayPal", "Sheet1", "Pay pal", "CLICK");
	}
	
	@Test(priority = 8)
	public static void runOnceAfterClass() {
		try {
			java.nio.file.Path s =  Paths.get(Global.templatePath);
	    	String reportIn = new String(Files.readAllBytes(Paths.get(Global.templatePath)));
	        //for (int i = 0; i < details.size();i++) {
	            reportIn = reportIn.replaceFirst(Global.resultPlaceholder,"");
	       // }
	             
	        String currentDate = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss").format(new Date());
	        String reportPath = Global.pathReportFinal+"\\report_" + currentDate + ".html";
	        Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);
	        
	        Files.delete((java.nio.file.Path) s);
	             
	    } catch (Exception e) {
	        System.out.println("Error when writing report file:\n" + e.toString());
	        
	    }
	}
}

