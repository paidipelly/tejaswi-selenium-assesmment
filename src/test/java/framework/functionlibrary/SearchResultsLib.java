package framework.functionlibrary;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.pageobjects.SearchObjectsPO;

public class SearchResultsLib {
	WebDriver driver;
	SearchObjectsPO searespo;

	public SearchResultsLib(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> getListOfProdNames() {
		searespo = new SearchObjectsPO(driver);
		List<WebElement> oList = searespo.returnSearchResultsList();
		List<String> searchResultsProdNames = new LinkedList<String>();
		for (WebElement oelem : oList) {
			String prodName = oelem.getText();
			searchResultsProdNames.add(prodName);
		}
		return searchResultsProdNames;
	}

	public void clicknthSearchResultLink(int resultNum) {
		searespo = new SearchObjectsPO(driver);
		List<WebElement> oList = searespo.returnSearchResultsList();
		oList.get(resultNum - 1).click();

	}

	public int returnSearchResultsCount() {
		searespo = new SearchObjectsPO(driver);
		List<WebElement> oList = searespo.returnSearchResultsList();
		return oList.size();

	}

}
