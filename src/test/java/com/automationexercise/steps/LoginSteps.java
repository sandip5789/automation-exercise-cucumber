package com.automationexercise.steps;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignupLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {

    @Then("I Verify {string} is visible")
    public void iVerifyIsVisible(String text) {
        String expectedText = "Login to your account";
        String actualText = new SignupLoginPage().getLoginToYourAccountText();
        Assert.assertEquals(actualText, expectedText, "Login to your account not displayed");
    }

    @And("I Enter password {string}")
    public void iEnterPassword(String password) {

    }

    @And("I enter correct email address {string}, password {string}")
    public void iEnterCorrectEmailAddressPassword(String cEmail, String cPassword) {
        new SignupLoginPage().enterCorrectEmailAndPassword(cEmail, cPassword);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        new SignupLoginPage().clickOnLoginButton();
    }

    @And("I enter Incorrect email address {string}, password {string}")
    public void iEnterIncorrectEmailAddressPassword(String inCorrectEmail, String password) {
        new SignupLoginPage().enterInCorrectEmailAndPassword(inCorrectEmail, password);
    }

    @Then("I  Verify error {string} is visible")
    public void iVerifyErrorIsVisible(String text) {
        String expectedText = "Your email or password is incorrect!";
        String actualText = new SignupLoginPage().getYourEmailOrPasswordIsIncorrectText();
        Assert.assertEquals(actualText,expectedText,"Your email or password is incorrect message not displayed");
    }

    @And("I click Logout button")
    public void iClickLogoutButton() {
        new HomePage().clickOnLogout();
    }

    @Then("I Verify that user is navigated to login page")
    public void iVerifyThatUserIsNavigatedToLoginPage() {
        String expectedText = "Login to your account";
        String actualText = new SignupLoginPage().getLoginToYourAccountText();
        Assert.assertEquals(actualText, expectedText, "Login to your account not displayed");

    }

    @And("I Enter already registered email address {string}")
    public void iEnterAlreadyRegisteredEmailAddress(String regEmail) {
        new SignupLoginPage().enterEmailForSignup(regEmail);
    }

    @Then("I Verify error {string} is displayed")
    public void iVerifyErrorIsDisplayed(String text) {
        String expectedText = "Email Address already exist!";
        String actualText = new SignupLoginPage().getEmailAddressAlreadyExistText();
        Assert.assertEquals(actualText, expectedText, "Email Address already  not displayed");
    }
}
