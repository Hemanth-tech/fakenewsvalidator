package com.newsvalidator.module.step;

import com.newsvalidator.module.pages.GoogleSearchPage;
import com.newsvalidator.utilities.JsonUtilities;

public class GoogleClient extends BaseClient {

	GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);


	public void submitSearch(String news) {
		googleSearchPage.submitSearch(news);
		logger.info("submitted search on google");

	}

}
