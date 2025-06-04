package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementAndFindElements {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		try {
			driver.get("https://www.demoblaze.com/");
			driver.manage().window().maximize();
			
			List<WebElement> links=driver.findElements(By.tagName("a"));
			List<WebElement> images=driver.findElements(By.tagName("img"));
			
			for (WebElement webElement : images) {
				System.out.println(webElement.getText());
			}
			
			System.out.println("Total links in this site :"+links.size());
			for (WebElement webElement : links) {
				System.out.println(webElement.getAccessibleName());
				System.out.println(webElement.getAriaRole());
			}
		} catch (Exception e) {
			System.out.println("Error occurs..");
		}finally {
			driver.quit();
		}
	}

}
