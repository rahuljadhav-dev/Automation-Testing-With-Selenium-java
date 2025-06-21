package calender;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class Task {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id='datepicker']")).click();
		
		String month="February";
		String year="2029";
		String date="10";
		while(true) {
			String currentMonth= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			
		}
		List<WebElement>allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for (WebElement webElement : allDates) {
			if(webElement.getText().equals(date)) {
				webElement.click();
				break;
			}
		}
		Thread.sleep(4000);
		driver.quit();
	}

}
