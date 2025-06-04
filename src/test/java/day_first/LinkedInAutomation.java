package day_first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedInAutomation {

	private WebDriver driver;

	public void startBrowser() {
		// Replace with your ChromeDriver path
		// System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void login(String email, String password) throws InterruptedException {
		driver.get("https://www.linkedin.com/login");

		// Input email
		WebElement emailField = driver.findElement(By.id("username"));
		emailField.sendKeys(email);

		// Input password
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys(password);

		// Click login
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();

		Thread.sleep(3000); // Wait for login to complete
	}

	public void visitProfile(String profileUrl) throws InterruptedException {
		driver.get(profileUrl);
		Thread.sleep(3000); // wait for profile to load
	}

	public void sendConnectionRequest(String profileUrl) throws InterruptedException {
		visitProfile(profileUrl);
		try {
			WebElement connectButton = driver.findElement(By.xpath("//button[contains(text(), 'Connect')]"));
			connectButton.click();
			Thread.sleep(1000);

			WebElement sendNowButton = driver.findElement(By.xpath("//button[contains(text(), 'Send now')]"));
			sendNowButton.click();
		} catch (Exception e) {
			System.out.println("Connect button not found or already connected.");
		}
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static void main(String[] args) {
		LinkedInAutomation bot = new LinkedInAutomation();

		try {
			bot.startBrowser();
			bot.login("your-email@example.com", "yourPassword");

			// Visit a profile or send request
			bot.sendConnectionRequest("https://www.linkedin.com/in/example-profile/");

			Thread.sleep(5000); // Optional wait before closing
			bot.closeBrowser();

		} catch (Exception e) {
			e.printStackTrace();
			bot.closeBrowser();
		}
	}
}
