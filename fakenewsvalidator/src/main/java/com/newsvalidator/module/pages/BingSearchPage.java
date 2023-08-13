package com.newsvalidator.module.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BingSearchPage extends BasePage{
	

	public BingSearchPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//*[@name='q']")
	private WebElement search;

	
	public void submitSearch(String news) {
		search.sendKeys(news);
		search.submit();
		logger.info("submitted bing search");
	}

}



