package com.newsvalidator.module.stepdefinitions;

import java.io.IOException;

import org.junit.Assert;

import com.newsvalidator.constants.ErrorCodes;
import com.newsvalidator.module.step.BingSearchResultsClient;
import com.newsvalidator.module.step.GoogleClient;
import com.newsvalidator.module.step.GoogleSearchResultsClient;

import io.cucumber.java.en.Then;

public class SearchResultsSteps {

	GoogleSearchResultsClient googleSearchResultsClient = new GoogleSearchResultsClient();
	BingSearchResultsClient bingSearchResultsClient = new BingSearchResultsClient();

	@Then("I should see at least {string} similar {string} articles")
	public void verifySimilarArticleCount(String expectedCount, String searchType)
			throws NumberFormatException, IOException {
		if (searchType.equals("google")) {
			Integer count = googleSearchResultsClient.searchResultsEvaluator(searchType,
					Integer.parseInt(expectedCount));
			Assert.assertTrue(ErrorCodes.GUARDIAN_NEWS_FAKE_GOOGLE.getMessage(),
					count >= Integer.parseInt(expectedCount));
		}

		if (searchType.equals("bing")) {
			Integer count = bingSearchResultsClient.searchResultsEvaluator(searchType, Integer.parseInt(expectedCount));
			Assert.assertTrue(ErrorCodes.GUARDIAN_NEWS_FAKE_BING.getMessage(),
					count >= Integer.parseInt(expectedCount));
		}
	}

	@Then("I should not see {string} similar {string} articles")
	public void verifyFakeArticleCount(String expectedCount, String searchType)
			throws NumberFormatException, IOException {
		if (searchType.equals("googleFake")) {
			Integer count = googleSearchResultsClient.searchResultsEvaluator(searchType, Integer.parseInt(expectedCount));
			Assert.assertTrue(ErrorCodes.FAKE_NEWS_IS_VALID_GOOGLE.getMessage(),
					count <= Integer.parseInt(expectedCount));
		}

		if (searchType.equals("bingFake")) {
			Integer count = bingSearchResultsClient.searchResultsEvaluator(searchType, Integer.parseInt(expectedCount));
			Assert.assertTrue(ErrorCodes.FAKE_NEWS_IS_VALID_BING.getMessage(),
					count <= Integer.parseInt(expectedCount));
		}
	}

}
