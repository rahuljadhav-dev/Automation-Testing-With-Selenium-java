package day_third;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class CSSSLocator {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		try {
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			//tag id
//			WebElement element=driver.findElement(By.cssSelector("tag#id"));//here tag is optional
//			element.wait(100);
//			element.click();
			WebElement username=driver.findElement(By.cssSelector("input#user-name"));//here tag is optional
			username.sendKeys("rahuljadhav");
			
			WebElement password=driver.findElement(By.cssSelector("input#password"));//here tag is optional
			password.sendKeys("Arjadhav");
			
			
			//tag class ->tag.classname
			WebElement button=driver.findElement(By.cssSelector("input.submit-button"));//here tag is optional
			
			button.click();
			
			WebElement error=driver.findElement(By.tagName("h3"));//here tag is optional
			String errorMsg=error.getText();
			
			if(errorMsg.equals("Epic sadface: Username and password do not match any user in this service")) {
				System.out.println("Test Passed");
			}else
				System.out.println("Test Failed");
			
			//tag attribute tag[attribute=value]
			//tag.class[attribute=value]
			//if we have two fields like input and the class name is same then we go with this approach
			//selector hub extension
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
		}
	}

}
