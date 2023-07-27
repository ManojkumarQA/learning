package Learning.Selenium_Learn;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Learning.Selenium_Learn.POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MainScript extends ParentforMainScript{
	
	@Test(dataProvider = "getData")
	public void standAlone(HashMap<String, String> data) throws IOException, InterruptedException
	{
		initializeBrowser();
		LoginPage loginPage= goTo(prop.getProperty("URL"));
	    loginPage.login(data.get("name"),data.get("pass"),data.get("roles"));
	   // prop.getProperty("UserName"), prop.getProperty("Password"), prop.getProperty("Role")
	    
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data= jsontoMap("C:\\Manoj\\Selenium_Learn\\src\\main\\java\\Learning\\Selenium_Learn\\Resources\\dataset.json");
		return new Object[][] {{data.get(0)}};
		
	}
	
	
	//Reusable Utility to convert json file data to HashMap container
	
	public List<HashMap<String, String>> jsontoMap(String filePath) throws IOException
	{
		String jsonContent =FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}

}
