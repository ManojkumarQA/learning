package Learning.Selenium_Learn.POM;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Learning.Selenium_Learn.ParentforPOM.ReusableComponents;

public class LoginPage extends ReusableComponents
{

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath ="(//label/span[@class='checkmark'])[2]")
	WebElement roleRadioButton;
	

	@FindBy(xpath ="//div/select")
	WebElement userPassion;
	
	@FindBy(id="terms")
	WebElement agreeCheckbox;
	
	@FindBy(id="signInBtn")
	WebElement signInBtn;
	
	@FindBy(id="okayBtn")
	WebElement popup_okayBtn;
	
	
	//Page Actions
	//()
	@Test
	public void login(String uname, String pass, String role) throws InterruptedException
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		roleRadioButton.click();
		waitforElementToBeClickable(popup_okayBtn);
		Thread.sleep(2000);
		popup_okayBtn.click();
		Select select = new Select(userPassion);
		Thread.sleep(2000);
		select.selectByVisibleText(role);
		agreeCheckbox.click();
		signInBtn.click();
		
	}
	
	
	
	
	
	

}
