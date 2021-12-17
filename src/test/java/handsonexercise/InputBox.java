package handsonexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.selenium.WebDriverManager;

public class InputBox {

	private WebDriver driver;
	private WebDriverManager WebDrvMgr;
	WebDriverWait wait;
	private String val2;
	private String val;

	@BeforeClass
	public void setUp() {
		WebDrvMgr = new WebDriverManager();
		driver = WebDrvMgr.launchBrowser("edge");
		wait = new WebDriverWait(driver, 120);
		driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
	}

	@Test
	public void dynamicData() {
		driver.findElement(By.id("at-cv-lightbox-close")).click();
		WebElement oTypeBox = driver.findElement(By.xpath("//input[@id='sum1']"));
		oTypeBox.clear();
		oTypeBox.sendKeys("3");
		val = oTypeBox.getAttribute("value");
		System.out.println(val);
		WebElement oTypeBox2 = driver.findElement(By.xpath("//input[@id='sum2']"));
		oTypeBox2.clear();
		oTypeBox2.sendKeys("3");
		val2 = oTypeBox2.getAttribute("value");
		System.out.println(val2);
		WebElement oTotalSum = driver.findElement(By.xpath("//button[@onclick='return total()']"));
		oTotalSum.click();
		  if (!val.equals(0) && !val2.equals(0)) {
			WebElement oTotal = driver.findElement(By.xpath("//span[@id='displayvalue']"));
			System.out.println(oTotal.getText());

		} else {
			WebElement oTotal = driver.findElement(By.xpath("//span[@id='displayvalue']"));
			System.out.println(oTotal.getText());
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
