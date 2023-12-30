package com.automationexercise.pages;

import com.automationexercise.Utility.Utility;
import com.automationexercise.propertyreader.PropertyReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='shop-menu pull-right']/child::ul/li/a")
    List<WebElement> topMenuLinks;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),' Logged in as ')]")
    WebElement loggedInAsLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    WebElement deleteAccountLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutLink;

    @CacheLookup
    @FindBy(xpath = "//a[@href='/products']")
    WebElement productsLink;

    @CacheLookup
    @FindBy (xpath = "//h2[normalize-space()='Subscription']")
    WebElement subscriptionText;

    @CacheLookup
    @FindBy (xpath = "//input[@id='susbscribe_email']")
    WebElement subscriptionEmail;

    @CacheLookup
    @FindBy (xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    WebElement subscriptionArrowButton;

    @CacheLookup
    @FindBy (xpath = "//div[@class='alert-success alert']")
    WebElement subscriptionSuccessMessage;

    @CacheLookup
    @FindBy (xpath = "//h2[normalize-space()='recommended items']")
    WebElement recommendedItemsText;

    @CacheLookup
    @FindBy (xpath = "//div[@id = 'recommended-item-carousel']//div[@class = 'productinfo text-center']/p")
    List<WebElement> recommendedItemsProductsList;

    @CacheLookup
    @FindBy (xpath = "//div[@class='product-image-wrapper']/div/div/p")
    List<WebElement> productList;

    @CacheLookup
    @FindBy (xpath = "//i[@class='fa fa-angle-up']")
    WebElement bottomRightArrowButton;

    @CacheLookup
    @FindBy (xpath = "//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]")
    WebElement fullFledgedText;






    public void selectFromTopMenu(String topMenuItem) {
        List<WebElement> list = topMenuLinks;
        for (WebElement name : list) {
            if (name.getText().trim().equalsIgnoreCase(topMenuItem)) {
                mouseHoverToElementAndClick(name);
                log.info("hover to menu and click on element.");
                break;
            }
        }
    }

    public void navigateToUrl(String url) {
        log.info("Navigating to current url");
        driver.navigate().to(url);
    }

    public void verifyHomePage() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = PropertyReader.getInstance().getProperty("baseUrl");
        log.info("verifying homepage url.");
        AssertJUnit.assertEquals(expectedUrl, actualUrl);
    }

    public String getLoggedInAsLinkDisplayed() {
        log.info("Getting account created message: " + loggedInAsLink.toString());
        return getTextFromElement(loggedInAsLink);
    }
    public void clickOnDeleteAccount(){
        clickOnElement(deleteAccountLink);
        log.info("Clicking on Delete Account button: " + deleteAccountLink.toString());
    }
    public void clickOnLogout(){
        clickOnElement(logoutLink);
        log.info("Clicking on Logout button: " + logoutLink.toString());
    }
    public void clickOnProductsLink(){
        mouseHoverToElementAndClick(productsLink);
    }
    public void scrollDownToSubscriptionLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", subscriptionText);
        log.info("Scroll Down to Subscription");
    }
    public String getSubscriptionText() {
        log.info("Getting Subscription text : " + subscriptionText.toString());
        return getTextFromElement(subscriptionText);
    }

    public void sendDataToSubscriptionEmail(String email) {
        sendTextToElement(subscriptionEmail, email);
        log.info("Sending " + email + " to subscription email field : " + subscriptionEmail.toString());
    }

    public void  clickOnArrowToSubscribe() {
        clickOnElement(subscriptionArrowButton);
        log.info("Clicking on subscription arrow button : " + subscriptionArrowButton.toString());
    }

    public String getSubscriptionSuccessMessage() {
        log.info("Getting subscription success message : " + subscriptionSuccessMessage.toString());
        return getTextFromElement(subscriptionSuccessMessage);
    }
    public void scrollDownToRecommendedItems() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", recommendedItemsText);
        log.info("Scroll Down to recommended items");
    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0)", "");
        log.info("Scroll up to (0,0)");
    }
    public String getRecommendedItemText() {
        log.info("Getting recommended items text : " + recommendedItemsText.toString());
        return getTextFromElement(recommendedItemsText);
    }
    public void clickAddToCartOnRecommendedItems(String pName){
        for (WebElement pr : recommendedItemsProductsList) {
            if(pr.getText().equalsIgnoreCase(pName)) {
                driver.findElement(with(By.xpath("//a[@class='btn btn-default add-to-cart']")).below(pr)).click();
                log.info("Click on " + pName + " Add to Cart button : " + productList.toString());
                break;
            }
        }
    }
    public void clickOnBottomRightArrowButton() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", bottomRightArrowButton);
        log.info("Clicking on bottom right corner arrow button : " + bottomRightArrowButton.toString());
    }

    public String getFullFledgedText() {
        log.info("Getting full fledged text from top of the page : " + fullFledgedText.toString());
        return getTextFromElement(fullFledgedText);
    }

}