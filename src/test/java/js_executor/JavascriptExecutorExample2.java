package js_executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorExample2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement input = driver.findElement(By.id("name"));
        String expectedName = "Rahul Jadhav";

        // Enter value using JS
        js.executeScript("arguments[0].setAttribute('value', arguments[1])", input, expectedName);

        // Read back the value using JS and assert it
        String actualName = (String) js.executeScript("return arguments[0].value;", input);
        System.out.println("Entered name: " + actualName);

        // Assertion (Java built-in)
        assert expectedName.equals(actualName) : "Assertion Failed! Expected: " + expectedName + ", but got: " + actualName;

        // Scroll to bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);

        // Scroll back to top
        js.executeScript("window.scrollTo(0, 0)");
        Thread.sleep(2000);

        // Scroll to and click male radio button
        WebElement maleRadio = driver.findElement(By.id("male"));
        js.executeScript("arguments[0].scrollIntoView(true);", maleRadio);
        js.executeScript("arguments[0].click();", maleRadio);

        // Verify radio button is selected
        boolean isSelected = maleRadio.isSelected();
        System.out.println("Male radio selected: " + isSelected);
        assert isSelected : "Radio button was not selected via JS click!";

        Thread.sleep(2000);
        driver.quit();
        System.out.println("Test completed successfully.");
    }
}
