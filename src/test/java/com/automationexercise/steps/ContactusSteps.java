package com.automationexercise.steps;

import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ContactusSteps {
    @Then("I Verify {string} is visible in contact us page")
    public void iVerifyIsVisibleInContactUsPage(String text) {
        String expectedText = "GET IN TOUCH";
        String actualText = new ContactUsPage().getGetInTouchText();
        Assert.assertEquals(actualText, expectedText, "Get in touch not displayed");
    }

    @And("I  Enter name {string}, email {string}, subject {string} and message {string}")
    public void iEnterNameEmailSubjectAndMessage(String name, String email, String subject, String message) {
        new ContactUsPage().enterNameAndEmailAndSubjectAndMessage(name, email, subject, message);
    }

    @And("I upload file")
    public void iUploadFile() {
        new ContactUsPage().uploadFile();

    }

    @And("I Click {string} button")
    public void iClickButton(String buttonText) {
        if(buttonText.equals("Submit")){
            new ContactUsPage().clickOnSubmitButton();
        } else if( buttonText.equals("OK")) {
            new ContactUsPage().clickOnOkButton();
        } else if (buttonText.equals("Home")) {
            new ContactUsPage().clickOnHomeButton();
        }
    }

    @Then("I Verify text {string} is visible")
    public void iVerifyTextIsVisible(String text) {
        String expectedText = "Success! Your details have been submitted successfully.";
        String actualText = new ContactUsPage().getSuccessFullyText();
        Assert.assertEquals(actualText,expectedText,"Success message not displayed");
    }

    @Then("I verify that landed to home page successfully.")
    public void iVerifyThatLandedToHomePageSuccessfully() {
        new HomePage().verifyHomePage();
    }
}
