package navigational_method;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NavigationalMethodsDemo {
	public static void main(String[] args) throws MalformedURLException {
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		options.addArguments("--incognito");
		
		WebDriver driver=new ChromeDriver(options);
		
//		driver.get("https://www.insta.com/");
		driver.navigate().to("https://www.insta.com/");
		driver.navigate().to("https://www.facebook.com/");
		driver.navigate().to("https://www.github.com/");
		driver.manage().window().maximize();
		//functionality wise both methods are same 
		//only difference is that navigate.to is accepts url object also in automation this is not used as much get 
		
//		URL url=new URL("https://www.insta.com/");
//		driver.navigate().to(url);
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		
		
		
	}

}
