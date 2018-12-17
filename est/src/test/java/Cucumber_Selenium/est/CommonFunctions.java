package Cucumber_Selenium.est;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;


public class CommonFunctions {
	
	
	public static  void clickButton(String ObjName,String SheetName,String ReportText,String Data )
	{	
		if (!(Data.equals("SKIP"))) 
		{
			PageObjects objPajeObjects = new PageObjects();
			
			try {objPajeObjects.webObject(StepDefinition.objDriver,SheetName,ObjName).click();
			//takeScreenshot();
			Reporter.writeResults("Pass","Success fully clicked on button"+ReportText);
			}
			
			catch(Exception e){
				takeScreenshot();
				Reporter.writeResults("Fail","Button "+ReportText+" not found on the application");
			}	

		}		

	}
	
	public static  void enterText(String ObjName,String SheetName,String ReportText,String Data )
	{	
		if (!(Data.equals("SKIP"))) 
		{
			PageObjects objPajeObjects = new PageObjects();
			
			try {objPajeObjects.webObject(StepDefinition.objDriver,SheetName,ObjName).sendKeys(Data);
			//takeScreenshot();
			Reporter.writeResults("Pass","Successfully entered on textbox");
			}
			
			catch(Exception e){
				takeScreenshot();
				Reporter.writeResults("Fail","Text box "+ReportText+" not found on the application");
			}	

		}		

	}
	
	public static void  takeScreenshot(){ 
	        try { 
	            Thread.sleep(120); 
	            Robot r = new Robot(); 
	  
	            // It saves screenshot to desired path 
	            String tempPath = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(new Date());
	            String path = Global.screenshotPath+"\\"+tempPath+".jpg"; 
	            
	            // Used to get ScreenSize and capture image 
	            Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
	            BufferedImage Image = r.createScreenCapture(capture); 
	            ImageIO.write(Image, "jpg", new File(path)); 
	            Global.capturedScreenshotpath = "..\\Screeenshots\\"+tempPath+".jpg";
	        } 
	        catch (AWTException | IOException | InterruptedException ex) { 
	            System.out.println(ex); 
	        } 
	    } 
	 
	public static  String getCellDatainTable(String ObjName,String SheetName,String ReportText,String Data )
	{	
		if (!(Data.equals("SKIP"))) 
		{
			PageObjects objPajeObjects = new PageObjects();
			
			try { objPajeObjects.webObjectReplaceXpath(StepDefinition.objDriver,SheetName,ObjName).isDisplayed();
			
			//Assert.assertTrue("Successfully clicked on  "+ReportText, true);
			takeScreenshot();
			Reporter.writeResults("Pass","Success fully clicked on button"+ReportText);
			return objPajeObjects.webObjectReplaceXpath(StepDefinition.objDriver,SheetName,ObjName).getText();
			}
			
			catch(Exception e){
				takeScreenshot();
				Reporter.writeResults("Fail","Button "+ReportText+" not found on the application");
				return null;
			}
		}
		return null;		

	}
	public static  void selectRadio(String ObjName,String SheetName,String ReportText,String Data )
	{	
		if (!(Data.equals("SKIP"))) 
		{
			PageObjects objPajeObjects = new PageObjects();
			
			try {objPajeObjects.webObject(StepDefinition.objDriver,SheetName,ObjName).click();
			
			//Assert.assertTrue("Successfully clicked on  "+ReportText, true);
			takeScreenshot();
			Reporter.writeResults("Pass","Success fully clicked on button"+ReportText);
			}
			
			catch(Exception e){
				takeScreenshot();
				Reporter.writeResults("Fail","Button "+ReportText+" not found on the application");
			}	

		}		

	}
	
	public static  void checkObjectExist(String ObjName,String SheetName,String ReportText,String Data )
	{	
		if ((Data.equals("YES"))) 
		{
			PageObjects objPajeObjects = new PageObjects();
			
			try {objPajeObjects.webObject(StepDefinition.objDriver,SheetName,ObjName).isDisplayed();
			
			//Assert.assertTrue("Successfully clicked on  "+ReportText, true);
			takeScreenshot();
			Reporter.writeResults("Pass","Object "+ReportText+" found on the application");
			}
			
			catch(Exception e){
				takeScreenshot();
				Reporter.writeResults("Fail","Object "+ReportText+"  not found on the application");
			}	

		}	
		
		if ((Data.equals("NO"))) 
		{
			PageObjects objPajeObjects = new PageObjects();
			
			try {objPajeObjects.webObject(StepDefinition.objDriver,SheetName,ObjName).isDisplayed();
			
			//Assert.assertTrue("Successfully clicked on  "+ReportText, true);
			takeScreenshot();
			Reporter.writeResults("Fail","Object "+ReportText+"  found on the application");
			}
			
			catch(Exception e){
				takeScreenshot();
				
				Reporter.writeResults("Pass","Object "+ReportText+"  not found on the application");
			}	

		}		


	}

}
