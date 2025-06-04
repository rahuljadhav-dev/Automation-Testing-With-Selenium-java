package chatbot_testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyChatBotTesting {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:4200/Chat-bot/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		WebElement element=driver.findElement(By.xpath("/html/body/app-root/app-chat-window/div/div[2]/input"));
		element.sendKeys("what is your name?");
		
		WebElement send=driver.findElement(By.xpath("/html/body/app-root/app-chat-window/div/div[2]/button[1]"));
		send.click();
		
		WebElement bot=driver.findElement(By.className("bot"));
		String text=bot.getText();
		System.out.println(text);
		Thread.sleep(4000);
		driver.quit();
		
	}

}
