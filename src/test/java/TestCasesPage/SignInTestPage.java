package TestCasesPage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.TestBase;
import PagesPackage.GetStartedPage;
import PagesPackage.HomePage;
import PagesPackage.RegisterPage;
import PagesPackage.SignInPage;
import UtilPackage.ExcelTestData;
import UtilPackage.Loggerload;
public class SignInTestPage extends TestBase
{
	GetStartedPage getStartedPage;
	HomePage homePage;
	RegisterPage registerPage;
	SignInPage signinPage;
	public SignInTestPage()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		signinPage = new SignInPage();
		getStartedPage = new GetStartedPage();
		homePage = getStartedPage.clickOnGetStarted();
		signinPage = homePage.ClickSigninLnk();	
	}
	@DataProvider
	public Object[][] getLoginData() throws IOException
	{
		Object dataTable[][] = ExcelTestData.getDataFromSheet("/src/test/resources/ExcelSheetData/DSAlgo_LoginTestng.xlsx", "Credentials");
		return dataTable;
	}
	@Test(priority=1)
	public void VerifyUserLandedLoginPageTest()
	{
		String LoginPageTitle = signinPage.getTitleOfCurrentPage();
		Loggerload.info("Executing test to validate if user landed on Signin Page");
		Assert.assertEquals(LoginPageTitle, prop.getProperty("Page_title"),"User has not landed on LoginPage");
	}
	@Test(priority=2, dataProvider = "getLoginData")

	public void verifyingValidUsrnameAndPwd(String username, String password)
	{
		signinPage.enterUsername(username);
		signinPage.enterPassword(password);
		Loggerload.info("Clicking on Login button");
		signinPage.clickLoginBtnLoginPage();
		
		String signinsuccessmsg =signinPage.LoginPageCreatedSuccessfully();
		System.out.println(signinsuccessmsg);
		Assert.assertTrue(signinsuccessmsg.contains(prop.getProperty("loginSucessMsg")));
	}
	@Test(priority=3)
	public void ClickSignInBtbWithUserNameFieldEmpty() 
	{
		Loggerload.info("Clicking on Signin button having all fields empty");
		signinPage.clickLoginBtnLoginPage();
		String emptyFieldUsrname = signinPage.EmptyFieldErrorMsgUsername();
		Assert.assertEquals(emptyFieldUsrname,prop.getProperty("FillThisField_msg"));
	}
	@Test(priority=4, dataProvider = "getLoginData")
	public void ClickSignInBtnWithPasswordFieldEmpty(String username, String password)
	{
		Loggerload.info("Clicking on Login button having only username field");
		signinPage.enterUsername(username);
		signinPage.clickLoginBtnLoginPage();
		String emptyFieldPassword = signinPage.EmptyFieldErrorMsgPassword();
		Assert.assertEquals(emptyFieldPassword,prop.getProperty("FillThisField_msg"));
	}
	@Test(priority=5)
	public void TestingInvalidUsrnameInvalidPwd()
	{
		signinPage.enterUsername("dsffld");
		signinPage.enterPassword("JFjdi");
		signinPage.clickLoginBtnLoginPage();
		String InvalidMsg = signinPage.InvalidUsernamePasswordMsg();
		Assert.assertEquals(InvalidMsg, prop.getProperty("InvalidUsrnamePwd_Msg"));
	}
	@Test(priority=6, dataProvider = "getLoginData")
	public void TestingInvalidUsrnameValidPwd(String username, String password)
	{
		String InvalidUsrname = "fgtrdx";
		signinPage.enterUsername(InvalidUsrname);
		signinPage.enterPassword(password);
		signinPage.clickLoginBtnLoginPage();
		String InvalidMsg = signinPage.InvalidUsernamePasswordMsg();
		Assert.assertEquals(InvalidMsg, prop.getProperty("InvalidUsrnamePwd_Msg"));
	}
	@Test(priority=7, dataProvider = "getLoginData")
	public void TestingValidUsrnameInValidPwd(String username, String password)
	{
		signinPage.enterUsername(username);
		String InvalidPwd = "fgtrdx";
		signinPage.enterPassword(InvalidPwd);
		signinPage.clickLoginBtnLoginPage();
		String InvalidMsg = signinPage.InvalidUsernamePasswordMsg();
		Assert.assertEquals(InvalidMsg, prop.getProperty("InvalidUsrnamePwd_Msg"));
	}
	 @AfterMethod
    public void tearDown()
    {
 	   driver.quit();
    }
}
