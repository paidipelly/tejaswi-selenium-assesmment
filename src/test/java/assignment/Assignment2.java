package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.selenium.WebDriverManager;

public class Assignment2 {
	WebDriver driver;
	WebDriverManager webDrvMgr;

	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");
		driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}

	@Test
	public void assignmentTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='isAgeSelected']")).click();
		Thread.sleep(2000);
		WebElement chkbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
		if (chkbox.isSelected()) {
			System.out.print("checkbox is ON");
		} else {
			System.out.println("checkbox is off");
		}
		WebElement chkbox1 = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
		if (!chkbox1.isSelected()) {
			System.out.print("checkbox is ON");
		} else {
			System.out.println("checkbox is off");
		}

		List<WebElement> checkedAll = driver.findElements(By.id("check1"));
		int a = checkedAll.size();
		for (int i = 0; i < a; i++) {
			checkedAll.get(i).click();
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}