package com.newsvalidator.module.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	protected static final Logger logger = LogManager.getLogger(BasePage.class);

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("initialising web elements");
	}

}
