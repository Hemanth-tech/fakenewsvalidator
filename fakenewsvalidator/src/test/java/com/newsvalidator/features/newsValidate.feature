Feature: News Validation

  Scenario: Validate a news article from The Guardian
    Given I am on The Guardian news article page
    And I get the first news article from Guardain
    When I search for similar article using "google"
    Then I should see at least "2" similar "google" articles
    
    
 Scenario: Validate a news article from The Guardian
    Given I am on The Guardian news article page
    And I get the first news article from Guardain
    When I search for similar article using "bing"
    Then I should see at least "2" similar "bing" articles
    
        
Scenario: Validate a fake news article on Google
    Given I search for "some fake news" article using "google"
    Then I should not see "2" similar "googleFake" articles
    
Scenario: Validate a fake news article on Google
    Given I search for "some fake news" article using "bing"
    Then I should not see "2" similar "bingFake" articles