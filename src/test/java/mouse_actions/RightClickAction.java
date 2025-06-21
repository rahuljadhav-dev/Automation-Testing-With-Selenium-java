package mouse_actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://api.jquery.com/contextmenu/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement div=driver.findElement(By.cssSelector("div"));
		Actions act=new Actions(driver);
		act.contextClick(div).perform();
		
		Thread.sleep(3000);
		driver.quit();
	}

}
