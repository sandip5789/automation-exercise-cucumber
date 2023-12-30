package com.automationexercise.pages;

import com.automationexercise.Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends Utility {

    private static final Logger log = LogManager.getLogger(TestCasesPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Test Cases']")
    WebElement testCasesText;

    public String getTestCasesText() {
        log.info("Getting Test Cases Text: " + testCasesText.toString());
        return getTextFromElement(testCasesText);
    }

}