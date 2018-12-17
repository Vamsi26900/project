package Cucumber_Selenium.est;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gherkin.formatter.model.Scenario;

public class Reporter {
	public static List<Result> details = new ArrayList<Result>();
	public static void report(String actualValue,String expectedValue) {
	    if(actualValue.equals(expectedValue)) {
	        Result r = new Result("Pass","Actual value '" + actualValue + "' matches expected value");
	        details.add(r);
	    } else {
	        Result r = new Result("Fail","Actual value '" + actualValue + "' does not match expected value '" + expectedValue + "'");
	        details.add(r);
	    }
	}
	
	public static void writeResults(String PorF,String Lable) {
	    try {
	    	
	    	Path d = Paths.get(Global.templatePath);
	    	//Path s = Paths.get(Global.templatePathSource);
			if(!(Files.exists(d)))
			{
				Files.createFile(d);
				String report2 = new String(Files.readAllBytes(Paths.get(Global.templatePathSource)));
				Files.write(Paths.get(Global.templatePath),report2.getBytes(),StandardOpenOption.CREATE);
				
			}
			
	    	String reportIn = new String(Files.readAllBytes(Paths.get(Global.templatePath)));
	        
	    	if(PorF.equals("Pass"))
	    	{	
		    	if (!(Global.capturedScreenshotpath.isEmpty()))
		    	{
		    		 reportIn = reportIn.replace(Global.resultPlaceholder,"<tr><td>" + Global.testStepsCount++ + "</td><td>" + "<a href = \""+Global.capturedScreenshotpath+"\" style=\"color:green\" >"+PorF+"</a>" + "</td><td>" + Lable + "</td></tr>" + Global.resultPlaceholder);
		    		 Global.capturedScreenshotpath = "";
		    	}
		    	else {
		            reportIn = reportIn.replaceFirst(Global.resultPlaceholder,"<tr><td>" + Global.testStepsCount++ + "</td><td>" +"<a style=\"color:green\" >"+PorF+"</a>" + "</td><td>" + Lable + "</td></tr>" + Global.resultPlaceholder);
		    		}
	    	}  
	    	
	    	if(PorF.equals("Fail"))
	    	{	
		    	if (!(Global.capturedScreenshotpath.isEmpty()))
		    	{
		    		 reportIn = reportIn.replace(Global.resultPlaceholder,"<tr><td>" + Global.testStepsCount++ + "</td><td>" + "<a href = \""+Global.capturedScreenshotpath+"\" style=\"color:red\" >"+PorF+"</a>" + "</td><td>" + Lable + "</td></tr>" + Global.resultPlaceholder);
		    		 Global.capturedScreenshotpath = "";
		    	}
		    	else {
		            reportIn = reportIn.replaceFirst(Global.resultPlaceholder,"<tr><td>" + Global.testStepsCount++ + "</td><td>" + "<a style=\"color:red\" >"+PorF+"</a>" + "</td><td>" + Lable + "</td></tr>" + Global.resultPlaceholder);
		    		}
	    	}    
	        //String currentDate = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss").format(new Date());
	        String reportPath = Global.templatePath;
	        Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);
	             
	    } catch (Exception e) {
	        System.out.println("Error when writing report file:\n" + e.toString());
	    }
	}
	public static void commitReport()
	{
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
