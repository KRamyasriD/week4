package week3.Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//			1. Launch https://www.snapdeal.com/
//			2. Go to Mens Fashion
//			3. Go to Sports Shoes
//			4. Get the count of the sports shoes
//			5. Click Training shoes
//			6. Sort by Low to High
//			7. Check if the items displayed are sorted correctly
//			8.Select the price range (900-1200)
//			9.Filter with color Navy 
//			10 verify the all applied filters 
//			11. Mouse Hover on first resulting Training shoes
//			12. click QuickView button
//			13. Print the cost and the discount percentage
//			14. Take the snapshot of the shoes.
//			15. Close the current window
//			16. Close the main window
			
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement brands = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();
		
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Popularity')]")).click();
		
		driver.findElement(By.xpath("//li[@class='search-li'][1]")).click();
		
		String sort = driver.findElement(By.xpath("//div[@class='sort-selected']")).getText();
		
		System.out.println(sort);
		driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).clear();
		
		driver.findElement(By.xpath("(//input[@class='input-filter'])[1]")).sendKeys("600");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).clear();
		
		driver.findElement(By.xpath("(//input[@class='input-filter'])[2]")).sendKeys("1200");
				
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		
		Thread.sleep(4000);
				
		driver.findElement(By.xpath("((//div[@class='filter-content '])[1]//following::div)[3]")).click();
		
		Thread.sleep(4000);
		
		WebElement firstshoe = driver.findElement(By.xpath("//div[@class='product-tuple-image ']"));
		
		Actions fs = new Actions(driver);
		fs.moveToElement(firstshoe).perform();
		
	driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
	
	Thread.sleep(6000);
//	
//	Set<String> newwindow = driver.getWindowHandles();
//	List<String> testlist1 = new ArrayList<> (newwindow); 
//	driver.switchTo().window(testlist1.get(0)); 	
	
	// String price = driver.findElement(By.className("payBlkBig")).getText();
	
	String discount = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
	
	System.out.println("Show Price with discount  " + discount);
	
		
	}

}
