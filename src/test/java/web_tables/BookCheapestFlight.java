package web_tables;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookCheapestFlight {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();

		driver.findElement(By.name("fromPort")).sendKeys("Portland");
		driver.findElement(By.name("toPort")).sendKeys("Berlin");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		int rows=driver.findElements(By.xpath("//table[@class='table']//tr")).size();
		WebElement cheapestButton=null;
		double minPrice=Double.MAX_VALUE;
		String airline=null;

		for (int i = 1; i <rows; i++) {
			String priceText=driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[6]")).getText();
			double price=Double.parseDouble(priceText.replace("$", ""));
			
			if(price<minPrice) {
				minPrice=price;
				
				cheapestButton=driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[1]"));
				airline=driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]//td[3]")).getText();
			}
		}

		if(cheapestButton!=null) {
			cheapestButton.click();
		}
		
		System.out.println("Cheapest flight of price :"+minPrice+" And airline :"+airline);
		
		//personal details for booking flight
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Rahul Jadhav");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Dongarkada");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Nanded");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Maharashtra");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("431701");
		driver.findElement(By.xpath("//select[@name='cardType']")).sendKeys("American Express");
		driver.findElement(By.xpath("//input[@name='creditCardNumber']")).sendKeys("880667854");
		driver.findElement(By.xpath("//input[@name='creditCardMonth']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@name='creditCardYear']")).sendKeys("2025");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Rahul Jadhav");
		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		String status=driver.findElement(By.xpath("/html/body/div[2]/div/h1")).getText();
		if(status.equals("Thank you for your purchase today!")) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
