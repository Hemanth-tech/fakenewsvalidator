
package com.newsvalidator.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.newsvalidator.pojo.SearchResult;
import com.newsvalidator.pojo.TestFlowJson;

public class JsonUtilities {
	protected static final Logger logger = LogManager.getLogger(JsonUtilities.class);

	private static TestFlowJson testFlowJson;
	public static String testDataPath = FrameworkUtilities.ConfigFileReader().getProperty("testData");

	public static TestFlowJson getTestFlowData() {

		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(testDataPath));
			testFlowJson = gson.fromJson(bufferReader, TestFlowJson.class);
			return testFlowJson;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Test data Json file not found at path : " + testDataPath);
		}
	}

	public static void clearExistingData(String type) throws IOException {
		BufferedReader bufferReader = new BufferedReader(new FileReader(testDataPath));

		JsonObject jsonObject = new Gson().fromJson(bufferReader, JsonObject.class);

		if (type.equals("google")) {
			jsonObject.remove("googleSearchResults");
		}
		if (type.equals("bing")) {
			jsonObject.remove("bingSearchResults");
		}
		if (type.equals("googleFake")) {
			jsonObject.remove("fakeGoogleSearchResults");
		}
		if (type.equals("bingFake")) {
			jsonObject.remove("fakeBingSearchResults");
		}
		testFlowJson = new Gson().fromJson(jsonObject, TestFlowJson.class);

		updateTestFlowData();

	}

	public static void updateTestFlowData() throws IOException {
		Gson gson = new Gson();
		try {
			File jsonFile = new File(testDataPath);
			OutputStream outputStream = new FileOutputStream(jsonFile);
			outputStream.write(gson.toJson(testFlowJson).getBytes());
			outputStream.flush();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Test data Json file not found at updating : " + testDataPath);
		}
	}

	public static void setValues(int index, String domain, String newsHeadline, double similarity, String type)
			throws IOException {
		List<SearchResult> searchResultsList = null ;
		if (type.equals("google")) {
			searchResultsList = getTestFlowData().getgoogleSearchResults();
		}
		if (type.equals("bing")) {
			searchResultsList = getTestFlowData().getbingSearchResults();
		}
		if (type.equals("googleFake")) {
			searchResultsList = getTestFlowData().getFakeGoogleSearchResults();
		}
		if (type.equals("bingFake")) {
			searchResultsList = getTestFlowData().getFakeBingSearchResults();
		}

		if (searchResultsList == null)
			searchResultsList = new ArrayList<SearchResult>();

		SearchResult searchResult = new SearchResult();
		searchResult.setDomain(domain);
		searchResult.setDomainNews(newsHeadline);
		searchResult.setSimilarity(similarity);
		searchResultsList.add(searchResult);
		if (type.equals("google")) {
			getTestFlowData().setgoogleSearchResults(searchResultsList);	
			}
		if (type.equals("bing")) {
			getTestFlowData().setbingSearchResults(searchResultsList);		
			}
		if (type.equals("googleFake")) {
			getTestFlowData().setFakeGoogleSearchResults(searchResultsList);	
			}
		if (type.equals("bingFake")) {
			getTestFlowData().setFakeBingSearchResults(searchResultsList);		
			}
		updateTestFlowData();

	}

}
