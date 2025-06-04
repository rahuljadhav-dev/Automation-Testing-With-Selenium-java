package webdriver_methods;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConditionalMethods {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			driver.get("https://ultimateqa.com/automation");
			driver.manage().window().maximize();

			// Wait and click 'Fill out forms'
			WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Fill out forms")));
			link.click();

			// Fill in the form fields
			WebElement inputField1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("et_pb_contact_name_0")));
			inputField1.sendKeys("Rahul Jadhav");

			WebElement txtarea = wait.until(ExpectedConditions.elementToBeClickable(By.id("et_pb_contact_message_0")));
			txtarea.sendKeys("Hey, I am Rahul currently testing the software using Selenium.");

			// Click the submit button
			WebElement submitButton = driver.findElement(By.name("et_builder_submit_button"));
			submitButton.click();

			System.out.println("All tests passed successfully...");

		} catch (Exception e) {
			System.out.println("Test failed: " + e.getMessage());
		} finally {
			driver.quit();
		}


		//		driver.get("https://ultimateqa.com/dummy-automation-websites/");
		//		Thread.sleep(5000);
		//
		//		driver.manage().window().maximize();
		//
		//		WebElement element=driver.findElement(By.linkText("SauceDemo.com"));
		//		element.click();
		//		Thread.sleep(5000);
		//		
		//		boolean status=element.isDisplayed();
		//		System.out.println(status);
		//		
		//		WebElement element2=driver.findElement(By.xpath("//*[@id=\"post-9600\"]/div[1]/img"));
		//		Thread.sleep(1000);
		//		System.out.println(element2.isDisplayed());
		//		
		//		WebElement first_img=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[1]/article/div[1]/img"));
		//		System.out.println(first_img.isDisplayed());
		//
		//		List<WebElement> list=driver.findElements(By.tagName("img"));
		//		
		//		Iterator<WebElement>iterator=list.iterator();
		//		while (iterator.hasNext()) {
		//			WebElement webElement =iterator.next();
		//			System.out.println(webElement.getAccessibleName());
		//			
		//		}
		//		driver.quit();
	}


}
