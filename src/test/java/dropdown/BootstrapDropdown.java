package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		//selected
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		
		//now fetch the options
		List<WebElement> list=driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		for (WebElement webElement : list) {
//			webElement.click();
//			System.out.println(webElement.getText());
			if(webElement.getText().equals("Bootstrap")||webElement.getText().equals("Angular")) {
				webElement.click();
			}
		}
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
