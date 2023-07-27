package Learning.Selenium_Learn.ParentforPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponents {

	WebDriver driver;
	public ReusableComponents(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	
	public void waitforElementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

}
