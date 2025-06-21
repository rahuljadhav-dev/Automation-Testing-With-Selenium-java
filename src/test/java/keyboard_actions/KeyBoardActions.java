package keyboard_actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		driver.findElement(By.xpath("//*[@id='input1']")).sendKeys("Rahul Jadhav");
		//select all text
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		//copy the text
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		driver.findElement(By.xpath("//*[@id='btn1']")).click();
		
		driver.findElement(By.xpath("//*[@id='input2']")).click();
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		driver.findElement(By.xpath("//*[@id='btn2']")).click();
		
		driver.findElement(By.xpath("//*[@id='input3']")).click();
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		driver.findElement(By.xpath("//*[@id='btn3']")).click();
		
		Thread.sleep(4000);
		driver.quit();
		
		
	}

}
