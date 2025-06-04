package handling_check;

import java.util.List;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		List<WebElement> list=driver.findElements(By.xpath("//table[@id='productTable']//input[@type='checkbox']"));
//		for (WebElement webElement : list) {
//			webElement.click();
//		}
		
		//now same operation using stream api
		IntStream.range(0, list.size()).filter(i->i%2==0).mapToObj(list::get).forEach(t ->t.click());
//		list.stream().filter(box->box.isSelected()).forEach(box->box.click());
		
		Thread.sleep(4000);
		driver.quit();
	}

}
