package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropdown {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		WebElement username=driver.findElement(By.name("username"));
		WebElement password= driver.findElement(By.name("password"));
		username.sendKeys("Admin");
		password.sendKeys("admin123");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();

		//employee registration form
		WebElement empName=driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input"));
		WebElement empId=driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input"));
		empName.sendKeys("Rahul Jadhav");
		empId.sendKeys("123");
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]")).click();
		List<WebElement>list= driver.findElements(By.xpath("//div[@id='app']//div[@role='option']//span"));
//		for (WebElement webElement : list) {
//			if(webElement.getText().equals("Full-Time Contract")) {
//				webElement.click();
//			}
//		}
		
		driver.findElement(By.xpath("//button[@type='button' and contains(., 'Add')]")).click();

		Thread.sleep(4000);
		driver.quit();

	}

}
