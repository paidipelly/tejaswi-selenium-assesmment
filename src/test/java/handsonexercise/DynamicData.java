package handsonexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.selenium.WebDriverManager;

public class DynamicData {
	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	WebDriverWait wait;
	SoftAssert sf;

	@BeforeClass

	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");
		wait = new WebDriverWait(driver, 120);
		driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
	}

	@BeforeMethod
	public void testPreReq() {
		sf = new SoftAssert();
	}

	@Test
	public void dynamicDataTest() {
		driver.findElement(By.id("save")).click();
		By oLoading = By.id("loading");
		wait.until(ExpectedConditions.invisibilityOfElementWithText(oLoading, "loading..."));
		WebElement oPic = driver.findElement(By.xpath("//div[@id='loading']/img"));
		String imgsrc = oPic.getAttribute("src");
		sf.assertTrue(imgsrc.contains("jpg"), "FAIL | Image height should doesnt contain .jpg extension");
		sf.assertTrue(oPic.getSize().getHeight() > 0,
				"FAIL | Image height should be greater than 0 but is" + oPic.getSize().getHeight());

		sf.assertTrue(oPic.getSize().getWidth() > 0,
				"FAIL | Image height should be greater than 0 but is" + oPic.getSize().getWidth());
		String name = driver.findElement(oLoading).getText();
		String[] arrName = name.split("\n");
		arrName[1].replace("First Name:", "");
		arrName[2].replace("Last Name:", "");
		sf.assertTrue(arrName[1].length() > 0, "FAIL | First name length should be greater than 0 but is" + arrName[1]);
		sf.assertTrue(arrName[2].length() > 0, "FAIL | Last name length should be greater than 0 but is" + arrName[2]);
		sf.assertAll();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
