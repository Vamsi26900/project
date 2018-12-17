package Cucumber_Selenium.est;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {
	
	public  WebElement webObject (WebDriver obj, String sheetName, String WebObjName) throws Exception {
		try {
		FileInputStream excelFile = new FileInputStream(new File(Global.pathOR));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheet(sheetName);
        Iterator<Row> iterator = datatypeSheet.iterator();
        		while (iterator.hasNext()) {

            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();
            Cell currentCell1 = cellIterator.next();
            
            if (WebObjName.equals(currentCell1.getStringCellValue())) {
            	int temp = 2;
				WebElement fWebeElement = null;
				boolean foundElement = false;
			for(int j=0;j<2;j++)
			{
					
				for ( int i=1 ; i < 5; i++) {	            
									
					Cell currentCell = currentRow.getCell(i);
							
					//try {Cell currentCell = cellIterator.next();
					
	                //getCellTypeEnum shown as deprecated for version 3.15
	                //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
	                switch (temp) {
					case 2:
						
						try { fWebeElement =    obj.findElement(By.id(currentCell.getStringCellValue()));
						foundElement = true;
						break;
						    }
						catch (Exception e) {
							// TODO: handle exception
							foundElement = false;	
							break;
							
						}
					case 3:
						
						try { fWebeElement =    obj.findElement(By.name(currentCell.getStringCellValue()));
						foundElement = true;
						break;
						    }
						catch (Exception e) {
							// TODO: handle exception
							foundElement = false;	
							break;
							
						}
						
					case 4:
						
						try { fWebeElement =    obj.findElement(By.className(currentCell.getStringCellValue()));
						foundElement = true;
						break;
						    }
						catch (Exception e) {
							// TODO: handle exception
							foundElement = false;	
							break;
							
						}
					case 5:
						
						try {
							
							fWebeElement =    obj.findElement(By.xpath(currentCell.getStringCellValue()));
							foundElement = true;
							break;
						    }
						catch (Exception e) {
							// TODO: handle exception
							foundElement = false;	
							break;
							
						}
					default:
						break;
						
						
					}
	                temp++;
	                currentCell = null; 	                
	                if (foundElement) {
	        			
	        			return fWebeElement;
					}
	            
          
				}
					if(foundElement) break;
					Thread.sleep(Global.standardWait);
					
				}
            }
        }
        
	}
        catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
	finally {} 	
	return null;
		
	}
	
	
	
	public  WebElement webObjectReplaceXpath (WebDriver obj, String sheetName, String WebObjName) throws Exception {
		try {
		FileInputStream excelFile = new FileInputStream(new File(Global.pathOR));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheet(sheetName);
        Iterator<Row> iterator = datatypeSheet.iterator();
        		while (iterator.hasNext()) {
        			
        			Row currentRow = iterator.next();
                    Iterator<Cell> cellIterator = currentRow.iterator();
                    Cell currentCell1 = cellIterator.next();
                    String[] xpathNReplaceData = WebObjName.split(";");
                    if (xpathNReplaceData[0].equals(currentCell1.getStringCellValue())) 
                    	{
                    		Cell currentCell = currentRow.getCell(4);
                    		String xpath = currentCell.getStringCellValue();
                    	
                    		 xpath = xpath.replace("row",xpathNReplaceData[1]).replace("column", xpathNReplaceData[2]);
                    		return obj.findElement(By.xpath(xpath));
							
                    	}
        		}
		}      					
        		catch (Exception e) {
					// TODO: handle exception
					return null;
        			
        		}
		return null;
	
	}
	
}

