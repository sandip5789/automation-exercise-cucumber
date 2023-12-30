package com.automationexercise.steps;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.TestCasesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomepageSteps {

    @Then("I Verify user is navigated to {string} page successfully")
    public void iVerifyUserIsNavigatedToPageSuccessfully(String text) {
        Assert.assertTrue(new TestCasesPage().getTestCasesText().contains(text),"Test Cases not displayed");
    }

    @When("I scroll down up to subscription link")
    public void iScrollDownUpToSubscriptionLink() {
        new HomePage().scrollDownToSubscriptionLink();
    }
    @Then("I should see {string} text")
    public void iShouldSeeText(String expectedText) {
        Assert.assertEquals(new HomePage().getSubscriptionText(), expectedText);
    }

    @And("I enter email {string}")
    public void iEnterEmail(String email) {
        new HomePage().sendDataToSubscriptionEmail(email);
    }

    @And("I click on arrow button")
    public void iClickOnArrowButton() {
        new HomePage().clickOnArrowToSubscribe();
    }

    @And("I should see the success subscription message {string}")
    public void iShouldSeeTheSuccessSubscriptionMessage(String message) {
        Assert.assertEquals(new HomePage().getSubscriptionSuccessMessage(), message);
    }

    @And("I click on arrow up button at bottom right corner")
    public void iClickOnArrowUpButtonAtBottomRightCorner() {
        new HomePage().clickOnBottomRightArrowButton();
    }

    @And("I should see the message {string}")
    public void iShouldSeeTheMessage(String expectedText) {
        Assert.assertEquals(new HomePage().getFullFledgedText(), expectedText);
    }

    @And("I scroll up to the top")
    public void iScrollUpToTheTop() {
        new HomePage().scrollUp();
    }
}
