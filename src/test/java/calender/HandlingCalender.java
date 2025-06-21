package calender;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingCalender {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();

		WebElement element= driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='dateOfBirthInput']")));
		element.clear();
		element.click();

		while(true) {
			String date = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[1]/div[1]"))).getText();
			if (date.equals("March 2065")) {
				driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[@role='option' and text()='5']")).click();
				break;
			} else {
				driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Next Month']"))).click();
			}
		}
		Thread.sleep(4000);
		driver.quit();
	}

}
