package mini_project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomateTestCases {
	public static void main(String[] args) throws InterruptedException {
		// WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		// WebDriver driver=new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://ultimateqa.com/dummy-automation-websites/");
		driver.manage().window().maximize();

		// Store the current window handle
		String mainWindow = driver.getWindowHandle();

		// Click the link that opens a new window
		driver.findElement(By.linkText("SauceDemo.com")).click();

		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();
		List<String>list=new ArrayList<String>();
		list.addAll(allWindows);

		for (String string : list) {
			System.out.println(driver.switchTo().window(string).getTitle().equals("Complete List of Awesome Websites to Practice Automation Testing"));
		}

		// Switch to the new window
		for (String window : allWindows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);

				// Now check if its the expected page
				if (driver.getTitle().equals("Swag Labs")) {
					WebElement username = driver.findElement(By.id("user-name"));
					username.sendKeys("performance_glitch_user");

					WebElement password = driver.findElement(By.id("password"));
					password.sendKeys("secret_sauce");

					WebElement login = driver.findElement(By.id("login-button"));
					login.click();

					WebElement item1 = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']"));
					item1.click();

					WebElement item2 = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']"));
					item2.click();

					WebElement item3 = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
					item3.click();

					driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
					driver.findElement(By.xpath("//*[@id='checkout']")).click();

					WebElement firstName = driver.findElement(By.xpath("//*[@id='first-name']"));
					firstName.sendKeys("rahul");

					WebElement lastName = driver.findElement(By.xpath("//*[@id='last-name']"));
					lastName.sendKeys("jadhav");

					WebElement zipCode = driver.findElement(By.xpath("//*[@id='postal-code']"));
					zipCode.sendKeys("21");

					driver.findElement(By.xpath("//*[@id='continue']")).click();
					WebElement bill = driver.findElement(By.className("summary_total_label"));
					if (bill.getText().contains("$60.45")) {
						System.out.println("Test Case Passed...");
					} else {
						System.out.println("Test Case Failed...");
					}

					driver.findElement(By.xpath("//*[@id='finish']")).click();
					driver.findElement(By.xpath("//*[@id='back-to-products']")).click();

				}

				break; // exit loop once found
			}
		}

		//  Thread.sleep(2000);
		//  Switch back to the parent (main) window
		//  driver.switchTo().window(mainWindow);
		//  System.out.println("Switched back to parent window.");

		// wait 5 seconds to close the browser
		Thread.sleep(5000);
		driver.quit();// close the browser

	}
}
