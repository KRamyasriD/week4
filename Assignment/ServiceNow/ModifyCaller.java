package week4.Assignment.ServiceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;
//
//"1. Launch ServiceNow application
//2. Login with valid credential 
//3. Click-All and Enter Callers in filter navigator and press enter 
//4. Modify the Business Phone number for an existing Caller and click
//'Udate'. If Existing Created not available , then search it.
//5. Verify the update for the caller"
//


public class ModifyCaller extends BaseClass{
	
@Test	
	public  void modifycaller() throws InterruptedException {

	Shadow shadow = new Shadow(driver);
	
	shadow.setImplicitWait(10);
	 shadow.findElementByXPath("//div[text()='All']").click(); 
	 
	 shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers",Keys.ENTER);
	 
	 shadow.findElementByXPath("//mark[text()='Callers']").click();

	 Thread.sleep(1000);
		
		WebElement element = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		 
		driver.switchTo().frame(element);			
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Ramyasri",Keys.ENTER);
		
		driver.findElement(By.xpath("((//table[@id='sys_user_table']//tbody//tr)[1]//a)[2]")).click();
		driver.findElement(By.xpath("//input[@id='sys_user.phone']")).clear();
		driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("9189191");
		driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
		
		String update = driver.findElement(By.xpath("((//table[@id='sys_user_table']//tbody//tr)[1]//td)[5]")).getText();
	
		if (update.contains("9189191")) {
			
			System.out.println("Caller is updated sucecssfully");
			
			
		}

		else {
			
			System.out.println("Caller update failed");
		}
			

}

}
