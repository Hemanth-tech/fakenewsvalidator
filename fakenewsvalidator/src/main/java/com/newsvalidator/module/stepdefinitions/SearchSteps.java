package com.newsvalidator.module.stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.newsvalidator.constants.ErrorCodes;
import com.newsvalidator.module.step.BingClient;
import com.newsvalidator.module.step.GoogleClient;
import com.newsvalidator.module.step.GuardianClient;
import com.newsvalidator.utilities.FrameworkUtilities;
import com.newsvalidator.utilities.JsonUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SearchSteps {
	private static final Logger logger = LogManager.getLogger(SearchSteps.class);

	GoogleClient googleClient = new GoogleClient();
	BingClient bingClient = new BingClient();
	String news = JsonUtilities.getTestFlowData().getNews();

	String expectedGooglePageTitle = "Google";
	String expectedBingPageTitle = "Bing";

	@When("I search for similar article using {string}")
	public void searchForSimilarArticle(String searchType) {

		if (searchType.equals("google")) {
			googleClient.navigateTo(searchType);
			Assert.assertEquals(ErrorCodes.GOOGLE_TITLE_MISMATCH.getMessage(), googleClient.getClientTitle(),
					expectedGooglePageTitle);
			googleClient.submitSearch(news);
		}

		if (searchType.equals("bing")) {
			bingClient.navigateTo(searchType);
			Assert.assertEquals(ErrorCodes.BING_TITLE_MISMATCH.getMessage(), bingClient.getClientTitle(),
					expectedBingPageTitle);
			bingClient.submitSearch(news);
		}
	}

	@Given("I search for {string} article using {string}")
	public void searchForFakeNews(String fakeNews, String searchType) throws IOException {
		
		JsonUtilities.getTestFlowData().setFakeNews(fakeNews);
		JsonUtilities.updateTestFlowData();
		logger.info("Uploaded fake news to Json ");

		if (searchType.equals("google")) {
			googleClient.navigateTo(searchType);
			Assert.assertEquals(ErrorCodes.GOOGLE_TITLE_MISMATCH.getMessage(), googleClient.getClientTitle(),
					expectedGooglePageTitle);
			googleClient.submitSearch(fakeNews);
		}

		if (searchType.equals("bing")) {
			bingClient.navigateTo(searchType);
			Assert.assertEquals(ErrorCodes.BING_TITLE_MISMATCH.getMessage(), bingClient.getClientTitle(),
					expectedBingPageTitle);
			bingClient.submitSearch(fakeNews);
		}
	}

}
