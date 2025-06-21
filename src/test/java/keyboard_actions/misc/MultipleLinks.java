package keyboard_actions.misc;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleLinks {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://www.google.com");
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https:/www.facebook.com");
		
		
		List<String>list=new ArrayList<String>(driver.getWindowHandles());
		for (String string : list) {
			System.out.println(string);
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
