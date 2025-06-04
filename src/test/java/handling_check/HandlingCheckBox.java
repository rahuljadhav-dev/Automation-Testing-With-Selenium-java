package handling_check;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckBox {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//select specific checkbox
//		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//select all checkbox
		List<WebElement> list=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
//		for (WebElement webElement : list) {
//			webElement.click();
//		}
		
		//last three checkboxes
		
//		for (int i = list.size()-1; i >3; i--) {
//			list.get(i).click();
//		}
		
		//first four checkboxes
		for (int i = 0; i <4; i++) {
			list.get(i).click();
		}
		
		//whichever checkboxes are already seleccted unselect only those checkboxes
		
		Thread.sleep(4000);
		
		for (WebElement webElement : list) {
			if(webElement.isSelected()) {
				webElement.click();
			}
		}
		
		Thread.sleep(4000);
		driver.quit();
	}

}
