package keyboard_actions.misc;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MiscActions {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://webkul.com/opencart-development/");
		driver.manage().window().maximize();
		
		WebElement link=driver.findElement(By.xpath("//a[@title='Visit Store']"));
		Actions act=new Actions(driver);
		act.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).perform();
		
		List<String>allWindows=new ArrayList<String>(driver.getWindowHandles());
		System.out.println(allWindows);
		
		driver.switchTo().window(allWindows.get(1));
		driver.findElement(By.id("search")).sendKeys("Tshirts");
		driver.findElement(By.xpath("//*[@id='search_mini_form_webkulmenu']/div/span")).click();
		
		Thread.sleep(4000);
		
		driver.switchTo().window(allWindows.get(0));
		WebElement about= driver.findElement(By.xpath("//div[@class='wk-drop' and text()='About']"));
		about.click();
		
		List<WebElement>abouts= driver.findElements(By.xpath("//*[@id='menu-webkul-mega-menu']/li[1]/div[2]/ul"));
		for (WebElement webElement : abouts) {
			if(webElement.getText().equals("Certifications")) {
				webElement.click();
				break;
			}
		}
		Thread.sleep(4000);
		driver.quit();
	}

}
