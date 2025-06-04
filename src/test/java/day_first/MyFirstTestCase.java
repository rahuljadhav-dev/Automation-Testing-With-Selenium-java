package day_first;

import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MyFirstTestCase {
	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		try {
			//launch browser (chrome)
//			ChromeDriver driver=new ChromeDriver();
//			WebDriver webDriver=new ChromeDriver();
//			webDriver.get("https://www.opencart.com/");
			
			driver.get("https://www.youtube.com/");
			String s=driver.getTitle();
			System.out.println(s);
			
			
			if(s.equals("YouTube")) {
				System.out.println("Test Passed");
			}else {
				System.out.println("Test Failed");
			}
//			webDriver.findElement();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception handled");
			
		}finally {
//			driver.close();
			driver.quit();
		}
		
	}

}
