package calender;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
	public static Month convertMonth(String month) {
		HashMap<String, Month>map=new HashMap<String, Month>();
		map.put("January", Month.JANUARY);
		map.put("February", Month.FEBRUARY);
		map.put("March", Month.MARCH);
		map.put("April", Month.APRIL);
		map.put("May", Month.MAY);
		map.put("June", Month.JUNE);
		map.put("July", Month.JULY);
		map.put("August", Month.AUGUST);
		map.put("September", Month.SEPTEMBER);
		map.put("October", Month.OCTOBER);
		map.put("November", Month.NOVEMBER);
		map.put("December", Month.DECEMBER);

		if (!map.containsKey(month)) {
		    throw new IllegalArgumentException("Invalid month: " + month);
		}

		return map.get(month);
	}

	public static String selectDate(WebDriver driver,String month,String year,String date) {
		if(Integer.parseInt(date)>31) {
			throw new InvalidArgumentException("Date should be less than 31..");
		}
		
		driver.findElement(By.xpath("//input[@type='text' and @id='datepicker1']")).click();

		while (true) {
			String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			Month expectedMonth = convertMonth(month);
			Month currentMonth = convertMonth(displayMonth);

			int yearDiff = Integer.parseInt(year) - Integer.parseInt(currentYear);
			int monthDiff = expectedMonth.compareTo(currentMonth);

			if (yearDiff < 0 || (yearDiff == 0 && monthDiff < 0)) {
				// Go to previous
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			} else if (yearDiff > 0 || (yearDiff == 0 && monthDiff > 0)) {
				// Go to next
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			} else {
				// Year and month match
				break;
			}
		}

		List<WebElement>listOfAllDates=driver.findElements(By.xpath("//a[@class='ui-state-default']"));
		boolean dateFound = false;
		for (WebElement webElement : listOfAllDates) {
		    if (webElement.getText().equals(date)) {
		        webElement.click();
		        dateFound = true;
		        break;
		    }
		}
		if (!dateFound) {
		    return "Test Failed: Date not found in the current month view";
		}
		
		return "Test Case Success...";
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		driver.manage().window().maximize();
		String month="February";
		String year="2011";
		String date="71";
		System.out.println(selectDate(driver, month, year, date));
		Thread.sleep(4000);
		driver.quit();
	}

}
