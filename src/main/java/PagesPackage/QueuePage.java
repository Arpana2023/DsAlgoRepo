package PagesPackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.TestBase;
import UtilPackage.TestUtil;

public class QueuePage extends TestBase
{
	@FindBy(xpath = "//a[normalize-space()='Implementation of Queue in Python']")WebElement ImplementationQueuePythonLink;
	@FindBy(xpath = "//a[@class='btn btn-info']")WebElement TryhereLink;
	@FindBy(xpath = "//a[@href='/queue/implementation-collections/']")WebElement ImpCollectionsDequeLink;

	@FindBy(xpath="//textarea[@tabindex='0']") WebElement editorInput;
	@FindBy(xpath="//button[@type='button']") WebElement runButton;
	@FindBy(xpath="//pre[@id='output']") WebElement outputConsole;
	
	public QueuePage()
    {
		   PageFactory.initElements(driver, this);
	}
	public void ClickOnImplementationQueuePythonLink()
	{
		 TestUtil.webClick(ImplementationQueuePythonLink);
	}
	public void ClickOnImpCollectionsDequeLink()
	{
		 TestUtil.webClick(ImpCollectionsDequeLink);
	}
	public void ClickOnTryHere()
	 {
		 TestUtil.webClick(TryhereLink);
	 }
	public boolean enterCode(String code) 
	 {		
			try 
			{
				new Actions(driver).sendKeys(editorInput,code).perform();
			}
			catch(Exception e)
			{
		editorInput.sendKeys(code);
			}
			return true;
	}
	public void clickBtnRun() 
	{
		 runButton.click();
	}
	public String validatePythonCodeGotPrinted()
	{
		return outputConsole.getText();
	}	
	public void deletePythoncode() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.click(editorInput).perform();
		action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).perform();
	}
		

}
