package data_driven_testing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import data_driven_testing.testing.Excelutils;

public class PrepareFile {
	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();
		
		String path=System.getProperty("user.dir")+"\\testdata\\newdata1.xlsx";
		int total=Excelutils.getTotalRows(path, "sheet2");
		
		driver.findElement(By.xpath("//*[@id='onetrust-reject-all-handler']")).click();
		int count=0;
		for (int i = 1; i <= 15; i++) {
			String ida=Excelutils.getCellData(path, "sheet2", i, 0);
			String loc=Excelutils.getCellData(path, "sheet2", i, 1);
			String ir=Excelutils.getCellData(path, "sheet2", i, 2);
			String c=Excelutils.getCellData(path, "sheet2", i, 3);
			String test=Excelutils.getCellData(path, "sheet2", i, 4);
			try {
				WebElement idaInput=driver.findElement(By.xpath("//input[@id='mat-input-0']"));
				idaInput.clear();
				idaInput.sendKeys(ida);
				
				WebElement locInput=driver.findElement(By.xpath("//input[@id='mat-input-1']"));
				locInput.clear();
				locInput.sendKeys(loc);
				
				WebElement irInput=driver.findElement(By.xpath("//input[@id='mat-input-2']"));
				irInput.clear();
				irInput.sendKeys(ir);
				
				WebElement dropdown = driver.findElement(By.id("mat-select-value-1"));
				dropdown.click();
				
				WebElement option=driver.findElement( By.xpath("//mat-option//span[contains(text(),'" + c + "')]"));
				option.click();
				
				driver.findElement(By.xpath("//button[@id='CIT-chart-submit']//div[@class='mdc-button__ripple']")).click();
				
				String r=driver.findElement(By.xpath("//span[@id='cdAPY']")).getText();
				System.out.println(r);
				count++;
			} catch (Exception e) {
				System.out.println("Test Number :"+count+" Is Failed");
			}
			
			
		}
		
		
	
	}

}
