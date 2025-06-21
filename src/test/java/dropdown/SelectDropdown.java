package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//fetch the select 
		WebElement country= driver.findElement(By.id("country"));
		
		//Select class
		Select countryDropDown=new Select(country);
		countryDropDown.selectByVisibleText("France");
		
		//i want to count total options present then there is getOptions() method
		List<WebElement>list=countryDropDown.getOptions();//this will return the list of web-element cause all options are individually web-element
		for (WebElement webElement : list) {
			System.out.println(webElement.getText());
		}
		
		System.out.println(list.stream().count());
		
		Thread.sleep(2000);
		driver.quit();
	}

}
