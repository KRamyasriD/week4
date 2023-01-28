package week4.Assignment.ServiceNow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;


//"1. Launch ServiceNow application
//2. Login with valid credentials 
//3. Enter Knowledge  in filter navigator and press enter
//4. Create new Article  and Fill Mandatory fields
//And Click-Submit"
//


public class CreateArticle_Fillmandatoryfields extends BaseClass {
	
	@Test
	private void createartical() throws InterruptedException {
		
	Shadow shadow = new Shadow(driver);
	
	shadow.setImplicitWait(10);
	
	shadow.findElementByXPath("//div[text()='All']").click(); 
	 
	shadow.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge",Keys.ENTER);
	
	shadow.findElementByXPath("//mark[text()='Knowledge']").click();

	Thread.sleep(1000);
	
	WebElement element = shadow.findElementByXPath("//iframe[@id='gsft_main']");
	 
	driver.switchTo().frame(element);		
	
	driver.findElement(By.xpath("//span[text()='Create an Article']")).click();
	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']")).click();
	
	driver.switchTo().defaultContent();
	
	String parentwindow = driver.getWindowHandle();
	
	Thread.sleep(1000);
	
	Set<String> windowHandles = driver.getWindowHandles();


	List<String> testlist = new ArrayList<> (windowHandles); 
	
	driver.switchTo().window(testlist.get(1)); 
			
	
		
	driver.findElement(By.xpath("(//table[@id='kb_knowledge_base_table']//tbody//tr)[2]//a")).click();
	
	// driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']")).sendKeys("Test");
	
	driver.switchTo().window(parentwindow); 
	
	driver.switchTo().frame(element);
	
	driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_category']")).click();

	
	Thread.sleep(2000);
		
	driver.findElement(By.xpath("((//table[@id='window.kb_categories_dialog']//tbody//tr)[3]//td//span)[5]")).click();
	driver.findElement(By.xpath("((//table[@id='window.kb_categories_dialog']//tbody//tr)[3]//td//span//div//div)[18]")).click();

//	driver.findElement(By.xpath("(((//table[@id='window.kb_categories_dialog']//tbody//tr)[3]//td//span//div)[24]//button)[2]")).click();
	
	driver.findElement(By.xpath("//button[@id='ok_button']")).click();

	driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("Test Artical");
	
	driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
	
	
	
	
	 
	}
	

}
