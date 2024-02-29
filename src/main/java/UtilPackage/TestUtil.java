package UtilPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import BasePackage.TestBase;
import PagesPackage.HomePage;

public class TestUtil extends TestBase
{
	static HomePage homePage;
   public static long PAGE_LOAD_TIMEOUT = 20;
   public static long IMPLICIT_WAIT = 10;
   public static String GenerateRandomUsername(String usrname)
   {
 
       Random rnum = new Random();
       String RandUsername=usrname+rnum.nextInt(1000);
       return(RandUsername);
   }
// Method for sending text to a textbox
   public static boolean webSendKeys(WebElement element, String text)
   {
		try {
			WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(10)).
					until(ExpectedConditions.visibilityOf(element));
			
				if(ele.isEnabled()) 
				{
					try 
					{
						ele.clear();
						ele.sendKeys(text);									
						return true;
					}
					catch(Exception e)
					{
						//((JavascriptExecutor) driver).executeScript("arguments[0].value='"+text+"';", ele);
						return false;
					}	
				}
				else 
				{
					throw new Exception("Element is not enabled");
				}
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
   // Method for Clicking webelement
   public static boolean webClick(WebElement element)
   {
		try 
		{
			WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(10)).
					until(ExpectedConditions.visibilityOf(element));
			if(ele.isDisplayed())
  	        {
  		       if(ele.isEnabled())
  		       {
                      ele.click();
				        return true;
                }
  		        else
  		        {
  			       throw new Exception("Element is not Enabled");
  		        }
  	       }
  	       else
		   {
			   throw new Exception("Element is not Displayed");
		   }
  	   
  	    }
  	    catch(Exception e)
  	    {
  		       e.printStackTrace();
  	    }
  	   return false;
     }
 //Method to get data from sheet in excel
   public static String getCellData(String SheetName,int rownum,int colnum) throws IOException
   {
		
		//String path=System.getProperty("user.dir")+"/src/test/resources/ExcelSheetData/DSAlgo_LoginTestng.xlsx";
		String path=System.getProperty("user.dir")+ Constants.excelPath;

		File Excelfile= new File(path);
		
		FileInputStream Fis = new FileInputStream(Excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(Fis);
		XSSFSheet sheet = workbook.getSheet("Pythoncode Sheet");
		XSSFRow row = sheet.getRow(rownum);
		XSSFCell cell = row.getCell(colnum);
	
		DataFormatter formatter=new DataFormatter();
		String data;
		
		try {
			data = formatter.formatCellValue(cell);
			System.out.println(data);
		}
		catch(Exception e)
		{
			data = "";
		}
		workbook.close();
		Fis.close();
		return data;
		}
 //Method to call Title of page
   public static String TitleOfCurrPage()
   {
  	   return driver.getTitle();

   }
   
   public static String LandedOnCurrentPage()
   {
	   return driver.getCurrentUrl();
   }
   public static String CaptureWrongPythonCodeError()
   {
	   Alert alert = driver.switchTo().alert();//switch focus to alert
	   String alertText = driver.switchTo().alert().getText();//get text in alert
	   alert.accept();
       return alertText;
   }
   public static void verifyFailMsgafterClickingDropDown(Boolean actualloginFailMsg)
   {
	   Loggerload.info("Verifying user clicking on DataStructure in dropDownList without signing in");
	   //boolean actualloginFailMsg1 =homePage.LoginFailMessageInAnyDataStructure();
	   //System.out.println("*******"+actualloginFailMsg);
      // Assert.assertEquals(actualloginFailMsg,prop.getProperty("expecloginFailMsg"), "LoginFailure message is not displayed");
	  // Assert.assertTrue(actualloginFailMsg);
   }
}
