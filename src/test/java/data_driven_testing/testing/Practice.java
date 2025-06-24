package data_driven_testing.testing;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
        driver.manage().window().maximize();

        // Reject cookies
        driver.findElement(By.xpath("//*[@id='onetrust-reject-all-handler']")).click();

        // Excel path and setup
        String path = System.getProperty("user.dir") + "\\testdata\\newdata1.xlsx";
        int total = Excelutils.getTotalRows(path, "sheet2");

        for (int i = 1; i <= total; i++) {
            // Fetch data
            String ida = Excelutils.getCellData(path, "sheet2", i, 0);
            String loc = Excelutils.getCellData(path, "sheet2", i, 1);
            String ir = Excelutils.getCellData(path, "sheet2", i, 2);
            String compounding = Excelutils.getCellData(path, "sheet2", i, 3);
            String expectedTest = Excelutils.getCellData(path, "sheet2", i, 4);

            try {
                // Fill inputs
                WebElement idaInput = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
                idaInput.clear();
                idaInput.sendKeys(ida);

                WebElement locInput = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
                locInput.clear();
                locInput.sendKeys(loc);

                WebElement irInput = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
                irInput.clear();
                irInput.sendKeys(ir);

                // Select dropdown
                WebElement dropdown = driver.findElement(By.id("mat-select-value-1"));
                dropdown.click();

                // Wait and click option
                WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//mat-option//span[normalize-space()='" + compounding + "']")));
                option.click();

                // Click calculate
                driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")).click();

                // Fetch result
                WebElement resultEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='cdAPY']")));
                String result = resultEl.getText();

                System.out.println("Test " + i + " result: " + result);

                // Write result to Excel
                Excelutils.setCellData(path, "sheet2", i, 5, result); // result column
            } catch (Exception e) {
                System.out.println("Test " + i + " failed: " + e.getMessage());
                Excelutils.setCellData(path, "sheet2", i, 5, "Error");
            }
        }

        driver.quit();
        System.out.println("Test execution completed.");
    }
}
