package broken_links;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrokenLink {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("http://www.linkedin.com/");
		driver.manage().window().maximize();

		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println("Number Of Links :"+links.size());
		int brokenLinksCount=0;

		for (WebElement webElement : links) {
			String capturedLinks=webElement.getAttribute("href");
			if(capturedLinks==null || capturedLinks.isEmpty()) {
				System.out.println("The :"+capturedLinks+" Is Not Valid");
				continue;
			}

			try {
				URL url=new URL(capturedLinks);
				HttpURLConnection connection= (HttpURLConnection) url.openConnection();
				connection.connect();

				int code=connection.getResponseCode();
				if(code>=400) {
					System.out.println("The "+url+" Is Broken");
					brokenLinksCount++;
				}else {
					System.out.println("The "+url+" Is Not Broken");
				}
			} catch (Exception e) {

			}

		}
		System.out.println("Number of broken links :"+brokenLinksCount);

		Thread.sleep(4000);
		driver.quit();
	}

}
