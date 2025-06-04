package day_fourth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XpathAxes {
	// starting ->self
	// parent of parent ->ancestor
	// following sibling suppose the parent is A and child are C and D then C is the
	// following sibling of D

	// if A has another Parent like F and T and Q are childs of F then C,D are the
	// preceeding sibling of t and q
	// and child of child descendent

	/*
	 * child → going down 1 step
	 * 
	 * descendant → going down many steps
	 * 
	 * parent → going 1 step up
	 * 
	 * ancestor → going many steps up
	 * 
	 * following/following-sibling → moving right
	 * 
	 * preceding/preceding-sibling → moving left
	 * 
	 * Axis | Meaning | Example
	 * 
	 * self | Refers to the current node itself |
	 * //input[@id='username']/self::input
	 * 
	 * parent | Selects the parent of the current node |
	 * //input[@id='username']/parent::div
	 * 
	 * child | Selects all the child elements of the current node |
	 * //div[@id='container']/child::input
	 * 
	 * ancestor | Selects all ancestors (parents, grandparents, etc.) |
	 * //input[@id='username']/ancestor::form
	 * 
	 * 
	 * descendant | Selects all descendants (children, grandchildren, etc.) |
	 * //div[@id='container']/descendant::input
	 * 
	 * following | Selects everything in the document after the closing tag of the
	 * current node | //input[@id='username']/following::button
	 * 
	 * following-sibling | Selects all siblings after the current node |
	 * //label[@for='username']/following-sibling::input
	 * 
	 * preceding | Selects everything before the current node |
	 * //button[@id='submit']/preceding::input
	 * 
	 * preceding-sibling | Selects siblings before the current node |
	 * //input[@id='password']/preceding-sibling::label
	 * 
	 * 
	 * chained xpath ->xpath follows another xpath
	 */

	public static String insertNameAndId(WebDriver driver, String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Enter username
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		user.sendKeys(username);

		// Enter password
		WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys(password);

		// Click on Login Button
		WebElement loginButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='login']")));
		loginButton.click();

		return "Test Case Passed Successfully...";
	}

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();

			System.out.println(insertNameAndId(driver, "rahul_567", "arjadhav"));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurs");
		} finally {
			driver.quit();
		}
	}

}
