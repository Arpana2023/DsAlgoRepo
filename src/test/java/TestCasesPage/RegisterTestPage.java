package TestCasesPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BasePackage.TestBase;
import PagesPackage.GetStartedPage;
import PagesPackage.HomePage;
import PagesPackage.RegisterPage;
import UtilPackage.Constants;
import UtilPackage.ExcelTestData;
import UtilPackage.Loggerload;
import listenersPackage.AllureReportListener;
@Listeners(AllureReportListener.class)
public class RegisterTestPage extends TestBase
{
	GetStartedPage getStartedPage;
    HomePage homePage;
    RegisterPage registerPage;
    SignInTestPage signinTestPage;

    public RegisterTestPage()
    {
    	super();
    }
    @BeforeMethod
    public void setup()
    {
    	initialization();
    	registerPage = new RegisterPage();
    	getStartedPage = new GetStartedPage();
    	homePage = getStartedPage.clickOnGetStarted();//clicking on get started btn and getting homepage in return
    	registerPage = homePage.ClickRegisterLink();
    	
    }
    @DataProvider
	public Object[][] getLoginData() throws Exception {
		Object dataTable[][]= ExcelTestData.getDataFromSheet(Constants.excelPath, "Register");
		return dataTable;		
	}
    /* public void VerifyUserLandedRegisterPageTest()
    {
    	String homeURL = registerPage.LandedRegisterPage();
        Loggerload.info("Executing test to validate if user landed on Register Page.");
        Assert.assertEquals(homeURL, prop.getProperty("register_url"),"User has not landed on RegisterPage");
    }*/
   
    @Test(priority=1)
    public void VerifyUserLandedRegisterPageTest1()
    {
    	String registerPageTitle = registerPage.GetTitleOfCurrentPage();
        Loggerload.info("Executing test to validate if user landed on Register Page.");
        Assert.assertEquals(registerPageTitle, prop.getProperty("registerPage_title"),"User has not landed on RegisterPage");
    }
    @Test(priority=2,dataProvider = "getLoginData")

    public void validateUserNameErrors(String username, String password, String confirmpassword)
    {
         registerPage.enterUserName(username);
         registerPage.enterPwd(password);
         registerPage.enterConfPwd(confirmpassword);
 		
         Loggerload.info("Clicking on Register button");
         registerPage.clickOnRegisterBtn();
         
 		String registermsg = registerPage.RegisterPageCreatedsuccessfully();
        System.out.println("/////"+registermsg);
		Assert.assertTrue(registermsg.contains(prop.getProperty("RegisterSuccessMsg")));	
    	//registerPage.clickOnSinOutLink();
    }
    @Test(priority=3)
    public void ClickRegisterBtnWithEmptyUserNameFieldTest()
    {
    	 Loggerload.info("Clicking on Register button having all fields empty");
    	 registerPage.clickOnRegisterBtn();
    	String emptyFieldUsrname = registerPage.EmptyFieldErrorMsgUsername();
        System.out.println("/////"+emptyFieldUsrname);
        Assert.assertEquals(emptyFieldUsrname,prop.getProperty("FillThisField_msg"));
    }
    @Test(priority=4,dataProvider = "getLoginData")
    public void ClickRegisterBtnWithEmptyPassWordFieldTest(String username, String password, String ConfirmPassword)
    {
    	 Loggerload.info("Clicking on Register button having only usename field");
         registerPage.enterUserName(username);
    	 registerPage.clickOnRegisterBtn();
    	String emptyFieldPassWord = registerPage.EmptyFieldErrorMsgPassWord();
        System.out.println("/////"+emptyFieldPassWord);
        Assert.assertEquals(emptyFieldPassWord,prop.getProperty("FillThisField_msg"));
    }
    @Test(priority=6,dataProvider = "getLoginData")

    public void PasswordLessthan8Characters(String username, String password, String ConfirmPassword)
    {
    	registerPage.enterUserName(username);
    	String WrongPWD= "Project";
        registerPage.enterPwd(WrongPWD);
        registerPage.enterConfPwd(ConfirmPassword);
        registerPage.clickOnRegisterBtn();	
        String PWDMisMatch = registerPage.ConfirmPWDMisMatchError();
        System.out.println("/////"+PWDMisMatch);
         Assert.assertEquals(PWDMisMatch,prop.getProperty("passwrdFldMisMtch"));
    }
    
    /*public void VerifySigninPage()
    {
    	registerPage.ClickSigninLink();
    }*/
	  @AfterMethod
    public void tearDown()
    {
 	   driver.quit();
    }
}
