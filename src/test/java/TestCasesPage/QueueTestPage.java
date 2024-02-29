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
import PagesPackage.QueuePage;
import PagesPackage.SignInPage;
import UtilPackage.Constants;
import UtilPackage.ExcelTestData;
import UtilPackage.Loggerload;
import UtilPackage.TestUtil;
import listenersPackage.AllureReportListener;
@Listeners(AllureReportListener.class)
public class QueueTestPage extends TestBase
{
	GetStartedPage getStartedPage;
    HomePage homePage;
    SignInPage signinPage;
    QueuePage queuePage;
    public QueueTestPage()
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
    	queuePage= new QueuePage(); 
     }
    @DataProvider
   	public Object[][] getLoginData() throws Exception 
       {
   		Object dataTable[][]= ExcelTestData.getDataFromSheet(Constants.excelPath, "Credentials");
   		return dataTable;		
   	}
    @Test(priority=1,dataProvider = "getLoginData",description="Queue page verification")
    //@Description("Queue page verification")
    //@Step("Verifying all links in QueuePage")
    //@Severity(SeverityLevel.NORMAL)
    public void VerifyUserLandedPage(String username,String password) throws IOException, InterruptedException
    {
        //Clicking on Signin link in homePage    
    	homePage.ClickSigninLnk();
        Loggerload.info("User is entering username and password");
        signinPage.LoginUser(username,password);
    
        //Clicking on Queue GetStarted Page in homePage
        homePage.ClickQueueLnk();
        Loggerload.info("Executing test to validate if user landed on Queue Page.");
        Assert.assertEquals(TestUtil.LandedOnCurrentPage(), prop.getProperty("QueueURL"),"User has not landed on QueuePage");
    
        //Clicking on ImplementationQueuePython Link
        queuePage.ClickOnImplementationQueuePythonLink();
        Loggerload.info("Executing test to validate if user landed on Intoduction Page on QueuePage.");
        Assert.assertEquals(TestUtil.TitleOfCurrPage(), "Implementation of Queue in Python");
   
        queuePage.ClickOnTryHere();
        Loggerload.info("Executing test to validate if user landed on Tryhere Page on QueuePage.");
        Assert.assertEquals(TestUtil.TitleOfCurrPage(), "Assessment");
   
      //Entering valid Python code
        ExcelTestData.getDataFromSheet(Constants.excelPath, "Pythoncode Sheet");
        queuePage.enterCode(TestUtil.getCellData("PythonCode", 1, 0)); 
        queuePage.clickBtnRun();
        Loggerload.info("Executing test to validate if user landed on output console on QueuePage.");
        String pytcode = queuePage.validatePythonCodeGotPrinted();
        Assert.assertEquals(pytcode, "Hello Dsalgo");
    
        //Navigating back and and clicking on TypesOfQueueLink
        driver.navigate().back();
    
        queuePage.ClickOnImpCollectionsDequeLink();
        Loggerload.info("Executing test to validate if user landed on Intoduction Page on StackPage.");
        Assert.assertEquals(TestUtil.TitleOfCurrPage(), "Implementation using collections.deque");
   
        queuePage.ClickOnTryHere();
        Loggerload.info("Executing test to validate if user landed on Tryhere Page on StackPage.");
        Assert.assertEquals(TestUtil.TitleOfCurrPage(), "Assessment");
    
      //Entering valid Python code
        //ExcelTestData.getDataFromSheet("src/test/resources/ExcelSheetData/DSAlgo_LoginTestng.xlsx", "Pythoncode Sheet");
        ExcelTestData.getDataFromSheet(Constants.excelPath, "Pythoncode Sheet");

        queuePage.enterCode(TestUtil.getCellData("PythonCode", 1, 0)); 
        queuePage.clickBtnRun();
        Loggerload.info("Executing test to validate if user landed on output console on QueuePage.");
        String pythcode = queuePage.validatePythonCodeGotPrinted();
        Assert.assertEquals(pythcode, "Hello Dsalgo");
            
      //Entering Invalid python code
        queuePage.deletePythoncode();
		ExcelTestData.getDataFromSheet(Constants.excelPath, "Pythoncode Sheet");
		queuePage.enterCode(TestUtil.getCellData("Invalid Pythoncode", 1, 1)); 
		queuePage.clickBtnRun();
        Loggerload.info("Executing test to validate if user entered wrong code on output console on QueuePage.");
        Assert.assertEquals(TestUtil.CaptureWrongPythonCodeError(),"SyntaxError: EOF in multi-line statement on line 2");
        //Assert.assertEquals(TestUtil.CaptureWrongPythonCodeError(),"SyntaxError: bad input on line 1");
  }
  @AfterMethod
  public void teardown()
  {
  	driver.quit();
  }
}
