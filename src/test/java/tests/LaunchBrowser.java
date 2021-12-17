package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LaunchBrowser {
	@Test
public void launchEdgeBrowser() {
		WebDriver driver;
		System.setProperty("webdriver.edge.driver","src/test/resources/drivers/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get("https://google.co.in");
		driver.quit();
	}
	@Test
	public void launchChromeBrowser() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		 driver.get("https://google.co.in");
		driver.quit();
		
	}
	@Test
	public void launchFirefoxBrowser() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://google.co.in");
		driver.quit();
	}
	
	}
	
	

