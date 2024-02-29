package TestCasesPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BasePackage.TestBase;
import PagesPackage.GetStartedPage;
import PagesPackage.HomePage;
import PagesPackage.SignInPage;
import PagesPackage.StackPage;
import UtilPackage.Constants;
import UtilPackage.ExcelTestData;
import UtilPackage.Loggerload;
import UtilPackage.TestUtil;
import listenersPackage.AllureReportListener;
@Listeners(AllureReportListener.class)
public class StackTestPage extends TestBase
{
	GetStartedPage getStartedPage;
    HomePage homePage;
    SignInPage signinPage;
    StackPage stackPage;
    public StackTestPage()
    {
    	super();
    }
    @BeforeMethod
    public void setup()
    {
    	initialization();
    	signinPage = new SignInPage();
    	getStartedPage = new GetStartedPage();
    	homePage = new HomePage();
    	homePage = getStartedPage.clickOnGetStarted();//clicking on get started btn and getting homepage in return
    	stackPage= new StackPage(); 
}
    @DataProvider
	public Object[][] getLoginData() throws Exception 
    {
		Object dataTable[][]= ExcelTestData.getDataFromSheet(Constants.excelPath, "Credentials");
		return dataTable;		
	}
    
    @Test(priority=1,dataProvider = "getLoginData",description="Stack page verification")
    //@Description("Stack page verification")
    //@Step("Verifying all links in StackPage")
    //@Severity(SeverityLevel.NORMAL)
    public void VerifyUserLandedStackPage(String username,String password) throws IOException
    {
        //Clicking on Signin link in homePage    
    	homePage.ClickSigninLnk();
        Loggerload.info("User is entering username and password");
        signinPage.LoginUser(username,password);
    
  //Clicking on Stack GetStarted Page in homePage
    homePage.ClickStackLnk();
    Loggerload.info("Executing test to validate if user landed on Stack Page.");
    Assert.assertEquals(TestUtil.LandedOnCurrentPage(), prop.getProperty("StackURL"),"User has not landed on LinkedListPage");
    
    //Clicking on Operationsinstack Link
    stackPage.ClickOnOperationsInStackLnk();
    Loggerload.info("Executing test to validate if user landed on Intoduction Page on StackPage.");
    Assert.assertEquals(TestUtil.TitleOfCurrPage(), "Operations in Stack");
    
    stackPage.ClickOnTryHere();
    Loggerload.info("Executing test to validate if user landed on Tryhere Page on StackPage.");
     Assert.assertEquals(TestUtil.TitleOfCurrPage(), "Assessment");
     
     ExcelTestData.getDataFromSheet(Constants.excelPath, "Pythoncode Sheet");
     stackPage.enterCode(TestUtil.getCellData("PythonCode", 1, 0)); 
     stackPage.clickBtnRun();
      Loggerload.info("Executing test to validate if user landed on output console on StackPage.");
     String pytcode = stackPage.validatePythonCodeGotPrinted();
     Assert.assertEquals(pytcode, "Hello Dsalgo");
     
     //Navigating back and and clicking on TypesOfLinkedListLink
     driver.navigate().back();
     

    stackPage.ClickOnImplementationLnk();
    Loggerload.info("Executing test to validate if user landed on Intoduction Page on StackPage.");
    Assert.assertEquals(TestUtil.TitleOfCurrPage(), "Implementation");
   
    stackPage.ClickOnTryHere();
    Loggerload.info("Executing test to validate if user landed on Tryhere Page on StackPage.");
     Assert.assertEquals(TestUtil.TitleOfCurrPage(), "Assessment");

     ExcelTestData.getDataFromSheet(Constants.excelPath, "Pythoncode Sheet");
     stackPage.enterCode(TestUtil.getCellData("PythonCode", 1, 0)); 
     stackPage.clickBtnRun();
      Loggerload.info("Executing test to validate if user landed on output console on StackPage.");
     String pythcode = stackPage.validatePythonCodeGotPrinted();
     Assert.assertEquals(pythcode, "Hello Dsalgo");
     
     
    //Entering Invalid python code
     stackPage.deletePythoncode();
		ExcelTestData.getDataFromSheet(Constants.excelPath, "Pythoncode Sheet");
		stackPage.enterCode(TestUtil.getCellData("Invalid Pythoncode", 1, 1)); 
		stackPage.clickBtnRun();
      Loggerload.info("Executing test to validate if user entered wrong code on output console on QueuePage.");
      Assert.assertEquals(TestUtil.CaptureWrongPythonCodeError(),"SyntaxError: EOF in multi-line statement on line 2");
      //Assert.assertEquals(TestUtil.CaptureWrongPythonCodeError(),"SyntaxError: bad input on line 1");
    }  
    @AfterMethod
    public void tearDown()
    {
 	   driver.quit();
    }
}
