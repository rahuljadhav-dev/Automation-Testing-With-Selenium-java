package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		try {
			driver.get("https://www.youtube.com/");
			driver.manage().window().maximize();
			driver.findElement(By.name("search_query")).sendKeys("selenium videos");
			driver.findElement(By.className("ytSearchboxComponentSearchButton")).click();
			
			//linktext and partial link text
//			driver.findElement(By.className("ytChipShapeButtonReset")).click();
			driver.findElement(By.className("yt-core-attributed-string yt-core-attributed-string--white-space-pre-wrap")).click();

		} catch (Exception e) {
			System.out.println("Something went wrong..");
//			e.printStackTrace();
		}finally {
//			driver.close();
		}
		
		
	}

}
