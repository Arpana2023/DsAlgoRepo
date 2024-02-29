package PagesPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BasePackage.TestBase;
import UtilPackage.TestUtil;


public class HomePage extends TestBase
{@FindBy(xpath="//a[@href='/login']") WebElement signinLink; //sign in button
@FindBy(xpath="//a[@href='/register']") WebElement registerLink; //Register button
@FindBy(xpath="//a[@href='/logout']") WebElement signOutBtn; //SignOutout Button
@FindBy(xpath="//div[contains(text(),'You are logged in')]") WebElement loginMsg; //You are logged in message
@FindBy(xpath="//div[contains(text(),'You are not logged in')]") WebElement loginFailMsg; //You are not logged in message

// @FindBy(xpath="//a[@class ='nav-link dropdown-toggle']") WebElement HomePageDropdwn; //Dropdown

//GetStarted options
@FindBy (xpath="//a[text()='Get Started' and @href='data-structures-introduction']") WebElement dataStructureIntroLink;
@FindBy (xpath="//a[text()='Get Started' and @href='array']") WebElement getstartBtn_array;
@FindBy (xpath="//a[text()='Get Started' and @href='linked-list']") WebElement getstartBtn_linkedlist;
@FindBy (xpath="//a[text()='Get Started' and @href='stack']") WebElement getstartBtn_stack;
@FindBy (xpath="//a[text()='Get Started' and @href='queue']") WebElement getstartBtn_queue;
@FindBy (xpath="//a[text()='Get Started' and @href='tree']") WebElement getstartBtn_tree;
@FindBy (xpath="//a[text()='Get Started' and @href='graph']") WebElement getstartBtn_graph;

//Dropdown options
@FindBy (xpath="//a[@href='#']") WebElement dropdownLink;		
@FindBy (xpath="//a[@class='dropdown-item' and @href='/array']") WebElement dropDown_array;
@FindBy (xpath="//a[@class='dropdown-item' and @href='/linked-list']") WebElement dropDown_linkedList;
//@FindBy (xpath="//*[@id='navbarCollapse']//a[2]") WebElement dropdown_linkedlist;
@FindBy (xpath="//a[@class='dropdown-item' and @href='/stack']") WebElement dropDown_stack;
@FindBy (xpath="//a[@class='dropdown-item' and @href='/queue']") WebElement dropDown_queue;
@FindBy (xpath="//a[@class='dropdown-item' and @href='/tree']") WebElement dropDown_tree;
@FindBy (xpath="//a[@class='dropdown-item' and @href='/graph']") WebElement dropDown_graph;



// List<WebElement> dropdownMenu1 = driver.findElements(By.class("dropdown-menu show"));

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
	   return signOutBtn.isDisplayed();
}
public SignInPage ClickSigninLnk()
{
	   signinLink.click();
	   return new SignInPage();
}
public RegisterPage ClickRegisterLink()
{
	   registerLink.click();
	   return new RegisterPage();
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
//Getting all the dropdown options by removing spaces in them and storing in an array list
/*public ArrayList<String> DropdownOptions() 
	{
	   	String text=dropdownMenu.getText();
	   	//System.out.println("text:"+text);
	   	Stream<String> lines = text.lines();
    
     ArrayList<String> arrayList = new ArrayList<String>(); // Creating an ArrayList object of String type
     lines.forEach(arrayList::add);// Now, adding elements to arrayList using forEach

     //System.out.println(arrayList.get(2));
	    return(arrayList);			
	}*/
public List<String> DropdownOptions() 
{
  
   	/*String text=dropdownMenu.getText();
   	return(text);
		 //String dropdownText = dropdownMenu.getText();*/
	 Select select = new Select(dropdownLink);
	// System.out.println(select);
	 //return select;
    	      List<String> actualList = new ArrayList<String>();
	 for(WebElement element:select.getOptions())
	 {
		 actualList.add(element.getText());
	 }
	 System.out.println(";;;;;;;;"+actualList+";;;;;");
			 return actualList;
}
//Dropdown options
public boolean ClickArrrayInDropDown()
{
	   //ClickDropDownMenuLnk();
	   return TestUtil.webClick(dropDown_array);
}
public boolean ClickLinkedListInDropDown()
{
	   ClickDropDownMenuLnk();
	   return TestUtil.webClick(dropDown_linkedList);
}
public boolean ClickStackInDropDown()
{
	   ClickDropDownMenuLnk();
	   return TestUtil.webClick(dropDown_stack);
}
public boolean ClickQueueInDropDown()
{
	   ClickDropDownMenuLnk();
	   return TestUtil.webClick(dropDown_queue);
}
public boolean ClickTreeInDropDown()
{
	   ClickDropDownMenuLnk();
	   return TestUtil.webClick(dropDown_tree);
}
public boolean ClickGraphInDropDown()
{
	   ClickDropDownMenuLnk();
	   return TestUtil.webClick(dropDown_graph);
}
//Getstarted Links
public DataStructurePage ClickDataStructureIntroLnk()
{
	   dataStructureIntroLink.click();
	   return new DataStructurePage();
}
public ArrayPage ClickArrayLnk()
{
	getstartBtn_array.click();
	   return new ArrayPage();
}
public LinkedListPage ClickLinkedListLnk()
{
	getstartBtn_linkedlist.click();
	   return new LinkedListPage();
}
public StackPage ClickStackLnk()
{
	getstartBtn_stack.click();
	   return new StackPage();
}
public QueuePage ClickQueueLnk()
{
	getstartBtn_queue.click();
	   return new QueuePage();
}
public TreePage ClickTreeLnk()
{
	getstartBtn_tree.click();
	   return new TreePage();
}
public GraphPage ClickGraphLnk()
{
	getstartBtn_graph.click();
	   return new GraphPage();
}
//Method for Login Success Message
public boolean LoginSucessMessage()
{
	   return loginMsg.isDisplayed();
}
//Method for Login Fail Message
public boolean LoginFailMessageInAnyDataStructure()
{
	    return loginFailMsg.isDisplayed();
}

/* public void ClickOnDropdown()
{
	   HomePageDropdwn.click();
}*/
}
