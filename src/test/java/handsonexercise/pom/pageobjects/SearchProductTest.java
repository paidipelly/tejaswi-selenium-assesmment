package handsonexercise.pom.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import handsonexercise.pom.pageobjects.HomePagePO;
import handsonexercise.pom.pageobjects.SearchObjectsPO;
import utilities.selenium.WebDriverManager;

public class SearchProductTest {
	WebDriver driver;
	HomePagePO hompo;
	SearchObjectsPO searespo;
	WebDriverManager webDrvMgr;
	SoftAssert sf;

	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("edge");
		driver.get("https://www.amazon.in");
		hompo = new HomePagePO(driver);
		searespo = new SearchObjectsPO(driver);
	}

	@BeforeMethod
	public void preReq() {
		sf = new SoftAssert();
	}

	@Test
	public void searchProductTest() {
		String searchParam = "iPhone";
		hompo.searchForProduct(searchParam);
		List<String> listProdNames = searespo.getListOfProdNames();
		for (String prodName : listProdNames) {
			sf.assertTrue(prodName.toLowerCase().contains(searchParam.toLowerCase()),
					"FAIL |Product name" + prodName + "didn't contain search parameter" + searchParam);

		}
		sf.assertAll();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
