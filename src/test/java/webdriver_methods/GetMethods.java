package webdriver_methods;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//get for getting the page
		driver.get("https://ultimateqa.com/dummy-automation-websites/");
		
		driver.manage().window().maximize();
		
		String title=driver.getTitle();//this will capture the name 
		System.out.println("Title of page :"+title);
		
//		String pageSourceCode=driver.getPageSource();//this will capture the source code(html+css+js)
//		System.out.println("Source code :/n"+pageSourceCode);
		
		String url=driver.getCurrentUrl();//this will capture current url of the page
		System.out.println(url);
		
		Object object= driver.getClass();
		System.out.println("Object :"+object);
		System.out.println("String :"+object.toString());
		
		String id1=driver.getWindowHandle();//this will capture the parent id and it captures only one 
		System.out.println("Id of the page/session :"+id1);
		
		WebElement element=driver.findElement(By.linkText("SauceDemo.com"));
		element.click();
		
//		String id2=driver.getWindowHandle();
//		System.out.println("Id :"+id2);//here the same id i.e parent one 
		//now i want all id's like if i open to many pages 
		
		Set<String>ids =driver.getWindowHandles();//this will return set of string ->set is because all id's are unique
		System.out.println("All session Id's :"+ids);
		
		Iterator<String>iterator=ids.iterator();
		while (iterator.hasNext()) {
			String string =iterator.next();
			System.out.println(string);
		}
		
		driver.quit();
		
	}

}
