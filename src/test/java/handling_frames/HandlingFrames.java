package handling_frames;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();

		//frame 1
		WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);

		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Rahul Jadhav");
		driver.switchTo().defaultContent();//back to the main page
		Thread.sleep(2000);


		//frame 2
		WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);

		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Rahul Jadhav");
		driver.switchTo().defaultContent();//back to the main page

		Thread.sleep(2000);

		//frame 3
		WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);

		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Rahul Jadhav");
		
		driver.switchTo().frame(0);//switch to inner frame
		WebElement radioButton=driver.findElement(By.xpath("//*[@id='i6']/div[3]/div"));
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", radioButton);
		
//		driver.findElement(By.xpath("//*[@id='i9']/div[3]/div")).click();
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent();//back to the main page

		Thread.sleep(2000);
		driver.quit();
	}

}
