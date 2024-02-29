package PagesPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.TestBase;
import UtilPackage.TestUtil;

public class RegisterPage extends TestBase
{
	@FindBy(xpath="//input[@id='id_username']") WebElement TxtBoxuserName; //Username 
    @FindBy(xpath="//input[@id='id_password1']") WebElement TxtBoxpassWord; //Password
    @FindBy(xpath="//input[@id='id_password2']") WebElement TxtBoxPWConfirm; //confirm Password
    @FindBy(xpath="//input[@value='Register']") WebElement register; //Register button
    @FindBy(xpath = "//div[@role='alert']") WebElement accountCreatedSuccess;
    @FindBy(xpath = "//div[@class='alert alert-primary']") WebElement PWMisMatchAlertMsg;
    @FindBy(xpath="//a[@href='/logout']") WebElement SignoutLink; //signout button in homepage
    @FindBy(xpath="//div[@role='alert']") WebElement LogOutSuccess;//LoggedOut Successfully in homepage
    @FindBy(xpath="//a[@href='/login']") WebElement SigninLink; //SigninLink in Homepage
    public RegisterPage()
    {
		   PageFactory.initElements(driver, this);
	}
   /* public String LandedRegisterPage()
    {
 	   return driver.getCurrentUrl();
    
    }*/
    public String GetTitleOfCurrentPage()
    {
    	return driver.getTitle();  
    }  
    public void enterUserName(String Usrname)
    {
    	 /*Random rnum = new Random();
    	 String NewUsrName=Usrname+rnum.nextInt();*/
    	/*String NewUsrName= TestUtil.GenerateRandomUsername(Uname);
    	 userName.sendKeys(NewUsrName);*/
		TestUtil.webSendKeys(TxtBoxuserName, TestUtil.GenerateRandomUsername(Usrname));
	}
    public void enterPwd(String password)
    {
    	//passWord.sendKeys(password);
		TestUtil.webSendKeys(TxtBoxpassWord, password);

    }
    public void enterConfPwd(String ConfirmPassword)
    {
    	//TxtBoxPWConfirm.sendKeys(ConfirmPassword);
		TestUtil.webSendKeys(TxtBoxPWConfirm, ConfirmPassword);

    }   
    public void clickOnRegisterBtn() {

        //register.click();
        TestUtil.webClick(register);
    }
    public String RegisterPageCreatedsuccessfully() 
    {
		return accountCreatedSuccess.getText();
    }
    public String EmptyFieldErrorMsgUsername()
    {
    	return TxtBoxuserName.getAttribute("validationMessage");
    }
    public String EmptyFieldErrorMsgPassWord()
    {
    	return TxtBoxpassWord.getAttribute("validationMessage");
    }
    public String EmptyFieldErrorMsgConfirmPassWord()
    {
    	return TxtBoxPWConfirm.getAttribute("validationMessage");
    }
    public String ConfirmPWDMisMatchError()
    {
    	return PWMisMatchAlertMsg.getText();
    }
    public void clickOnSinOutLink()
    {
    	//SignoutLink.click();
        TestUtil.webClick(SignoutLink);

    }	
    public String LogOutSuccessfully()
    {
    	return LogOutSuccess.getText();
    }
    public SignInPage ClickSigninLink()
    {
    	SigninLink.click();
    	return new SignInPage();
    }
}
