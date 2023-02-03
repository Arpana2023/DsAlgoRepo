package TestCasesPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.TestBase;
import PagesPackage.GetStartedPage;
import PagesPackage.HomePage;
import UtilPackage.Loggerload;

public class GetStartedTestPage extends TestBase
{
   GetStartedPage getStartedPage;
   HomePage homePage;
   public GetStartedTestPage()
   {
	   super();//This will call super class consrtuctor(Testbase class constructor).It will initialize all the properties in testbase constructor
   }
   @BeforeMethod
   public void setUp()
   {
	   initialization();
	   getStartedPage = new GetStartedPage();
	   homePage = getStartedPage.clickOnGetStarted();

   }
  /* @Test
  / public void getStartedButtonClickTest()
   {
	   homePage = getStartedPage.clickOnGetStarted();
   }*/
   @Test
   public void validateUserLandingHomePageTest()
   {
	  // String HomePageTitle = driver.getTitle();
		  String HomePageTitle = homePage.verifyHomePageTitle();

	   Loggerload.info("User is clicking on GetStarted button on DsAlgo portal Page");
	   Assert.assertEquals(HomePageTitle, "NumpyNinja");
	   System.out.println("###########"+HomePageTitle+"############");
	   
	   
   }
   @AfterMethod
   public void tearDown()
   {
	   driver.quit();
   }
}
