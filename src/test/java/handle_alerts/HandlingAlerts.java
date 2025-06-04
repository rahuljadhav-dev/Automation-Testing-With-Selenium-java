package handle_alerts;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAlerts {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//handling normal ok alert
//		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button")).click();
//		Thread.sleep(4000);
		
//		Alert myAlert=driver.switchTo().alert();
//		System.out.println(myAlert.getText());
//		myAlert.accept();
		
		
//		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();
//		Thread.sleep(4000);
//		Alert alert=driver.switchTo().alert();
//		
//		alert.dismiss();//close alert using cancel button 
		
		//enter some text in the alert or prompt alert
//		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();
//		Thread.sleep(4000);
//		Alert alert=driver.switchTo().alert();
//		alert.sendKeys("Rahul Jadhav");
//		alert.accept();
		
		//
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Rahul Jadhav");
		alert.accept();
		
		//confirmation alert
		Thread.sleep(4000);
		driver.quit();
		
		
	}

}
