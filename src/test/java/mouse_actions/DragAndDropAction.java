package mouse_actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction implements Runnable{
	private WebDriver driver;
	private String browserName;

	DragAndDropAction(WebDriver driver,String browserName){
		this.driver=driver;
		this.browserName=browserName;
	}
	public void testCase1() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			driver.get("https://www.globalsqa.com/demo-site/draganddrop/#google_vignette");
			driver.manage().window().maximize();

			driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
			List<WebElement> images=driver.findElements(By.xpath("//*[@id='gallery']//li"));

			System.out.println(images.size());

			WebElement target=driver.findElement(By.xpath("//*[@id='trash']"));
			Actions act=new Actions(driver);

			for (WebElement webElement : images) {
				act.dragAndDrop(webElement, target).perform();
			}
			System.out.println(browserName + " - Drag and drop completed.");
		} catch (Exception e) {
			System.out.println("Error Occurs");
		}finally {
			driver.quit();
		}

	}
	@Override
	public void run() {
		testCase1();
	}
	
	public static void main(String[] args){
		WebDriver driver1=new ChromeDriver();
		WebDriver driver2=new EdgeDriver();

		Thread chromeThread=new Thread(new DragAndDropAction(driver1,"Chrome"));
		Thread edgeThread=new Thread(new DragAndDropAction(driver2,"Edge"));
		
		chromeThread.start();
		edgeThread.start();

	

	}



}
