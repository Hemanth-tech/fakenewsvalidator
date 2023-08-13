package com.newsvalidator.module.step;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.newsvalidator.module.pages.BingSearchResultsPage;
import com.newsvalidator.utilities.JsonUtilities;
import com.newsvalidator.utilities.NewsValidatorUtilities;

public class BingSearchResultsClient extends BaseClient {

	BingSearchResultsPage bingSearchResultsPage = new BingSearchResultsPage(driver);
	String guardianDomain = JsonUtilities.getTestFlowData().getDomain();
	String newsString = JsonUtilities.getTestFlowData().getNews();

	public Integer searchResultsEvaluator(String searchType, Integer count) throws IOException {
			JsonUtilities.clearExistingData(searchType);

			List<WebElement> searchResults = bingSearchResultsPage.getSearchResults();
			Set<String> domains = new HashSet<String>();
			int checker = 0;

			for (WebElement searchResult : searchResults) {
				int currentIdex = searchResults.indexOf(searchResult);

				String newsHeadline = searchResult.getText();
				String linkUrl = searchResult.getAttribute("href");
				String domain = linkUrl.substring(8, linkUrl.indexOf('/', 9));

				if (domains.add(domain) && !newsHeadline.isEmpty() && !domain.equals(guardianDomain)) {

					double similarity = NewsValidatorUtilities.calculateSemanticSimilarity(newsString, newsHeadline);

					if (similarity > 0.6) {
						checker++;
					}

					JsonUtilities.setValues(currentIdex, domain, newsHeadline, similarity,searchType);
					logger.info("Headline " + searchResults.indexOf(searchResult) + ": " + newsHeadline);
					logger.info("domain " + domain);
					logger.info("Semantic Similarity: " + similarity);
					logger.info("--------------------------");

//	            if(checker>=2 || currentIdex==5 ) {
//	            	break;
//	            }

				}
			}
			
			return checker;

	}
}
