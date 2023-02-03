package PagesPackage;

import static BasePackage.TestBase.driver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BasePackage.TestBase;

public class HomePage extends TestBase
{
	   @FindBy(xpath="//a[@href='/login']") WebElement loginLink; //signin button
	   @FindBy(xpath="//a[@href='/register']") WebElement registerLink; //Register button
	   @FindBy(xpath="//a[@href='/logout']") WebElement logoutBtn; //logout Btn
	   @FindBy(xpath="//a[@class ='nav-link dropdown-toggle']") WebElement HomePageDropdwn; //Dropdown
	   @FindBy(xpath="//div[contains(text(),'You are logged in')]") WebElement loginMsg; //You are logged in message
	   @FindBy(xpath="//a[@href='array'])]") WebElement arrayLink; //You are logged in message
	   @FindBy(xpath="//a[@href='data-structures-introduction']") WebElement dataStructureIntroLink; //DatastructureIntro
	   @FindBy(xpath="//a[@href='linked-list']") WebElement linkedListLink; //Linkedlist button
	   @FindBy(xpath="//a[@href='stack']") WebElement stackLink; //Stack button
	   @FindBy(xpath="//a[@href='queue']") WebElement queueLink; //Queue button
	   @FindBy(xpath="//a[@href='tree']") WebElement treeLink; //Tree button
	   @FindBy(xpath="//a[@href='graph']") WebElement graphLink; //Graph button
	   @FindBy (xpath="//a[@href='#']") WebElement dropdownLink;//DropdownLink
       @FindBy(xpath="//div[@class='dropdown-menu show']") WebElement dropdownMenu;//dropdownMenuOptions       
	   public HomePage()
	   {
		   PageFactory.initElements(driver, this);
	   }
       public String LandedHomePage()
       {
    	   return driver.getCurrentUrl();
       }
      public String verifyHomePageTitle()
      {
    	  return driver.getTitle();
      }
       public boolean LogOutUserBtn()
       {
    	   return logoutBtn.isDisplayed();
       }
       public RegisterPage ClickRegisterUserLnk()
       {
    	   registerLink.click();
    	   return new RegisterPage();
       }
       public SignInPage ClickLoginUserLnk()
       {
    	   loginLink.click();
    	   return new SignInPage();
       }
       public void ClickDropDownMenuLnk()
       {
    	   dropdownLink.click();
       }
     //get all the options displayed in dropdown
     	/*	public String DropdownOptions() 
     		{
     			 String dropdownText = dropdownMenu.getText();	
     			 return dropdownText;
     		}*/
       public String DropdownOptions() 
		{
    	  
    	   	String text=dropdownMenu.getText();
    	   //	System.out.println("&&&&&&&&&&&"+text+"&&&&&&&&&&&");
    	   	return(text);
   			/* //String dropdownText = dropdownMenu.getText();
			 Select select = new Select(dropdownMenu);
			 System.out.println(select);
			 return select;
/*    	      List<String> actualList = new ArrayList<String>();
			 for(WebElement element:select.getOptions())
			 {
				 actualList.add(element.getText());
			 }
			 System.out.println(";;;;;;;;"+actualList+";;;;;");
	//				 return actualList;*/
		}
       public ArrayPage ClickArrayLnk()
       {
    	   arrayLink.click();
    	   return new ArrayPage();
       }
       public DataStructurePage ClickDataStructureIntroLnk()
       {
    	   dataStructureIntroLink.click();
    	   return new DataStructurePage();
       }
       public LinkedListPage ClickLinkedListLnk()
       {
    	   linkedListLink.click();
    	   return new LinkedListPage();
       }
       public StackPage ClickStackLnk()
       {
    	   stackLink.click();
    	   return new StackPage();
       }
       public QueuePage ClickQueueLnk()
       {
    	   queueLink.click();
    	   return new QueuePage();
       }
       public TreePage ClickTreeLnk()
       {
    	   treeLink.click();
    	   return new TreePage();
       }
       public GraphPage ClickGraphLnk()
       {
    	   graphLink.click();
    	   return new GraphPage();
       }
       
       public boolean LoginSucessMessage()
       {
    	   return loginMsg.isDisplayed();
       }
       public void ClickOnDropdown()
       {
    	   HomePageDropdwn.click();
       }
}
