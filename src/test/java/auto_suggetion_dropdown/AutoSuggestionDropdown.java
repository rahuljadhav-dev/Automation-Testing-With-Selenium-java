package auto_suggetion_dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AutoSuggestionDropdown {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		WebElement searchBox=driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
		searchBox.sendKeys("java");
		
		 List<WebElement> list=driver.findElements(By.xpath("//div[@class='wM6W7d' and @role='presentation']"));
		 for (WebElement webElement : list) {
			if(webElement.getText().equals("java online compiler")) {
				webElement.click();
			}
		}
		 
		 Thread.sleep(4000);
		 driver.quit();
	}

}
