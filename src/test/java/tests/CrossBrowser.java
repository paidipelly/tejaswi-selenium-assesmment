package tests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.selenium.WebDriverManager;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;


public class CrossBrowser {
	WebDriver driver;
	WebDriverManager webDrvMgr;
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(@Optional("edge")String browser) {
	webDrvMgr=new WebDriverManager();
	driver=webDrvMgr.launchBrowser(browser);
	
	}
	@Test
	public void navigateToGoogleTest() throws InterruptedException{
		driver.get("http://www.google.co.in");
		Thread.sleep(20000);
	}
	@Test
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
		
		
		
	
	
