package handsonexercise;
import org.testng.annotations.Test;

import utilities.selenium.WebDriverManager;

import org.testng.annotations.BeforeClass;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ProgressBar {

	WebDriver driver;
	WebDriverManager webDrvMgr;
	WebDriverWait wait;
	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");
		wait = new WebDriverWait(driver, 120);
		driver.get("https://demo.seleniumeasy.com/jquery-download-progress-bar-demo.html");
	}
		@Test
		public void progressBarTest(){
			driver.findElement(By.id("downloadButton")).click();
			By completed=By.cssSelector("div-progress-label");
			wait.until(ExpectedConditions.textToBePresentInElementLocated(completed, "complete!"));
			driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button")).click();
		}
		@AfterClass
		public void tearDown() {
			driver.quit();
			
			
		}
	}



