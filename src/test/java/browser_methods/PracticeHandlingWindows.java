package browser_methods;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeHandlingWindows {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//String s=""+File.separator+"";
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='newWindowBtn']"))).click();

		Set<String>handles=driver.getWindowHandles();
		List<String>list=new ArrayList<String>();
		list.addAll(handles);
		for (String string : list) {
			if (driver.switchTo().window(string).getTitle().equals("Basic Controls - H Y R Tutorials")) {
				driver.switchTo().window(string);
				driver.manage().window().maximize(); 
				WebElement firstName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
				firstName.sendKeys("Rahul");

				WebElement lastName=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
				lastName.sendKeys("Jadhav");

				driver.findElement(By.xpath("//input[@name='gender' and @id='malerb']")).click();

				List<WebElement> languages=driver.findElements(By.xpath("//input[@class='bcCheckBox']"));
				for (int i = 0; i < 3; i++) {
					languages.get(i).click();
				}

				WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
				email.sendKeys("arjadhav@gmail.com");

				WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
				password.sendKeys("arjadhav@");
				driver.findElement(By.xpath("//button[@id='registerbtn']")).click();

			}

		}
		Thread.sleep(4000);
		driver.quit();
	}

}
