package framework.tests;



import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import framework.functionlibrary.HomePageLibAssign;
import framework.functionlibrary.ProductPageLibAssign;
import framework.functionlibrary.SearchResultsLibAssign;
import utilities.DataProvider;
import utilities.selenium.WebDriverManager;
import utilities.selenium.WebDriverUtilities;

public class Assignment4 {
	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private HomePageLibAssign hompaglib;
	private SearchResultsLibAssign seareslib;
	private ProductPageLibAssign propaglib;
	WebDriverUtilities webDrvUtil;
	SoftAssert sf;

	private String propfile = "src/test/resources/base.prop";
	private String url = DataProvider.getTestData(propfile, "url");
	private String searchParam = DataProvider.getTestData(propfile, "searchParam");

	@BeforeClass
	public void setUp() {
		
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		webDrvUtil=new WebDriverUtilities(driver);
		driver.get(url);
	}

	@BeforeMethod
	public void preReq() {
		sf = new SoftAssert();
	}

	@Test
	public void productAddTest() throws InterruptedException {
		Reporter.log("search for product in homepage");
		hompaglib = new HomePageLibAssign(driver);
		hompaglib.searchForProduct(searchParam);
		Reporter.log("verify that all search results contained search result parameter");
		seareslib = new SearchResultsLibAssign(driver);
		seareslib.clickFirstSearchResultLink(1);
		Thread.sleep(2000);
		webDrvUtil.switchWindow();
		
		propaglib=new ProductPageLibAssign(driver);
		propaglib.addVerify();
		Thread.sleep(2000);
		driver.close();
		webDrvUtil.switchWindow();
		Thread.sleep(2000);
		
		
		
		
		
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}