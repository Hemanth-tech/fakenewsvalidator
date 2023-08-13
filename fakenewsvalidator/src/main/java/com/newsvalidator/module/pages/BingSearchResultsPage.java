package com.newsvalidator.module.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingSearchResultsPage extends BasePage {

	public BingSearchResultsPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(css = ".b_algo h2 a")
	private List<WebElement> searchResults;

	
	public List<WebElement> getSearchResults() {
	 return searchResults;
	}
}
