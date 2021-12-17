 package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.selenium.WebDriverManager;

public class Assignment3 {
	
	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	WebDriverWait wait;
	SoftAssert sf;

	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		wait = new WebDriverWait(driver, 120);
		driver.get("http://demo.seleniumeasy.com/");
	}
	
	@BeforeClass
	public void preReq() {
		sf=new SoftAssert();
	}

	
	@Test
	public void framesTest() throws InterruptedException {
	
		driver.findElement(By.xpath("//a[text()='Table']")).click();
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath("//li[@style='display: list-item;']//a[text()='Table Pagination']")).click();
		
		WebElement oElem=driver.findElement(By.xpath("//ul[@id='myPager']"));
		WebElement oElem2=driver.findElement(By.xpath("//ul[@id='myPager']//a[contains(text(),'2')]"));
		oElem2.click();
		WebElement oElem3=driver.findElement(By.xpath("//ul[@id='myPager']//a[contains(text(),'3')]"));
		oElem3.click();
		try {
			driver.findElement(By.cssSelector("a.page_link"));
			System.out.println("Page links are available");
		}catch(Exception ex) {
			System.out.println("Page links are not available");
		}	

		try {
		WebElement ip1=driver.findElement(By.xpath("//li[@class='tree-branch']//a[contains(text(),'Input Forms')]"));
		ip1.click();
		WebElement ip2=driver.findElement(By.xpath("//li[@class='tree-branch']//a[contains(text(),'Input Form Submit')]"));
		ip2.click();
		driver.findElement(By.xpath("//input[@name='last_name']")).clear();
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@name='email']")).clear();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("@456");
		driver.findElement(By.xpath("//input[@name='phone']")).clear();
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("37456");
		driver.findElement(By.xpath("//input[@name='address']")).clear();
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@name='city']")).clear();
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("jgl");
		
		driver.findElement(By.cssSelector("select.form-control.selectpicker")).click();
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("hzb");
		
		driver.findElement(By.xpath("//input[@name='zip']")).clear();
		driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("ccc");
		driver.findElement(By.xpath("//input[@name='website']")).clear();
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("http://www.google.co.in");
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		
		driver.findElement(By.xpath("//textarea[@class='form-control']")).clear();
		driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("na");
		
		
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Alerts & Modals')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Bootstrap Alerts')]")).click();
		driver.findElement(By.xpath("//button[@id='normal-btn-success']")).click();
		
		}catch(Exception ex) {
			System.out.println("Enter valid details");
		}
		
		sf.assertAll();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
