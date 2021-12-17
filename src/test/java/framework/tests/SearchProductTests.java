package framework.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import framework.functionlibrary.HomePageLib;
import framework.functionlibrary.SearchResultsLib;
import utilities.DataProvider;
import utilities.selenium.WebDriverManager;

public class SearchProductTests {
	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	private HomePageLib hompagelib;
	private SearchResultsLib seareslib;
	SoftAssert sf;
	private String propfile = "src/test/resources/base.prop";
	private String url = DataProvider.getTestData(propfile, "url");
	private String searchParam = DataProvider.getTestData(propfile, "searchParam");

	@BeforeClass
	public void setUP() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");
		driver.get(url);
	}

	@BeforeMethod
	public void preReq() {
		sf = new SoftAssert();
	}

	@Test
	public void searchProductTest() {
		Reporter.log("Search for product in home page");
		hompagelib = new HomePageLib(driver);
		hompagelib.searchForProduct(searchParam);
		
		Reporter.log("Verify that all seaarch results contain the searched parameter");
		seareslib = new SearchResultsLib(driver);
		List<String> listProdNames = seareslib.getListOfProdNames();
		for (String prodName : listProdNames) {
			sf.assertTrue(prodName.toLowerCase().contains(searchParam.toLowerCase()),
					"FAIL | Actual product name" + prodName + "didn't contain search parameter" + searchParam);
		}
		sf.assertAll();
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}



