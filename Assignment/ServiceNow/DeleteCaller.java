package week4.Assignment.ServiceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class DeleteCaller extends BaseClass {

	@Test	
	public  void deletemodifier() throws InterruptedException {

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
		
		driver.findElement(By.xpath("//button[@id='sysverb_delete_bottom']")).click();
				
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		
		
		
		
		
}
}
