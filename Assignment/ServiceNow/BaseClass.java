package week4.Assignment.ServiceNow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.sukgu.Shadow;



public class BaseClass {
	
	ChromeDriver  driver ;
	
	Shadow shadow;

	@BeforeMethod
	
	public void login() throws InterruptedException {
		
	driver = new ChromeDriver();
	
	driver.get("https://dev107885.service-now.com/navpage.do");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.findElement(By.id("user_name")).sendKeys("admin");
	driver.findElement(By.id("user_password")).sendKeys("1XJd3=%xqeAZ");
	driver.findElement(By.id("sysverb_login")).click();
	
	
	
	}
	
	@AfterMethod
	public void logout() {
		
//		Shadow shadow = new Shadow(driver);
//		
//		shadow.findElementByXPath("//img[@class='now-avatar-img']").click();
//		shadow.findElementByXPath("//div[text()='Log out']").click();
//	
//		driver.quit();
		

	}
	

}
