package com.automationexercise.pages;

import com.automationexercise.Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignupLoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(SignupLoginPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
    WebElement newUserSignupText;

    @CacheLookup
    @FindBy(name = "name")
    WebElement enterName;

    @CacheLookup
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement enterEmailSignUp;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Signup']")
    WebElement signupButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Login to your account']")
    WebElement loginToYourAccountText;

    @CacheLookup
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement emailAddressFieldForLogin;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordFieldForLogin;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    WebElement yourEmailOrPasswordIsIncorrectText;

    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Email Address already exist!']")
    WebElement emailAddressAlreadyExistText;

    public String getNewUserSignupText() {
        log.info("Get New User Signup text : " + newUserSignupText.getText());
        return getTextFromElement(newUserSignupText);
    }

    public void enterName(String name) {
        sendTextToElement(enterName, name);
        log.info("Enter Name : '" + enterName + "' to Name field");
    }

    public void enterEmailForSignup(String email) {
        sendTextToElement(enterEmailSignUp, email);
        log.info("Enter Email  : '" + enterEmailSignUp + "' to Email Signup field");
    }

    public void clickOnSignupButton() {
        log.info("Click on 'Signup' button");
        clickOnElement(signupButton);
    }

    public String getLoginToYourAccountText() {
        log.info("Get Login to your account text : " + loginToYourAccountText.getText());
        return getTextFromElement(loginToYourAccountText);
    }

    public void enterCorrectEmailAndPassword(String cEmail, String cPassword) {
        sendTextToElement(emailAddressFieldForLogin, cEmail);
        sendTextToElement(passwordFieldForLogin, cPassword);
        log.info("Entering correct email address and password");
    }

    public void clickOnLoginButton() {
        log.info("Click on 'Login' button");
        clickOnElement(loginButton);
    }

    public void enterInCorrectEmailAndPassword(String inCorrectEmail, String password) {
        sendTextToElement(emailAddressFieldForLogin, inCorrectEmail);
        sendTextToElement(passwordFieldForLogin, password);
        log.info("Entering InCorrect email address and password");
    }

    public String getYourEmailOrPasswordIsIncorrectText() {
        log.info("Get Your email or password is incorrect text : " + yourEmailOrPasswordIsIncorrectText.getText());
        return getTextFromElement(yourEmailOrPasswordIsIncorrectText);
    }

    public String getEmailAddressAlreadyExistText() {
        log.info("Get Email Address already exist text : " + emailAddressAlreadyExistText.getText());
        return getTextFromElement(emailAddressAlreadyExistText);
    }

}