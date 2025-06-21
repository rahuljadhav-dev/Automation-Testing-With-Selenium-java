package web_tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://testautomationpractice.blogspot.com/");
		driver.get("http://127.0.0.1:3000/c:/Users/Nishat/OneDrive/Desktop/Selenium/index.html");
		driver.manage().window().maximize();
		
		//find total numbers of rows in a table;
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id='table']/tbody/tr"));
		int totalAmount=0;
		for (int i = 1; i <=rows.size(); i++) {
			String price=driver.findElement(By.xpath("//*[@id='table']/tbody/tr["+i+"]/td[3]")).getText();
			totalAmount+=Integer.parseInt(price);
		}
		
		System.out.println("Total price of the book is :"+totalAmount);
		Thread.sleep(4000);
		driver.quit();
		
	}

}
