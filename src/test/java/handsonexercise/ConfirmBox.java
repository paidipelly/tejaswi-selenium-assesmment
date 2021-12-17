package handsonexercise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.selenium.WebDriverManager;


public class ConfirmBox{
	WebDriver driver;
	WebDriverManager webDrvMgr;
	WebDriverWait wait;
	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");
	     wait = new WebDriverWait(driver, 120);
		driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
		
	}
      @Test
	public void alertBoxTest() throws InterruptedException {
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		WebElement a =driver.findElement(By.id("confirm-demo"));
		String innerText=a.getText();
		Assert.assertEquals(innerText,"You pressed OK!");
		Thread.sleep(1000);
      }
	    
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
