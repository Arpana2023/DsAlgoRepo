package BasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import UtilPackage.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestBase
{ 
	public static WebDriver driver;
	public static Properties prop;// global variable can be used inside this class and child classes also
	public TestBase()//constructor of this class
	{

		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\venka\\eclipse-workspace\\DsAlgoProject1\\src\\main\\java\\ConfigPackage\\Config.Properties");
		    prop.load(ip);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	public static void initialization()  //method
	{
		String browserName =  prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver","c:\\\\Users\\\\venka\\\\Downloads\\\\chromedriver_win32_3\\\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			//System.setProperty("webdriver.chrome.driver","c:\\\\Users\\\\venka\\\\Downloads\\\\chromedriver_win32_3\\\\chromedriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
    
}
