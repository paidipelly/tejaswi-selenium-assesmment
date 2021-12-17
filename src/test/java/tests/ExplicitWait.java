package tests;

import org.testng.annotations.Test;

import utilities.selenium.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ExplicitWait {

	WebDriver driver;
	WebDriverManager webDrvMgr;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");
		wait = new WebDriverWait(driver, 120);
		driver.get("http://www.google.co.in");
	}

	@Test
	public void explicitWaitTest() {
		By bySearch = By.cssSelector("input.gLFyf.gsfi");
		wait.until(ExpectedConditions.elementToBeClickable(bySearch));

		driver.findElement(By.cssSelector("input.gLFyf.gsfi")).clear();
		driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("jagital");
		driver.findElement(By.cssSelector("input.gLFyf.gsfi")).clear();
		driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("srilanka");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}