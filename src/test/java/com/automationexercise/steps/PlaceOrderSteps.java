package com.automationexercise.steps;

import com.automationexercise.pages.CheckoutPage;
import com.automationexercise.pages.PaymentPage;
import com.automationexercise.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class PlaceOrderSteps {
    @And("I should see the welcome text on shopping cart page {string}")
    public void iShouldSeeTheWelcomeTextOnShoppingCartPage(String expectedText) {
        Assert.assertEquals(new ShoppingCartPage().getShoppingCartWelcomeText(), expectedText);
    }

    @And("I click on Proceed to Checkout button")
    public void iClickOnProceedToCheckoutButton() {
        new ShoppingCartPage().clickOnProceedToCheckoutButton();
    }

    @And("I click on register link in the checkout popup")
    public void iClickOnRegisterLinkInTheCheckoutPopup() {
        new ShoppingCartPage().clickOnRegisterLoginLinkOnCheckoutPopup();
    }

    @Then("I should see the text on checkout page {string}")
    public void iShouldSeeTheTextOnCheckoutPage(String expectedText) {
        Assert.assertEquals(new CheckoutPage().verifyTextOnCheckoutPage(expectedText), expectedText);
    }

    @And("I enter details into comment area {string}")
    public void iEnterDetailsIntoCommentArea(String comment) {
        new CheckoutPage().sendTextToCommentArea(comment);
    }

    @And("I click on place order button")
    public void iClickOnPlaceOrderButton() {
        new CheckoutPage().clickOnPlaceOrder();
    }

    @Then("I enter payment details {string} {string} {string} {string} and {string}")
    public void iEnterPaymentDetailsAnd(String name, String cNumber, String CVC, String month, String year) {
        new PaymentPage().sendPaymentDetails(name, cNumber, CVC, month, year);
    }

    @And("I click on Pay and Confirm Order button")
    public void iClickOnPayAndConfirmOrderButton() {
        new PaymentPage().clickOnPayAndConfirmOrderButton();
    }

    @Then("I should see the order confirmation message {string}")
    public void iShouldSeeTheOrderConfirmationMessage(String expectedMessage) {
        Assert.assertEquals(new PaymentPage().getOrderConfirmationMessage(), expectedMessage);
    }

    @Then("I should see the delivery address is same address filled at the time registration of account {string}")
    public void iShouldSeeTheDeliveryAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount(String expectedAddress) {
        Assert.assertEquals(new CheckoutPage().getDeliveryAddress(), expectedAddress);
    }

    @And("I should see billing address is same address filled at the time registration of account {string}")
    public void iShouldSeeBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount(String expectedAddress) {
        Assert.assertEquals(new CheckoutPage().getBillingAddress(), expectedAddress);
    }

    @And("I click on download invoice after order success")
    public void iClickOnDownloadInvoiceAfterOrderSuccess() {
        new PaymentPage().clickOnDownloadInvoiceButtonAfterOrderSuccessMessage();
    }

    @And("I click on continue button after order success")
    public void iClickOnContinueButtonAfterOrderSuccess() {
        new PaymentPage().clickOnContinueButtonAfterOrderSuccessMessage();
    }
}
