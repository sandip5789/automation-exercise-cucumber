package com.automationexercise.pages;

import com.automationexercise.Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class EnterAccountInformationPage extends Utility {

    private static final Logger log = LogManager.getLogger(EnterAccountInformationPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    WebElement enterAccountInformationText;

    @CacheLookup
    @FindBy(id = "id_gender1")
    WebElement mrField;

    @CacheLookup
    @FindBy(id = "id_gender2")
    WebElement mrsField;

    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "days")
    WebElement dateOfBirthDayField;

    @CacheLookup
    @FindBy(id = "months")
    WebElement dateOfBirthMonthField;

    @CacheLookup
    @FindBy(id = "years")
    WebElement dateOfBirthYearField;

    @CacheLookup
    @FindBy(id = "newsletter")
    WebElement signUpForNewsletterCheckbox;

    @CacheLookup
    @FindBy(id = "optin")
    WebElement receiveOfferCheckbox;

    @CacheLookup
    @FindBy(id = "first_name")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(id = "last_name")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(id = "company")
    WebElement companyField;

    @CacheLookup
    @FindBy(id = "address1")
    WebElement address1Field;

    @CacheLookup
    @FindBy(id = "address2")
    WebElement address2Field;

    @CacheLookup
    @FindBy(id = "country")
    WebElement countryField;

    @CacheLookup
    @FindBy(id = "state")
    WebElement stateField;

    @CacheLookup
    @FindBy(id = "city")
    WebElement cityField;

    @CacheLookup
    @FindBy(id = "zipcode")
    WebElement zipcodeField;

    @CacheLookup
    @FindBy(id = "mobile_number")
    WebElement mobileNumberField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    WebElement createAccountField;

    public String getEnterAccountInformationText() {
        log.info("Get Enter Account Information text : " + enterAccountInformationText.getText());
        return getTextFromElement(enterAccountInformationText);
    }
    public void enterTitleNameEmailPasswordAndDateOfBirth(String password, String day, String month, String year){
        clickOnElement(mrField);
        sendTextToElement(passwordField,password);
        selectByVisibleTextFromDropDown(dateOfBirthDayField,day);
        selectByVisibleTextFromDropDown(dateOfBirthMonthField,month);
        selectByVisibleTextFromDropDown(dateOfBirthYearField,year);
        log.info("Filled Password and Date of Birth field");
        // No need name and email again as its print again
    }

    public void clickOnSignUpForOurNewsletterCheckbox(){
        WebElement element = signUpForNewsletterCheckbox;
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        log.info("Clicking on newsletter button: " + signUpForNewsletterCheckbox.toString());
    }
    public void clickOnReceiveSpecialOffersFromPartnersCheckbox(){
        WebElement element = receiveOfferCheckbox;
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        log.info("Clicking on receive offer button: " + receiveOfferCheckbox.toString());
    }
    public void fillPersonalDetails(String firstName, String lastName, String company, String address, String addressTwo, String country, String state, String city, String zipcode, String mobileNumber){
        sendTextToElement(firstNameField,firstName);
        sendTextToElement(lastNameField,lastName);
        sendTextToElement(companyField,company);
        sendTextToElement(address1Field,address);
        sendTextToElement(address2Field,addressTwo);
        selectByVisibleTextFromDropDown(countryField,country);
        sendTextToElement(stateField,state);
        sendTextToElement(cityField,city);
        sendTextToElement(zipcodeField,zipcode);
        sendTextToElement(mobileNumberField,mobileNumber);
        log.info("Filled All details to field");
    }
    public void clickOnCreateAccountButton()  {
        WebElement element = createAccountField;
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        log.info("Clicking on create account: " + createAccountField.toString());
    }

}
