package handling_frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Handling_Practice {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		WebElement frame5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("Rahul Jadhav");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("https://a9t9.com"))).click();

		
		WebElement logo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='logo']/img")));
		//WebElement logo=driver.findElement(By.xpath("//*[@id='logo']/img"));
		boolean status=logo.isDisplayed();
		
		System.out.println(status);
		
//		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		
		driver.quit();
		
	}

}
