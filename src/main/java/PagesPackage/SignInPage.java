package PagesPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.TestBase;
import UtilPackage.TestUtil;

public class SignInPage extends TestBase
{
	@FindBy (xpath="//*[@id='id_username']") WebElement usernametxtbox;	
	@FindBy (xpath="//*[@id='id_password']") WebElement passwordtxtbox;
	@FindBy (xpath="//*[@value='Login']")    WebElement loginBtn;
	@FindBy (xpath="//div[@class='alert alert-primary']") WebElement LoginsuccessAlertMsg;
	@FindBy (xpath="//a[@href='/register']") WebElement lnkregister;
	@FindBy (xpath="//a[@href='/logout']") WebElement Btnsignout;	
	@FindBy(xpath="//a[@href='/register']") WebElement RegisterLnk;
	
	@FindBy(xpath="//div[@role='alert']") WebElement InvalidUnamePwd;

	//Constructor ,initializing the PageObjects
	public SignInPage() 
	{
		PageFactory.initElements(driver, this); 
	} 
	public void enterUsername(String username) 
	{
		//usernametxtbox.clear();
		//usernametxtbox.sendKeys(username);
		TestUtil.webSendKeys(usernametxtbox,username);
	}
	
	public void enterPassword(String password)
	{
		//passwordtxtbox.clear();
		//passwordtxtbox.sendKeys(password);
		TestUtil.webSendKeys(passwordtxtbox,password);
	}
	public HomePage clickLoginBtnLoginPage()
	{
		//loginBtn.click();
        TestUtil.webClick(loginBtn);
		return new HomePage();	
	}
	
	public void LoginUser(String username,String password) 
	{
		TestUtil.webSendKeys(usernametxtbox,username); //enterUsername(username);
		TestUtil.webSendKeys(passwordtxtbox,password);//enterPassword(password);
		clickLoginBtnLoginPage();			
	}
	
	public RegisterPage clickRegisterLnkLoginPage() 
	{
		//lnkregister.click();
        TestUtil.webClick(lnkregister);
		return new RegisterPage();
	}
	
	public String AlertMessageLoginPage() 
	{
		return LoginsuccessAlertMsg.getText();
	}
	
	public String SignInPageURL() 
	{
		return driver.getCurrentUrl();	
	}
	public String getTitleOfCurrentPage()
	{
		return driver.getTitle();
	}
	public String LoginPageCreatedSuccessfully()
	{
		return LoginsuccessAlertMsg.getText();
	}
	public String EmptyFieldErrorMsgUsername()
	{
		return usernametxtbox.getAttribute("validationMessage");
	}
	public String EmptyFieldErrorMsgPassword()
	{
		return passwordtxtbox.getAttribute("validationMessage");
	}
	public String InvalidUsernamePasswordMsg()
	{
		return InvalidUnamePwd.getText();
	}
}
