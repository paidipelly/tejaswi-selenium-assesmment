package handsonexercise;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.selenium.WebDriverManager;


public class DatePicker{
	WebDriver driver;
	WebDriverManager webDrvMgr;
	WebDriverWait wait;
	SoftAssert sf;
	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");
	     wait = new WebDriverWait(driver, 120);
		driver.get("http://demo.seleniumeasy.com/bootstrap-date-picker-demo.html");
	}
	@BeforeMethod
	public void testPreReq() {
		sf=new SoftAssert();
	}
	@Test
	public void datePickerTest() {
		driver.findElement(By.cssSelector("i.glyphicon.glyphicon-th")).click();
		List<WebElement>oListDays=driver.findElements(By.cssSelector("th.dow"));
		sf.assertEquals(oListDays.size(),7);
		sf.assertEquals(oListDays.get(0).getText(),"Mo");
		String[] arrDaysOfWeek=new String[] {"Mo","Tu","We","Th","Fr","Sa","Su"};
		for(int loop=0;loop<oListDays.size();loop++) {
			String actual=oListDays.get(loop).getText();
			String exepected=arrDaysOfWeek[loop];
			sf.assertEquals(actual, exepected);
		}
		sf.assertAll();
		
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
		
	}


