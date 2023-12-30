package com.automationexercise.pages;

import com.automationexercise.Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends Utility {
    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//td[@class = 'cart_description']/h4/a")
    List<WebElement> cartProductList;

    @CacheLookup
    @FindBy (xpath = "//td[@class = 'cart_quantity']/button")
    WebElement quantity;

    @CacheLookup
    @FindBy (xpath = "//li[@class='active']")
    WebElement shoppingCartWelcomeText;

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Proceed To Checkout']")
    WebElement proceedToCheckoutButton;

    @CacheLookup
    @FindBy (xpath = "//u[normalize-space()='Register / Login']")
    WebElement registerLoginLinkOnCheckoutPopup;

    @CacheLookup
    @FindBy (xpath = "//i[@class='fa fa-times']")
    WebElement crossButtonAcrossProductToRemove;

    @CacheLookup
    @FindBy (xpath = "//b[normalize-space()='Cart is empty!']")
    WebElement emptyCartText;

    public String getProductNameFromCart(String pName) {
        for (WebElement p : cartProductList) {
            if(p.getText().equalsIgnoreCase(pName)) {
                log.info("Getting " + pName + " from shopping cart : " + cartProductList.toString());
                return pName;
            }
        }
        return "Product Not Found";
    }
    public String getQuantity() {
        log.info("Getting quantity from shopping cart page : " +quantity.toString());
        return getTextFromElement(quantity);
    }
    public String getShoppingCartWelcomeText() {
        log.info("Getting welcome text from shopping cart page : " + shoppingCartWelcomeText.toString());
        return getTextFromElement(shoppingCartWelcomeText);
    }
    public void clickOnProceedToCheckoutButton() {
        clickOnElement(proceedToCheckoutButton);
        log.info("Clicking on proceed to checkout button : " + proceedToCheckoutButton.toString());
    }
    public void clickOnRegisterLoginLinkOnCheckoutPopup() {
        clickOnElement(registerLoginLinkOnCheckoutPopup);
    }
    public void clickOnCrossButtonAcrossProductToRemove() {
        clickOnElement(crossButtonAcrossProductToRemove);
        log.info("Clicking on cross button to remove the product from cart : " + crossButtonAcrossProductToRemove.toString());
    }
    public String getEmptyCartText() {
        log.info("Getting empty cart text : " + emptyCartText.toString());
        return getTextFromElement(emptyCartText);
    }
}
