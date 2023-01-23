package week4.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chittorgarh {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*
		 * 1. Launch the URL https://www.chittorgarh.com/ 
		 * 2. Click on stock market
		 *  3. Click on NSE bulk Deals
		 *  4. Get all the Security names 
		 *  5. Ensure whether there are duplicate Security names
		 */
		
		ChromeDriver driver=new ChromeDriver();
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.chittorgarh.com/");
		 
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@id=\"navbtn_stockmarket\"]")).click();
		
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		
		
		List<WebElement> securitynames = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tbody//tr"));
	
	
		System.out.println("Security Names :");
	

		for (int i = 2 ; i < securitynames.size() ; i++) {
			
			String  sn = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tbody//tr["+i+"]//td[3]")).getText();
					
			System.out.println(sn);
		}

	
		
		
		
		
		
		

	}

}
