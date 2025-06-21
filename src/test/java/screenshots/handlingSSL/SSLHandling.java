package screenshots.handlingSSL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SSLHandling {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
