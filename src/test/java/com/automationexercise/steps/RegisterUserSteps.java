package com.automationexercise.steps;

import com.automationexercise.Utility.Utility;
import com.automationexercise.pages.AccountRelatedPage;
import com.automationexercise.pages.EnterAccountInformationPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignupLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RegisterUserSteps {

    static String email;

    @Given("I Navigate to url {string}")
    public void iNavigateToUrl(String url) {
        new HomePage().navigateToUrl(url);
    }

    @Then("I Verify that home page is visible successfully")
    public void iVerifyThatHomePageIsVisibleSuccessfully() {
        new HomePage().verifyHomePage();
    }


    @When("I click on {string} button")
    public void iClickOnButton(String topMenuItem) {
        new HomePage().selectFromTopMenu(topMenuItem);
    }

    @Then("I  Verify {string} is visible")
    public void iVerifyIsVisible(String message) {
        Assert.assertTrue(new SignupLoginPage().getNewUserSignupText().contains(message), "Signup Message not displayed");
    }

    @And("I  Enter name {string}")
    public void iEnterName(String name) {
        new SignupLoginPage().enterName(name);
    }

    @And("I Enter email address {string}")
    public void iEnterEmailAddress(String email) {
        this.email = Utility.getRandomString(3) + email;
        new SignupLoginPage().enterEmailForSignup(this.email);
    }

    @And("I click on Signup button")
    public void iClickOnSignupButton() {
        new SignupLoginPage().clickOnSignupButton();
    }

    @Then("I verify that {string} is visible")
    public void iVerifyThatIsVisible(String message) {
        Assert.assertTrue(new EnterAccountInformationPage().getEnterAccountInformationText().contains(message), "Enter Account Information not visible");
    }


    @And("I Fill details Title, Name, Email, Password {string} , Date Of Birth {string},{string},{string}")
    public void iFillDetailsTitleNameEmailPasswordDateOfBirth(String password, String day, String month, String year) {
        new EnterAccountInformationPage().enterTitleNameEmailPasswordAndDateOfBirth(password, day, month, year);
    }

    @And("I Select checkbox Sign up for our newsletter!")
    public void iSelectCheckboxSignUpForOurNewsletter() {
        new EnterAccountInformationPage().clickOnSignUpForOurNewsletterCheckbox();
    }


    @And("I Select checkbox Receive special offers from our partners!")
    public void iSelectCheckboxReceiveSpecialOffersFromOurPartners() {
        new EnterAccountInformationPage().clickOnReceiveSpecialOffersFromPartnersCheckbox();
    }

    @And("I fill details with firstName {string} lastName {string} company {string} address {string} addressTwo {string} country {string} state {string} city {string} zipcode {string} mobile Number {string}")
    public void iFillDetailsWithFirstNameLastNameCompanyAddressAddressTwoCountryStateCityZipcodeMobileNumber() {
    }

    @And("I fill details with firstName {string} lastName {string} company {string} address {string} addressTwo {string} country {string} state {string} city {string} zipcode {string} mobileNumber {string}")
    public void iFillDetailsWithFirstNameLastNameCompanyAddressAddressTwoCountryStateCityZipcodeMobileNumber(String firstName, String lastName, String company, String address, String addressTwo, String country, String state, String city, String zipcode, String mobileNumber) {
        new EnterAccountInformationPage().fillPersonalDetails(firstName, lastName, company, address, addressTwo, country, state, city, zipcode, mobileNumber);
    }

    @And("I Click on Create Account button")
    public void iClickOnCreateAccountButton() {
        new EnterAccountInformationPage().clickOnCreateAccountButton();
    }

    @Then("I Verify that {string} is displayed")
    public void iVerifyThatIsDisplayed(String message) {
        Assert.assertTrue(new AccountRelatedPage().getAccountCreatedText().contains(message), "Account not created");
    }

    @And("I Click Continue button")
    public void iClickContinueButton() {
        new AccountRelatedPage().clickOnContinueButton();
    }

    @Then("I  Verify that {string} username is visible")
    public void iVerifyThatUsernameIsVisible(String text) {
        Assert.assertTrue(new HomePage().getLoggedInAsLinkDisplayed().contains(text), "Logged in as user name not displayed");
    }

    @And("I click Delete Account button")
    public void iClickDeleteAccountButton() {
        new HomePage().clickOnDeleteAccount();
    }

    @Then("I  Verify that {string} is visible after deleted")
    public void iVerifyThatIsVisibleAfterDeleted(String text) {
        String expectedText = "ACCOUNT DELETED!";
        String actualText = new AccountRelatedPage().getAccountDeletedText();
        Assert.assertEquals(actualText,expectedText,"Account Deleted text not displayed");
    }

}
