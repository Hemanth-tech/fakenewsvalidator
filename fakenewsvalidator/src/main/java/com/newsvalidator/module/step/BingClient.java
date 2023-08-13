package com.newsvalidator.module.step;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.newsvalidator.module.pages.BingSearchPage;
import com.newsvalidator.module.pages.GoogleSearchPage;
import com.newsvalidator.utilities.JsonUtilities;

public class BingClient extends BaseClient {
	protected static final Logger logger = LogManager.getLogger(BingClient.class);

	BingSearchPage bingSearchPage = new BingSearchPage(driver);

	public void submitSearch(String news) {
		bingSearchPage.submitSearch(news);
		logger.info("submitted search on bing");

	}

}
