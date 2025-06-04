package webdriver_methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodsOfWebdriver {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.github.com/");
		
		driver.manage().window().maximize();
		
		String source=driver.getPageSource();
		System.out.println(source);
		String pageId=driver.getWindowHandle();
		System.out.println(pageId);
		
//		WebElement element= driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
//		element.sendKeys("todays news");
//		
//		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[5]/div/div/div[1]/div/div/span")).click();
//		Thread.sleep(5000);
//		WebElement element=driver.findElement(By.xpath("//*[@id=\"query-builder-test\"]"));
//		element.sendKeys("Rahul Jadhav");
//		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/header/div/div[2]/div/div/qbsearch-input/div[1]/button/span")));
		element.click();
		element.sendKeys("Rahul jadhav");
		
		

//		driver.quit();
	}

}
