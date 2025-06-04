package com.practice;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class DummyGithub {
    public static void main(String[] args) {
        // Set ChromeDriver path if needed
        // System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.get("https://github.com/");
        driver.manage().window().maximize();

        try {
            // Click on the 'Product' button (it's a dropdown)
            WebElement productDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Product')]")));
            productDropdown.click();

            // Now click on the 'Startups' link inside the dropdown
            WebElement startupsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Startups")));
            startupsLink.click();

            System.out.println("Clicked on Startups!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
