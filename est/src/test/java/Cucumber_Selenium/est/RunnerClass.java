package Cucumber_Selenium.est;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//MyThread extends Thread{
//	 
//	 public void run()
//	 
//	 {
//		 
//		
//		 
//	 }
//	 
//} 







@RunWith(Cucumber.class)

//@CucumberOptions(
//
//                            features= {"src/test/java/Demo.feature"}
//
//              , plugin={
//            		   "com.cucumber.listener.ExtentCucumberFormatter:html:C:\\Users\\vamsi\\eclipse-workspace\\est\\src\\test\\java\\Cucumber_Selenium\\est\\extent - config.xml"
//                            }
//            		  ,glue = {"Cucumber_Selenium.est"     
//                            
//                            }
//
//     )


//@CucumberOptions(
//		features = "src/test/java/Demo.feature",
//		glue= {"Cucumber_Selenium.est"},
//				plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Reports/ExtentReport/report.html"},
//		monochrome = true
//		)
//@CucumberOptions(
//	    format={"pretty"},
//	    features= "src/test/java/Demo.feature",
//	    	    plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
//
//	    glue = "Cucumber_Selenium.est")




//public class RunnerClass {
//	
//	@AfterClass
//	
//	
//	public static void reportsetup() {
//		
//		Reporter.loadXMLConfig(new File("C:\\Users\\vamsi\\eclipse-workspace\\est\\src\\test\\java\\Cucumber_Selenium\\est\\extent - config.xml"));
//	
//		Reporter.setTestRunnerOutput("PHP Travels");
//		
//		
//	}
	
@CucumberOptions(
		features = "src/test/java/Demo.Feature",
		glue= {"Cucumber_Selenium.est"},
		//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/Reports/ExtentReport/report.html"},
		monochrome = true
		,tags = {"@Test1"}
		)
	 
	 
	public class RunnerClass {
	@AfterClass
	public static void runOnceAfterClass() {
		try {
			Path s = Paths.get(Global.templatePath);
	    	String reportIn = new String(Files.readAllBytes(Paths.get(Global.templatePath)));
	        //for (int i = 0; i < details.size();i++) {
	            reportIn = reportIn.replaceFirst(Global.resultPlaceholder,"");
	       // }
	             
	        String currentDate = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss").format(new Date());
	        String reportPath = Global.pathReportFinal+"\\report_" + currentDate + ".html";
	        Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);
	        
	        Files.delete(s);
	             
	    } catch (Exception e) {
	        System.out.println("Error when writing report file:\n" + e.toString());
	        
	    }
	}
		
	}

	
	






 