package webdriver_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://ultimateqa.com/dummy-automation-websites/");
		Thread.sleep(5000);

		driver.manage().window().maximize();

		WebElement element=driver.findElement(By.linkText("SauceDemo.com"));
		element.click();
		Thread.sleep(5000);

//		driver.close();//it will close only parent on that is starting page or main url 
		//after running this program it will close only parent one 
		//lets try with the quit one
		driver.quit();//it will close all the pages on the browsers 
	}

}
