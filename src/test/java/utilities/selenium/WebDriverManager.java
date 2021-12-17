package utilities.selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class WebDriverManager {
	private  WebDriver driver;
		
	public WebDriver launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver","src/test/resources/drivers/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.edge.driver","src/test/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.edge.driver","src/test/resources/drivers/geckodriver.exe");
		driver=new FirefoxDriver();
			
		}
		else {
			Assert.fail("FAIL | invalid browser name passes.Vaild values are edge,chrome orff");
			
		}
		return driver;
	}

	
}

