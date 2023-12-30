package com.automationexercise.pages;

import com.automationexercise.Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountRelatedPage extends Utility {
    private static final Logger log = LogManager.getLogger(AccountRelatedPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    WebElement accountCreatedText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    WebElement accountDeletedText;




    public String getAccountCreatedText() {
        log.info("Getting account created message: " + accountCreatedText.toString());
        return getTextFromElement(accountCreatedText);
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
        log.info("Clicking on continue button: " + continueButton.toString());
    }
    public String getAccountDeletedText() {
        log.info("Getting account deleted message: " +accountDeletedText.toString());
        return getTextFromElement(accountDeletedText);
    }
}
