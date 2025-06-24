package data_driven_testing.testing;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDepositTesting {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String path=System.getProperty("user.dir")+File.separator+"testdata"+File.separator+"fd.xlsx";
		int rowCount=Excelutils.getTotalRows(path, "sheet1");
		System.out.println(rowCount);
		driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		
		for (int i = 1; i <=rowCount; i++) {
			String principle=Excelutils.getCellData(path, "sheet1", i, 0);
			String roi=Excelutils.getCellData(path, "sheet1", i, 1);
			String p1=Excelutils.getCellData(path, "sheet1", i, 2);
			String p2=Excelutils.getCellData(path, "sheet1", i, 3);
			String freq=Excelutils.getCellData(path, "sheet1", i, 4);
			String mv=Excelutils.getCellData(path, "sheet1", i, 5);
			
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath(" //input[@id='interest']")).sendKeys(roi);
			driver.findElement(By.xpath(" //input[@id='tenure']")).sendKeys(p1);
			
			WebElement duration=driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
			Select s1=new Select(duration);
			s1.selectByVisibleText(p2);
			
			WebElement fr=driver.findElement(By.xpath(" //select[@id='frequency']"));
			Select s2=new Select(fr);
			s2.selectByVisibleText(freq);
			
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();
			
			
			String result=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(mv)==Double.parseDouble(result)) {
				Excelutils.setCellData(path, "sheet1", i, 7, "Passed");
				Excelutils.fillGreenColour(path, "sheet1", i, 7);
			}else {
				Excelutils.setCellData(path, "sheet1", i, 7, "Failed");
				Excelutils.fillRedColour(path, "sheet1", i, 7);
			}
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			
		}
		
		Thread.sleep(4000);
		driver.quit();
				
	}

}
