package web_tables.dynamic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPagination {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://datatables.net/");
		driver.manage().window().maximize();

		List<String> s = new ArrayList<>();
		int size = driver.findElements(By.xpath("//div[@class='dt-paging']//button[@class='dt-paging-button']")).size();
		for (int i = 1; i <= size+1; i++) {
			if(i>1) {
				WebElement pages=driver.findElement(By.xpath("//div[@class='dt-paging']//button[text()='" + i + "']"));
				pages.click();
				Thread.sleep(3000); 
			}

			int rows = driver.findElements(By.xpath("//table[@id='example']//tbody//tr")).size();

			for (int j = 1; j <= rows; j++) {
				String rowData = driver.findElement(By.xpath("//table[@id='example']//tbody//tr[" + j + "]")).getText();
				s.add(rowData);

			}
		}
		System.out.println("Total Records :"+s.size());

		for (String string : s) {
			System.out.println(string);
		}

		driver.quit();
	}
}
