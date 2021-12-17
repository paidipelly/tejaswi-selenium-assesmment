package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.selenium.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class NavigateToGoogle {
	WebDriver driver;
	WebDriverManager webDrvMgr;
	SoftAssert a;
	@BeforeClass
	public void setup1() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get("http://www.google.co.in");
	}
	@BeforeMethod
	public void setup() {
		a=new SoftAssert();
	}

	@Test
	public void navigateToGoogleTest() {
    	String title = driver.getTitle();
		//System.out.println(title);
		a.assertEquals(title, "Google");
		String url = driver.getCurrentUrl();
		//System.out.println(url);
		a.assertEquals(url,"http://www.google.co.in");
		WebElement oelem = driver.findElement(By.cssSelector("div.uU7dJb"));
		String innerText = oelem.getText();
		//System.out.println(innerText);
		a.assertEquals(innerText,"India");
		String attribClass = oelem.getAttribute("class");
		//System.out.println(attribClass);
		a.assertEquals(attribClass,"div.uU7dJb");

		List<WebElement> oList = driver.findElements(By.cssSelector("div.KxwPGc.AghGtd>*"));
		for (WebElement oElem : oList) {
			String innertext = oElem.getText();
			System.out.println(innertext);
		}
		a.assertAll();
	}
	@AfterMethod
	public void clearObjects() {
		a=null;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
		
		
		