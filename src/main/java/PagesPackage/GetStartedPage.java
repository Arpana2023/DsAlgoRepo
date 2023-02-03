package PagesPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.TestBase;

public class GetStartedPage extends TestBase
{
   @FindBy(xpath="//a[@href='/home']") WebElement getStartedBtn;//Page objects,pagefactory or object repository
  
   //Constructor
   public GetStartedPage()
   {
	   //Initialize page elements or page objects by using pagefactory.initelelments
	   PageFactory.initElements(driver, this);//All the web elements or variables will be initialized by this driver by using this(pointing to the current class object)
                                              //we can write GetStartedPage.class instead of this
   }
   public HomePage clickOnGetStarted()
   {
	   getStartedBtn.click();
	   return new HomePage();
   }
}
