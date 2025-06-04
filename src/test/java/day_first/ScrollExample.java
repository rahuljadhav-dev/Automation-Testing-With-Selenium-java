package day_first;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();

        driver.findElement(By.name("search_query")).sendKeys("selenium tutorial");
        driver.findElement(By.id("search-icon-legacy")).click();

        Thread.sleep(3000); // Wait for results to load

        WebElement video = driver.findElement(By.xpath("(//a[@id='video-title'])[1]"));

        // Scroll to the video
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", video);

        Thread.sleep(1000); // Let scroll finish

        video.click();
    }
}

