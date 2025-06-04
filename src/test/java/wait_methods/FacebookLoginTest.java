package wait_methods;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class FacebookLoginTest {

	public static String loginTestCase(WebDriver driver, String username, String password) {
		try {
			// Enter username and password
			driver.findElement(By.id("email")).sendKeys(username);
			driver.findElement(By.id("pass")).sendKeys(password);
			driver.findElement(By.name("login")).click();

			// Get error message after invalid login
			WebElement error = driver.findElement(By.className("_9ay7"));
			String errorMsg = error.getText();

			// Click on forgotten password link
			driver.findElement(By.linkText("Forgotten password?")).click();

			// Wait and get the message on the next page
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_9nq2")));
			String problem = msg.getText();

			// Validation
			if (errorMsg.contains("The password that you've entered is incorrect.") &&
					problem.equals("Please identify your account using an email or a phone number.")) {
				return "The login test case is passed successfully";
			} else {
				return "Login test case failed";
			}

		} catch (Exception e) {
			System.out.println("Error occurs during testing: " + e.getMessage());
			return "Login test case failed due to exception";
		}
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String status = loginTestCase(driver, "rahul", "Arjadhav");
		System.out.println(status);

		driver.quit();
	}
}
