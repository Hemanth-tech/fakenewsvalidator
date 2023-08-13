package com.newsvalidator.constants;


public enum ErrorCodes {
	
	/*
	 * To Provide customized error messages for assertions 
	 * */

	GUARDIAN_TITLE_MISMATCH("GUARDIAN_01", "Guardian page title mismatch"),

	GOOGLE_TITLE_MISMATCH("GOOGLE_01", "Google page title mismatch"),
	GUARDIAN_NEWS_FAKE_GOOGLE("GOOGLE_02", "Guardian news is fake as per google search"),

	BING_TITLE_MISMATCH("BING_01", "Bing page title mismatch"),
	GUARDIAN_NEWS_FAKE_BING("BING_02", "Guardian news is fake as per bing search"),

	
	FAKE_NEWS_IS_VALID_GOOGLE("NEWS_01", "news is not fake as per google"),
	FAKE_NEWS_IS_VALID_BING("NEWS_02", "news is not fake as per bing");



    
  

    private final String code;
    private final String message;

    ErrorCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
