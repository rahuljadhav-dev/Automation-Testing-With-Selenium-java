package js_executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorExample {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		JavascriptExecutor executor=(JavascriptExecutor)driver;

		//zoom in zoom out
		//		executor.executeScript("document.body.style.zoom='50%'");
//		executor.executeScript("document.body.style.zoom='150%'");

		WebElement input=driver.findElement(By.xpath("//input[@id='name']"));
		//		input.sendKeys("Rahul Jadhav");

		//enter value using js executor
		executor.executeScript("arguments[0].setAttribute('value','Rahul Jadhav')", input);//enter value

		Thread.sleep(4000);

		WebElement button=driver.findElement(By.xpath("//input[@id='male']"));

		//scroll down to the pixel number
		//		executor.executeScript("window.scrollBy(0,500)", "");
		//		System.out.println(executor.executeScript("return window.pageYOffset"));

		//scroll till end of the page
		executor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(executor.executeScript("return window.pageYOffset"));

		Thread.sleep(4000);

		//scroll till initial point
		executor.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(executor.executeScript("return window.pageYOffset"));

		//scroll until the button is visible
		Object element=	executor.executeScript("arguments[0].scrollIntoView()", button);
		System.out.println(element);

		//click using js executor
		executor.executeScript("arguments[0].click()", button);
		Thread.sleep(4000);

		driver.quit();

	}

}
