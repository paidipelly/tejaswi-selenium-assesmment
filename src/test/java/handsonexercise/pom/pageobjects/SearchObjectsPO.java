package handsonexercise.pom.pageobjects;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchObjectsPO {
	WebDriver driver;

	public SearchObjectsPO(WebDriver driver) {
		this.driver = driver;
	}

	By searchresults = By.cssSelector("span.a-size-medium.a-color-base.a-text-normal");

	public List<String> getListOfProdNames() {
		List<String> searchResultsProdNames = new LinkedList<String>();
		List<WebElement> oList = driver.findElements(searchresults);
		for (WebElement oelem : oList) {
			String prodName = oelem.getText();
			searchResultsProdNames.add(prodName);
		}
		return searchResultsProdNames;
	}

}
