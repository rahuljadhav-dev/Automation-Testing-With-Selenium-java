package browser_methods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindow {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://mahabocw.in/");
		driver.manage().window().maximize();
		
		WebElement element=driver.findElement(By.xpath("//*[@id='post-24625']/div/div/div/div[3]/div/div[6]/div"));
		element.click();
		
		driver.navigate().back();
		
		Set<String>set= driver.getWindowHandles();
		for (String string : set) {
			if(string.equals("3AC1504D7EB5A6456B814E0C14912EF0")) {
				
			}
		}
		
//		driver.quit();
	}

}
