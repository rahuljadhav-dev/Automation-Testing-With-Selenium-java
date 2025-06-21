package calender;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownDatePicker {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(6));
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='datepicker2']")).click();
		WebElement month= driver.findElement(By.xpath("//select[@title='Change the month']"));
		Select selectMonth=new Select(month);
		selectMonth.selectByVisibleText("January");
		
		WebElement year=driver.findElement(By.xpath("//select[@title='Change the year']"));
		Select selectYear=new Select(year);
		List<WebElement>options=selectYear.getOptions();
		for (WebElement webElement : options) {
			System.out.println(webElement.getText());
		}
		selectYear.selectByVisibleText("2018");
		
		driver.findElement(By.xpath("//table//tbody//a[text()='12']")).click();
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
