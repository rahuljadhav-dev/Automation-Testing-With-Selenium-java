package day_third;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTube {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try {
			driver.get("https://www.youtube.com/");
			driver.manage().window().maximize();

			WebElement search=driver.findElement(By.xpath("//*[@id='center']/yt-searchbox/div[1]/form/input"));
			search.sendKeys("selenium videos");
			WebElement button=driver.findElement(By.xpath("//*[@id='center']/yt-searchbox/button"));
			button.click();

			WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='contents']/yt-lockup-view-model[1]/div/div/yt-lockup-metadata-view-model/div[1]/h3/a")));
			driver.findElement(By.xpath("//*[@id='contents']/yt-lockup-view-model[1]/div/div/yt-lockup-metadata-view-model/div[1]/h3/a")).click();

			WebElement skip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='skip-button:2']/div")));
			driver.findElement(By.xpath("//*[@id='skip-button:2']/div")).click();
			
			
			System.out.println("All tests are passed...");

			//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='movie_player']/div[29]/div[2]/div[2]/button[4]")));
			//			driver.findElement(By.xpath("//*[@id='movie_player']/div[29]/div[2]/div[2]/button[4]")).click();

		} catch (Exception e) {
			System.out.println("Error");
		}finally {
			wait.withTimeout(Duration.ofSeconds(1000));
			driver.quit();
		}
	}

}
