package com.newsvalidator.module.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage  extends BasePage{
	

	public GoogleSearchPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//*[@name='q']")
	private WebElement search;

	
	public void submitSearch(String news) {
		search.sendKeys(news);
		search.submit();
		logger.info("submitted google search");
	}

}
