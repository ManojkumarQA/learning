package Assignments;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestAssisgnment 
{
	public WebDriver driver;	
	public String Url_1 = "https://www.random.org/"; 
	public String Url_2 = "https://textmechanic.com/text-tools/basic-text-tools/add-prefixsuffix-into-line/"; 
	public WebElement max;	
	public String generatedOTP;	
	
	public void initializeBrowser()
	{	
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}		
	
	public void goToUrl(String Url)	
	{		
		driver.get(Url);
	}	
	
	public void waitforFrameToBeVisible()
	{		
		WebElement iframe = driver.findElement(By.id("homepage-generator"));	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));	
		wait.until(ExpectedConditions.visibilityOf(iframe));	
	}		
	
	public void waitforElementToBeClickable()	
	{	
		max= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/span[3]/input[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));	
		wait.until(ExpectedConditions.elementToBeClickable(max));	
	}
	
	public void generateandgetOTP() throws InterruptedException	
	{	
		max.click();
		max.clear(); 
		max.sendKeys("1000000");
		WebElement generateButton=driver.findElement(By.cssSelector("input[value='Generate']"));
		generateButton.click();
		Thread.sleep(2000);	
		generatedOTP= driver.findElement(By.xpath("//span/center/span[1]")).getText();
		System.out.println(generatedOTP);
	}		
	
	public void printValue() throws InterruptedException
	{		
		WebElement prefixTextBox =driver.findElement(By.id("prefix"));	
		prefixTextBox.sendKeys(generatedOTP);	
		Thread.sleep(3000);
	}		
	
	public void downloadReport()	
	{	
		WebElement downloadOutput =driver.findElement(By.xpath("//input[@value='Save As']"));
		downloadOutput.click();		
	}
	
}
