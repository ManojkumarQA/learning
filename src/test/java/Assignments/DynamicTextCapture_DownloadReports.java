package Assignments;

import org.testng.annotations.Test;

public class DynamicTextCapture_DownloadReports extends BaseTestAssisgnment
{
	@Test	
	public void test() throws InterruptedException 
	{				
		initializeBrowser();
		goToUrl(Url_1);	
		waitforFrameToBeVisible();	
		driver.switchTo().frame(0);
		waitforElementToBeClickable();
		generateandgetOTP();	
		driver.switchTo().defaultContent();	
		
		goToUrl(Url_2);		
		printValue();	
		downloadReport();				}
	
	
}
