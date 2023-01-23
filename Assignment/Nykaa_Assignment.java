package week3.Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Nykaa_Assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*
		 * 1) Go to https://www.nykaa.com/ 
		 * 2) Mouseover on Brands and Search L'Orea Paris 
		 * 3) Click L'Oreal Paris 
		 * 4) Check the title contains L'Oreal Paris(Hint-GetTitle) 
		 * 5) Click sort By and select customer top rated 
		 * 6) Click Category and click Hair->Click haircare->Shampoo 
		 * 7) Click->Concern->Color Protection 
		 * 8)check whether the Filter is applied with Shampoo 
		 * 9) Click on L'Oreal Paris Colour Protect Shampoo 
		 * 10) GO to the new window and select size as 175ml 
		 * 11) Print the MRP of the product
		 * 12) Click on ADD to BAG 
		 * 13) Go to Shopping Bag 
		 * 14) Print the Grand Total amount 
		 * 15) Click Proceed
		 *  16) Click on Continue as Guest 
		 *  17) Check if this grand total is the same in step 14 
		 * 18) Close all windows
		 */
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		 WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
				
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();
		
		driver.findElement(By.xpath("//div[@id='brandCont_Popular']//li[5]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Sort By')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'customer top rated')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Category')]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Hair')])[3]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Hair Care')])[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Concern')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Color Protection')]")).click();

		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Filters')]")).getText());
		
		driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]")).click();
		
		Set<String> newwindow = driver.getWindowHandles();
		List<String> testlist1 = new ArrayList<> (newwindow); 
		driver.switchTo().window(testlist1.get(1)); 	
		
		WebElement size = driver.findElement(By.className("css-2t5nwu"));
		Select obj = new Select(size);
		obj.selectByIndex(1);
		
		
		String price = driver.findElement(By.xpath("(//span[text()='MRP:']/following-sibling::span)[1]")).getText();
		
		System.out.println("L'Oreal Paris Colour Protect Shampoo Price - " + price);
		
		driver.findElement(By.xpath("//span[contains(text(),'Add to Bag')]")).click();
		
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		
		Thread.sleep(3000);
		
//		String total = driver.findElement(By.xpath("(//div[@id='payment_details']/descendant::p)[7]")).getText();

//		System.out.println("Total price - " + total);
		
		
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		
		/* Unable to complete below steps because Application requesting mobile number and OPT...
		 *  16) Click on Continue as Guest 
		 *  17) Check if this grand total is the same in step 14 
		 * 18) Close all windows
		 */
		 

		
		

	}

}
