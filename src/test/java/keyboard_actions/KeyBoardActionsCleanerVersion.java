package keyboard_actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyBoardActionsCleanerVersion {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        // Input in first textbox
        WebElement input1 = driver.findElement(By.id("input1"));
        input1.sendKeys("Rahul Jadhav");

        // Select all and copy
        input1.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Thread.sleep(200);
        input1.sendKeys(Keys.chord(Keys.CONTROL, "c"));

        // Paste into input2
        driver.findElement(By.id("btn1")).click();
        WebElement input2 = driver.findElement(By.id("input2"));
        input2.click();
        input2.sendKeys(Keys.chord(Keys.CONTROL, "v"));

        // Submit input2
        driver.findElement(By.id("btn2")).click();

        // Paste into input3
        WebElement input3 = driver.findElement(By.id("input3"));
        input3.click();
        input3.sendKeys(Keys.chord(Keys.CONTROL, "v"));

        // Submit input3
        driver.findElement(By.id("btn3")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
