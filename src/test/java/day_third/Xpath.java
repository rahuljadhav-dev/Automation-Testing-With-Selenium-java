package day_third;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {
	public static void main(String[] args) {
		//xpath is representing the address of the element
		//we can capture xpath from the dom 
		/*
		 * there are two types
		 * 1.Absolute xpath(full xpath)
		 * navigate from root like nodes
		 * /html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[1]/input
		 * 2.Relative xpath(partial xpath)
		 * capture element 
		 * //*[@id="email"]
		 * 
		 * syntax
		 *//*[]
		 * 
		 * which xpath is prefered?
		 * ->Relative xpath is always preferred 
		 * why?
		 * the absolute xpath is traverse the elements in node unitl it reaches to last element 
		 * soo if any element is change then in this case there is a propblem.
		 * 
		 * relative xpath is hold element
		 * 
		 * diff between->
		 * absolute xpath is always start with /
		 * relative xpath is alwasy start with //
		 * 
		 * absolute xpath doesnt carry the attribute value 
		 * relative xpath carry the attribute value 
		 * 
		 * absolute xpath traverse each node until it reaches to the final element
		 * relative xpath directly jumbs on element
		 * 
		 * both have same performance in both cases 
		*/
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		//xpath with single attribute
//		WebElement username=driver.findElement(By.xpath("//*[@id=\"email\"]"));
//		username.sendKeys("arjadhav@gmai.com");
//		
		//xpath with multiple attributes
		WebElement username2=driver.findElement(By.xpath("//*[@id='email' and @placeholder='Email address or phone number']"));
		username2.sendKeys("arjadhav");
		
		//xpath with and or operator
		
		//xpath with innertext
		//a[text()='desktops']
		
		//xpath with contains 
		//Search
		//input[contains(@placeholder,'Sea')] using this we dont need to enter entire value we can enter substring partial text value 
		//input[starts-with(@placeholder,'S')]
		
		//handling dynamic attribute
		// //*[@id='start' or @id='stop']
		// //*[contains(@id,'st')]
		// when the attribute keep changing then we use this 
		
		//chained xpath
		// //div[@id='logo']/a/img
	}

}
