package keyboard_actions.misc;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleLinksDifferentWindow {
	public static void main(String[] args) throws InterruptedException {
		WebDriver  driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.youtube.com");
		driver.manage().window().maximize();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.github.com");
		driver.manage().window().maximize();
		
		List<String>list= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(0));
		
		Thread.sleep(4000);
		driver.quit();
	}

}
