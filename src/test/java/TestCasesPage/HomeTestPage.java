package TestCasesPage;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BasePackage.TestBase;
import PagesPackage.GetStartedPage;
import PagesPackage.HomePage;
import PagesPackage.RegisterPage;
import PagesPackage.SignInPage;
import UtilPackage.Loggerload;
import UtilPackage.TestUtil;
import listenersPackage.AllureReportListener;
@Listeners(AllureReportListener.class)
public class HomeTestPage extends TestBase
{
	GetStartedPage getStartedPage;
    HomePage homePage;
    SignInPage signInPage;
    RegisterPage registerPage;
    SignInTestPage signInTestPage;
    
    public HomeTestPage()
    {
    	super();
    }
  
    @BeforeMethod
    public void setup()
    {
    	initialization();
    	homePage = new HomePage();
    	getStartedPage = new GetStartedPage();
    	homePage = getStartedPage.clickOnGetStarted();//clicking on get started btn and getting homepage in return
    }
   @Test(priority=1)
    public void VerifyUserLandedHomePageTest()
    {
    	String homeURL = homePage.LandedHomePage();
        Loggerload.info("Executing test to validate if user landed on Home Page.");
    	Assert.assertEquals(homeURL, prop.getProperty("home_url"),"User has not landed on HomePage");
    }
   
   @Test(priority=2)
   public void VerifyDropDownMenulinkTest() throws InterruptedException
    {
    	homePage.ClickDropDownMenuLnk();
    	//ArrayList<String> actualdropdownoptions=homePage.DropdownOptions();
    	List<String> actualdropdownoptions=homePage.DropdownOptions();

    	System.out.println("ActualDropdownList:"+actualdropdownoptions);
    	Thread.sleep(2000);
		List<String> expecteddropdownoptions = new ArrayList<String>();
		expecteddropdownoptions.add("Arrays");
		expecteddropdownoptions.add("Linked List");
		expecteddropdownoptions.add("Stack");
		expecteddropdownoptions.add("Queue");
		expecteddropdownoptions.add("Tree");
		expecteddropdownoptions.add("Graph");
		//System.out.println("ExpectedDropdownList:"+expecteddropdownoptions);
		
		Loggerload.info("Verifying dropdown list is matching the expected dropdown");
        for(int i=0;i<actualdropdownoptions.size();i++) 
        {
		    Assert.assertEquals(actualdropdownoptions.get(i) , expecteddropdownoptions.get(i),"DropDown not worked");
        }
		//Assert.assertEquals(dropdownoptions.contains("Linked List"),true);		
    }
   
   //To verify dropdown displayed and element enabled and login Failure message displayed
   @Test(priority=3)
   public void VerifyClickOnDropDownElementAndLoginFailMsg()
   {
   		homePage.ClickDropDownMenuLnk();	  
	    Loggerload.info("Clicking Array element in dropdown");
	    homePage.ClickArrrayInDropDown();
	    Boolean actualloginFailMsg =homePage.LoginFailMessageInAnyDataStructure();
	    TestUtil.verifyFailMsgafterClickingDropDown(actualloginFailMsg);
	    
	    Loggerload.info("Clicking Linked List element in dropdown");
		homePage.ClickLinkedListInDropDown();
		TestUtil.verifyFailMsgafterClickingDropDown(actualloginFailMsg);

		Loggerload.info("Clicking Stack element in dropdown");
	    homePage.ClickStackInDropDown();
	    TestUtil.verifyFailMsgafterClickingDropDown(actualloginFailMsg);
	
	    Loggerload.info("Clicking Queue element in dropdown");
	    homePage.ClickQueueInDropDown();
	    TestUtil.verifyFailMsgafterClickingDropDown(actualloginFailMsg);

	    Loggerload.info("Clicking Tree element in dropdown");
	    homePage.ClickTreeInDropDown();
	    TestUtil.verifyFailMsgafterClickingDropDown(actualloginFailMsg);
	  
	    Loggerload.info("Clicking Graph element in dropdown");
	    homePage.ClickGraphInDropDown();
	    TestUtil.verifyFailMsgafterClickingDropDown(actualloginFailMsg);
	  
   }
   @Test(priority=4)
 public void VerifyClickingGetstrdInAnyDataStrAndLoginFailMsg()
 {
	   Loggerload.info("Verifying user clicking on Get Started button in DataStructureIntro without signing in");
	   homePage.ClickDataStructureIntroLnk();
	   boolean loginFailMsg =homePage.LoginFailMessageInAnyDataStructure();
	   Assert.assertTrue(loginFailMsg, "LoginFailure message is not displayed");
	     
	   Loggerload.info("Verifying user clicking on Get Started button in Array DataStructure without signing in");
	   homePage.ClickArrayLnk();
       Assert.assertTrue(loginFailMsg, "LoginFailure message is not displayed");
     
       Loggerload.info("Verifying user clicking on Get Started button in LinkedList DataStructure without signing in");
	   homePage.ClickLinkedListLnk();
       Assert.assertTrue(loginFailMsg, "LoginFailure message is not displayed");
     
       Loggerload.info("Verifying user clicking on Get Started button in Stack DataStructure without signing in");
	   homePage.ClickStackLnk();
       Assert.assertTrue(loginFailMsg, "LoginFailure message is not displayed");
     
       Loggerload.info("Verifying user clicking on Get Started button in Queue DataStructure without signing in");
	   homePage.ClickQueueLnk();
       Assert.assertTrue(loginFailMsg, "LoginFailure message is not displayed");
     
       Loggerload.info("Verifying user clicking on Get Started button in Tree DataStructure without signing in");
	   homePage.ClickTreeLnk();
       Assert.assertTrue(loginFailMsg, "LoginFailure message is not displayed");
     
       Loggerload.info("Verifying user clicking on Get Started button in Graph DataStructure without signing in");
	   homePage.ClickGraphLnk();
       Assert.assertTrue(loginFailMsg, "LoginFailure message is not displayed");
 }
    public void SigninLnkClickTest()
    {
        signInPage = homePage.ClickSigninLnk(); 		
   	}
    public void RegisterLnkClickTest()
    {
        registerPage = homePage.ClickRegisterLink(); 		
   	}
    @AfterMethod
    public void tearDown()
    {
 	   driver.quit();
    }
}
