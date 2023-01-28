package week4.Assignment.ServiceNow;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

//1. Launch ServiceNow application
//2. Login with valid credential
//3. Click-All and Enter Callers in filter navigator and press enter 
//4. Create new Caller by filling all the fields and click 'Submit'.
//5. Search and verify the newly created Caller"


public class CreateCaller extends BaseClass {
	
	@Test
	public  void createcaller() throws InterruptedException {

		Shadow shadow = new Shadow(driver);
		
		shadow.setImplicitWait(10);
		 shadow.findElementByXPath("//div[text()='All']").click(); 
		 
		 shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers",Keys.ENTER);
		 
		 shadow.findElementByXPath("//mark[text()='Callers']").click();

		 Thread.sleep(1000);
		
		
		WebElement element = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		 
		driver.switchTo().frame(element);			
		driver.findElement(By.xpath("//button[text()='New']")).click();
		
		 
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Ramyasri");
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("K");
		driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("9999");
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
		
		String text = driver.findElement(By.xpath("//div[contains(text(),'Ramyasri')]")).getText();
		
		if (text.contains("Ramya")) {
			System.out.println("Caller Created Successfully ");
		}
		
		else {
			System.out.println("Caller didnt created");
		}
		
		driver.switchTo().defaultContent();
		
	}
		
		
	}
	

