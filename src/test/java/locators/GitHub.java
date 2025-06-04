 package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitHub {
	public static void main(String[] args) {
		//WebDriver driver=new EdgeDriver();
		WebDriver driver=new ChromeDriver();
		try {
			driver.get("https://www.github.com/");
			driver.manage().window().maximize();

			WebElement user_email=driver.findElement(By.className("Primer_Brand__Button-module__Button__text___Z3ocU"));
			user_email.click();

			WebElement signin= driver.findElement(By.linkText("Sign in →"));
			signin.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // waits up to 10 seconds

			// wait for login input field to be visible
			WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));
			name.sendKeys("rahuljadhav.dev@gmail.com");

			WebElement password = driver.findElement(By.name("password"));
			password.sendKeys("Arjadhav");

			WebElement login = driver.findElement(By.name("commit"));
			login.click();

			WebElement errorMessage = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.className("flash-error"))
					);

			String text=errorMessage.getText();
			if(text.equals("Incorrect username or password.")) {
				System.out.println("Test Passed");
			}else
				System.out.println("Test Failed");
			
			//		WebElement name=driver.findElement(By.name("login"));
			//		name.sendKeys("rahuljadhav.dev@gmail.com");
			//		
			//		WebElement password=driver.findElement(By.name("password"));
			//		password.sendKeys("Arjadhav");
			//		
			//		WebElement login=driver.findElement(By.name("commit"));
			//		login.click();
			//		


		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error occurs...");
		}finally {
			driver.close();
		}


	


	}

}
