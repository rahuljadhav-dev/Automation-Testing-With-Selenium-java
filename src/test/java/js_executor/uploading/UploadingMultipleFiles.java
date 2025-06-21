package js_executor.uploading;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadingMultipleFiles {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		System.err.println(1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		System.err.println(2);
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		System.err.println(3);
		driver.manage().window().maximize();
		System.err.println(4);
		
		String path1="D:"+File.separator+"Rahul"+File.separator+"annotations.pdf";
		String path2="D:"+File.separator+"Rahul"+File.separator+"mongodb.pdf";
//		String path3="D:"+File.separator+"Rahul"+File.separator+"Rahul Jadhav FullStack (1).pdf";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(path1+"\n"+path2);
		
		List<WebElement>text =driver.findElements(By.xpath("//ul[@id='fileList']//li"));
		
		for (int i = 0; i <text.size(); i++) {
			if(text.get(i).getText().contains("annotations") || text.get(i).getText().contains("mongo") ) {
				System.out.println("OK");
			}
		}
		
		
		Thread.sleep(4000);
		driver.quit();
	}


}
