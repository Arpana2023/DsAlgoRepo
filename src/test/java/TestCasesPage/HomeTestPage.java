package TestCasesPage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.TestBase;
import PagesPackage.GetStartedPage;
import PagesPackage.HomePage;
import PagesPackage.RegisterPage;
import PagesPackage.SignInPage;

public class HomeTestPage extends TestBase
{
    GetStartedPage getStartedPage;
    HomePage homePage;
    SignInPage signInPage;
    RegisterPage registerPage;
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
   @Test
    public void VerifyUserLandedHomePageTest()
    {
    	String homeURL = homePage.LandedHomePage();
    	Assert.assertEquals(homeURL, prop.getProperty("home_url"),"User has not landed on HomePage");
    }
   @Test

    public void VerifyDropDownMenulinkTest()
    {
    	homePage.ClickDropDownMenuLnk();
		//List<String> actualdropdownoptions = homePage.DropdownOptions();
    	String actualdropdownoptions=homePage.DropdownOptions();
    	System.out.println("##########"+actualdropdownoptions+"#########");
//		System.out.println(actualdropdownoptions);
		List expecteddropdownoptions = new ArrayList();
		expecteddropdownoptions.add("Arrays");
		expecteddropdownoptions.add("Linked List");
		expecteddropdownoptions.add("Stack");
		expecteddropdownoptions.add("Queue");
		expecteddropdownoptions.add("Tree");
		expecteddropdownoptions.add("Graph");
		System.out.println("@@@@@@@"+expecteddropdownoptions+"@@@@@@@");

		//Assert.assertEquals(actualdropdownoptions , expecteddropdownoptions,"dropdwn not worked");
		//Assert.assertEquals(dropdownoptions.contains("Linked List"),true);		
    }
    public void loginLnkClickTest()
    {
        signInPage = homePage.ClickLoginUserLnk(); 		
   	}
    public void RegisterLnkClickTest()
    {
        registerPage = homePage.ClickRegisterUserLnk(); 		
   	}
    @AfterMethod
    public void tearDown()
    {
 	   driver.quit();
    }

}
