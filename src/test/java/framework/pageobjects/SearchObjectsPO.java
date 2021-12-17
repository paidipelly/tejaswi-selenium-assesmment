package framework.pageobjects;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchObjectsPO {
	WebDriver driver;

	public SearchObjectsPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}
    @FindBy(css="span.a-size-medium.a-color-base.a-text-normal")
	private List<WebElement>searchResults;
	
	public List<WebElement>returnSearchResultsList(){
		return searchResults;
	}

}

	
