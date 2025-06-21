package mouse_actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://www.w3schools.com/TAgs/tryit.asp?filename=tryhtml5_ev_ondblclick");

		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		WebElement button=driver.findElement(By.xpath("//button[text()='Double-click me']"));
		
		Actions actions=new Actions(driver);
		actions.doubleClick(button).click().perform();
		
		String s=driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if(s.equals("Hello World")) {
			System.out.println("Working Properly");
		}else {
			System.out.println("Not Working Properly");
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
