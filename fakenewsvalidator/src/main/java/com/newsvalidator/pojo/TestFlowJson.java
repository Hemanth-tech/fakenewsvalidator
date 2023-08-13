package com.newsvalidator.pojo;

import java.util.List;

public class TestFlowJson {
 // lombok plugin can be used 
	private String news;
	private String fakeNews;
	private int count;
    private String domain;
	private List<SearchResult> googleSearchResults;
	private List<SearchResult> bingSearchResults;
	private List<SearchResult> fakeGoogleSearchResults;
	private List<SearchResult> fakeBingSearchResults;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getfakeNews() {
		return fakeNews;
	}

	public void setFakeNews(String fakeNews) {
		this.fakeNews = fakeNews;
	}
	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<SearchResult> getgoogleSearchResults() {
		return googleSearchResults;
	}

	public void setgoogleSearchResults(List<SearchResult> googleSearchResults) {
		this.googleSearchResults = googleSearchResults;
	}
	
	public List<SearchResult> getbingSearchResults() {
		return bingSearchResults;
	}

	public void setbingSearchResults(List<SearchResult> bingSearchResults) {
		this.bingSearchResults = bingSearchResults;
	}
	
	public List<SearchResult> getFakeGoogleSearchResults() {
		return fakeGoogleSearchResults;
	}

	public void setFakeGoogleSearchResults(List<SearchResult> fakeGoogleSearchResults) {
		this.fakeGoogleSearchResults = fakeGoogleSearchResults;
	}
	
	public List<SearchResult> getFakeBingSearchResults() {
		return fakeBingSearchResults;
	}

	public void setFakeBingSearchResults(List<SearchResult> fakeBingSearchResults) {
		this.fakeBingSearchResults = fakeBingSearchResults;
	}

}
