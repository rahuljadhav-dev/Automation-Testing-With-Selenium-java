package js_executor.uploading;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadingFiles {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://demoqa.com/upload-download");
		driver.manage().window().maximize();
		
		String path1="D:"+File.separator+"Rahul"+File.separator+"annotations.pdf";
		driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys(path1);
		
		String text=driver.findElement(By.xpath("//p[@id='uploadedFilePath']")).getText();
		if(text.contains("annotations.pdf")) {
			System.out.println("Successfully Uploaded..");
		}else {
			System.out.println("Failed..");
		}
		
		Thread.sleep(4000);
		driver.quit();
	}

}
