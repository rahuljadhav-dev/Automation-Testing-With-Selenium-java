package screenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Screenshots {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://reqres.in/");
//		driver.manage().window().maximize();
		//full page screenshot
//		TakesScreenshot screenshot=(TakesScreenshot) driver;
//		File sourcefile=screenshot.getScreenshotAs(OutputType.FILE);
//		File targetfile=new File(System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"fullsc.png");
//		sourcefile.renameTo(targetfile);
		
		//section screenshot
//		WebElement element= driver.findElement(By.xpath("//div[@class='header-content']//header"));
//		File source=element.getScreenshotAs(OutputType.FILE);
//		File target=new File(System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"element.png");
//		source.renameTo(target);
		
		WebElement element= driver.findElement(By.xpath("//div[@id='cc-ad']"));
		File source=element.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"image.png");
		source.renameTo(target);
		
		
		Thread.sleep(4000);
		driver.quit();
	}

}
