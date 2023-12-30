package com.automationexercise.steps;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.pages.ProductPage;
import com.automationexercise.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.automationexercise.browserfactory.ManageBrowser.softAssertions;

public class ProductsSteps {

    @When("I Click on {string} button")
    public void iClickOnButton(String button) {
        new HomePage().clickOnProductsLink();

    }

    @Then("I Verify user is navigated to ALL PRODUCTS page successfully")
    public void iVerifyUserIsNavigatedToALLPRODUCTSPageSuccessfully() {
        String expectedText = "ALL PRODUCTS";
        String actualText = new ProductPage().getAllProductsText();

//        Assert.assertEquals(actualText,expectedText,"All Products not displayed");
    }

//    @And("The products list is visible")
//    public void theProductsListIsVisible() {
//        Assert.assertEquals(new ProductPage().getProductList(),"Products list not displayed");
//    }

    @And("The {string} list is visible")
    public void theListIsVisible(String products) {
        Assert.assertEquals(new ProductPage().getProductList(products), "Products list not displayed");
    }


    @And("I  Click on View Product of first product")
    public void iClickOnViewProductOfFirstProduct() {
        new ProductPage().clickOnViewProductOfFirstProduct();
    }

    @Then("I landed to product detail page")
    public void iLandedToProductDetailPage() {
        Assert.assertTrue(new ProductDetailsPage().verifyTheUrl().contains("https://automationexercise.com/product_details/1"));
    }

    @And("I verify that product name {string} is visible")
    public void iVerifyThatProductNameIsVisible(String pName) {
        softAssertions.assertEquals(new ProductDetailsPage().getProductName(), pName, "Product name not displayed");
    }

    @And("I verify that category {string} is visible")
    public void iVerifyThatCategoryIsVisible(String category) {
        softAssertions.assertEquals(new ProductDetailsPage().getProductCategory(), category, "Category not displayed");
    }

    @And("I verify that price {string} is visible")
    public void iVerifyThatPriceIsVisible(String price) {
        softAssertions.assertEquals(new ProductDetailsPage().getProductPrice(), price, "Price not displayed");
    }

    @And("I verify that availability {string} is visible")
    public void iVerifyThatAvailabilityIsVisible(String availability) {
        softAssertions.assertEquals(new ProductDetailsPage().getProductAvailability(), availability, "Availability not displayed");
    }

    @And("I verify that condition {string} is visible")
    public void iVerifyThatConditionIsVisible(String condition) {
        softAssertions.assertEquals(new ProductDetailsPage().getProductCondition(), condition, "Condition not displayed");
    }

    @And("I verify that brand {string} is visible")
    public void iVerifyThatBrandIsVisible(String brand) {
        softAssertions.assertEquals(new ProductDetailsPage().getProductBrand(), brand, "Brand not displayed");
    }

    @And("I enter product name {string} in search bar")
    public void iEnterProductNameInSearchBar(String pName) {
        new ProductPage().sendTextToSearchBar(pName);
    }

    @And("I click on search button")
    public void iClickOnSearchButton() {
        new ProductPage().clickOnSearchButton();
    }

    @Then("I verify {string} is visible on page")
    public void iVerifyIsVisibleOnPage(String text) {
        softAssertions.assertEquals(new ProductPage().getSearchedProductsText(), text, "Searched product not displayed");
    }

    @And("I should see the searched product {string}")
    public void iShouldSeeTheSearchedProduct(String pName) {
        softAssertions.assertEquals(new ProductPage().getSearchedProductName(), pName, "Searched Product not displayed");
    }

    @Then("I add product {string} to the cart")
    public void iAddProductToTheCart(String product) {
        new ProductPage().mouseHoverAndClickAddToCartOnProduct(product);
    }

    @And("I click on continue shopping link")
    public void iClickOnContinueShoppingLink() {
        new ProductPage().clickOnContinueShoppingLink();

    }

    @And("I click on view cart in popup")
    public void iClickOnViewCartInPopup() {
        new ProductPage().clickOnViewCartLink();
    }

    @Then("I verify the product {string} in shopping cart")
    public void iVerifyTheProductInShoppingCart(String pName) {
        softAssertions.assertEquals(new ShoppingCartPage().getProductNameFromCart(pName), pName);

    }

    @When("I click on view product of first product {string}")
    public void iClickOnViewProductOfFirstProduct(String pName) {
        new ProductPage().clickOnViewProduct();
    }

    @And("I am on product details page and verify the URL")
    public void iAmOnProductDetailsPageAndVerifyTheURL() {
        Assert.assertTrue(new ProductDetailsPage().verifyTheUrl().contains("https://automationexercise.com/product_details/1"));
    }

    @And("I increase the quantity {string}")
    public void iIncreaseTheQuantity(String quantity) {
        new ProductDetailsPage().sendQuantity(quantity);
    }

    @And("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        new ProductDetailsPage().clickOnAddToCartButton();
    }

    @And("I click on view cart link in success message")
    public void iClickOnViewCartLinkInSuccessMessage() {
        new ProductDetailsPage().clickOnViewCartLinkInSuccessMessage();

    }

    @Then("I should see quantity {string}")
    public void iShouldSeeQuantity(String quantity) {
        Assert.assertEquals(new ShoppingCartPage().getQuantity(), quantity);
    }

    @Then("I click on cross button to remove the product from the cart")
    public void iClickOnCrossButtonToRemoveTheProductFromTheCart() {
        new ShoppingCartPage().clickOnCrossButtonAcrossProductToRemove();
    }


    @And("I Verify that {string} message displayed")
    public void iVerifyThatMessageDisplayed(String expectedText) {
        softAssertions.assertEquals(new ShoppingCartPage().getEmptyCartText(), expectedText);
    }

    @Then("I click on {string} category")
    public void iClickOnCategory(String category) {
        new ProductPage().clickOnWomenCategory(category);
    }

    @And("I click on {string} in women category")
    public void iClickOnInWomenCategory(String subCategory) {
        new ProductPage().clickOnSubCategoryOfWomen(subCategory);
    }

    @And("I should see {string} page title")
    public void iShouldSeePageTitle(String expectedTitle) {
        softAssertions.assertEquals(new ProductPage().getSubMenuPageTitle(), expectedTitle);
    }

    @And("I click on {string} in men category")
    public void iClickOnInMenCategory(String subCategory) {
        new ProductPage().clickOnSubCategoryOfMen(subCategory);
    }

    @Then("I click on {string} brand in Brands tab")
    public void iClickOnBrandInBrandsTab(String brand) {
        new ProductPage().clickOnBrandOnBrandsTab(brand);
    }

    @And("I enter {string} name at your name field")
    public void iEnterNameAtYourNameField(String name) {
        new ProductDetailsPage().sendNameToYourNameField(name);
    }

    @And("I enter {string} email at email address field")
    public void iEnterEmailAtEmailAddressField(String email) {
        new ProductDetailsPage().sendEmailToEmailAddressField(email);
    }

    @And("I enter {string} message to review here field")
    public void iEnterMessageToReviewHereField(String review) {
        new ProductDetailsPage().sendReviewToAddReviewField(review);
    }

    @And("I click on review submit button")
    public void iClickOnReviewSubmitButton() {
        new ProductDetailsPage().clickOnReviewSubmitButton();
    }

    @Then("I should see {string} message")
    public void iShouldSeeMessage(String message) {
        Assert.assertEquals(new ProductDetailsPage().getThankYouForReviewMessage(), message);
    }

    @When("I scroll down up to recommended items text")
    public void iScrollDownUpToRecommendedItemsText() {
        new HomePage().scrollDownToRecommendedItems();
    }


    @Then("I should see {string} text at bottom")
    public void iShouldSeeTextAtBottom(String expectedText) {
        Assert.assertEquals(new HomePage().getRecommendedItemText(), expectedText);
    }

    @And("I add to cart {string} product from recommended items")
    public void iAddToCartProductFromRecommendedItems(String pName) {
        new HomePage().clickAddToCartOnRecommendedItems(pName);
    }
}
