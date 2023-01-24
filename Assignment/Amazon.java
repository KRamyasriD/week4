package week3.Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		1.Load the URL https://www.amazon.in/
//			2.search as oneplus 9 pro 
//			3.Get the price of the first product
//			4. Print the number of customer ratings for the first displayed product
//			5. Click the first text link of the first image
//			6. Take a screen shot of the product displayed  -- Pending
//			7. Click 'Add to Cart' button
//			8. Get the cart subtotal and verify if it is correct.
//			9.close the browser
//			
			
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		String customersrate = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		
		System.out.println(customersrate);
		
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		

		Set<String> newwindow = driver.getWindowHandles();
		List<String> testlist1 = new ArrayList<> (newwindow); 
		driver.switchTo().window(testlist1.get(1)); 	
		
		String price = driver.findElement(By.xpath("(//span[@class='a-color-price'])[3]")).getText();
		
				
		driver.findElement(By.id("add-to-cart-button")).click();
				
		String totalprice = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		
		if (price == totalprice )
			
		{
			System.out.println("TotalPrice Verified, total price is  - " + totalprice);
		}
		
		else
			
		{
			System.out.println("Total price is not matching, price is " +price + " and total price is " + totalprice );
		}
		
		
	}

}

