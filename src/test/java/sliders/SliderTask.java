package sliders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderTask {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		WebElement left=driver.findElement(By.xpath("//*[@id='slider-range']/span[1]"));
		Point pl1=left.getLocation();//returns the point or coordinates
		System.out.println("Default :"+pl1);
		act.dragAndDropBy(left, 60, 0).perform();
		
		Point pl2=left.getLocation();
		System.out.println("After Move :"+pl2);
		
		
		WebElement right=driver.findElement(By.xpath("//*[@id='slider-range']/span[2]"));
		Point pr1=right.getLocation();//returns the point or coordinates
		System.out.println("Default :"+pr1);
		act.dragAndDropBy(right, -800, 0).perform();
		
		Point pr2=right.getLocation();
		System.out.println("After Move :"+pr2);
		
		Thread.sleep(4000);
		driver.quit();
	}

}
