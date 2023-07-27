package Learning.Selenium_Learn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Learning.Selenium_Learn.POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentforMainScript {
	WebDriver driver;
	Properties prop;
	
	public void initializeBrowser() throws IOException
	
	{
		
		//Reads properties file
		prop =new Properties();
		FileInputStream fis =new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\Learning\\Selenium_Learn\\Resources\\Globalproperties.properties"));
		prop.load(fis);
		
	//Browser Initialization
	//Using Terinary operator
	String browserName= (System.getProperty("Browser")!=null)? System.getProperty("Browser"):prop.getProperty("Browser");
	//System.getProperty("Browser")!=null ? System.getProperty("Browser"): prop.getProperty("Browser");
	if(browserName.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if (browserName.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	//Maximize window
	driver.manage().window().maximize();
	}
	
	public LoginPage goTo(String url)
	{
		driver.get(url);
		LoginPage loginPage =new LoginPage(driver);
		return loginPage;
	}

}
