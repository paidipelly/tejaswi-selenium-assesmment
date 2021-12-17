package tests;



import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import utilities.selenium.WebDriverManager;

public class LaunchBrowserByWDM {
  @Test
  public void launchEdgeBrowser() {
	  WebDriver driver;
	  WebDriverManager webDrvMgr = new WebDriverManager();
	  driver = webDrvMgr.launchBrowser("edge");
	  driver.get("https://google.co.in");
	  driver.quit();
	  
  }
  @Test
  public void launchChromeBrowser() {
	  WebDriver driver;
	  WebDriverManager webDrvMgr = new WebDriverManager();
	  driver = webDrvMgr.launchBrowser("chrome");
	  driver.get("https://google.co.in");
	  driver.quit();
  }
  @Test
  public void launchFirefoxBrowser() {
	  WebDriver driver;
	  WebDriverManager webDrvMgr = new WebDriverManager();
	  driver = webDrvMgr.launchBrowser("ff");
	  driver.get("https://google.co.in");
	  driver.quit();
  }
}