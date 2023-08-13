package com.newsvalidator.module.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GuardianPage  extends BasePage{


	public GuardianPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	}

	@FindBy(xpath = "//iframe[@title='The Guardian consent message']")
	private WebElement iframeTitle;

	@FindBy(xpath = "//button[@title='Yes, I’m happy']")
	private WebElement acceptCookies;
	
	@FindBy(xpath = "(//li[@class='pillars__item'])[1]")
	private WebElement newsNavigator;
	
	@FindBy(xpath = "(//div[@id='container-headlines']//a)[1]")
	private WebElement firstArticleAtGaurdian;

	@FindBy(xpath = "(//span[@class='js-headline-text'])[2]")
	private WebElement firstArticle;

	public WebElement getIframeElement() {
		wait.until(ExpectedConditions.visibilityOf(iframeTitle));
		return iframeTitle;
	}

	public void clickAcceptCookies() {
		driver.switchTo().frame(getIframeElement());
		acceptCookies.click();
		driver.switchTo().defaultContent();

	}

	public String getFirstNews() {
		return firstArticle.getText();
	}
	
	public void navigateToNews() {
		newsNavigator.click();
	}
	
	public String getfirstArticleAtGaurdian() {
		return firstArticleAtGaurdian.getAttribute("aria-label");
	}

}
