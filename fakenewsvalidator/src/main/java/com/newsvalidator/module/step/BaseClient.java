package com.newsvalidator.module.step;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.newsvalidator.driver.TestDriver;
import com.newsvalidator.utilities.FrameworkUtilities;
import com.newsvalidator.utilities.JsonUtilities;

public class BaseClient {
	
	WebDriver driver = TestDriver.getDriver();
	protected static final Logger logger = LogManager.getLogger(BaseClient.class);

	
	public void navigateTo(String UrlKey) {
		String url = FrameworkUtilities.environmnetProperties().getProperty(UrlKey);
		logger.info("navigating to url "+url);
		driver.get(url);
	}

	public String getClientTitle() {
		String title = driver.getTitle();
		logger.info("Title of current page "+title);
		return title;
	}
	


}
