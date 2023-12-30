package com.automationexercise.pages;

import com.automationexercise.Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends Utility {

    private static final Logger log = LogManager.getLogger(ContactUsPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    WebElement getInTouchText;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement nameField;

    @CacheLookup
    @FindBy(name = "email")
    WebElement emailField;

    @CacheLookup
    @FindBy(name = "subject")
    WebElement subjectField;

    @CacheLookup
    @FindBy(id = "message")
    WebElement messageField;

    @CacheLookup
    @FindBy(name = "upload_file")
    WebElement chooseFileButton;

    @CacheLookup
    @FindBy(name = "submit")
    WebElement submitButton;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-success']")
    WebElement homeButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successText;



    public String getGetInTouchText() {
        log.info("Getting get in touch message: " + getInTouchText.toString());
        return getTextFromElement(getInTouchText);
    }
    public void enterNameAndEmailAndSubjectAndMessage(String name, String email, String subject, String message){
        sendTextToElement(nameField, name);
        sendTextToElement(emailField, email);
        sendTextToElement(subjectField, subject);
        sendTextToElement(messageField, message);
        log.info("Entering all field");
    }
    public void uploadFile(){
        sendTextToElement(chooseFileButton, "C:/Users/sandi/IdeaProjects/gitdemo/b.txt");
    }
    public void clickOnSubmitButton(){
        WebElement element = submitButton;
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        log.info("Clicking on submit button: " + submitButton.toString());
    }
    public void clickOnOkButton(){
        switchToAlert();
        acceptAlert();
    }
    public void clickOnHomeButton(){
        clickOnElement(homeButton);
        log.info("Clicking on home button: " + homeButton.toString());
    }
    public String getSuccessFullyText() {
        log.info("Getting success message: " + successText.toString());
        return getTextFromElement(successText);
    }
}
