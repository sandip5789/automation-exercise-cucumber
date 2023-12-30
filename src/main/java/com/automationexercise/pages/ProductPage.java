package com.automationexercise.pages;

import com.automationexercise.Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ProductPage extends Utility {
    private static final Logger log = LogManager.getLogger(AccountRelatedPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    WebElement allProductsText;

    @CacheLookup
    @FindBy(tagName = "productinfo text-center")
    // //div[@class='productinfo text-center'] xpath
    List<WebElement> allProductList;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'nav nav-pills nav-justified']/li/a")
    WebElement viewProductFirst;

    @CacheLookup
    @FindBy(css = "a[href='/product_details/1']")
    WebElement viewFirstProduct;

    @CacheLookup
    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchBar;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Searched Products']")
    WebElement searchedProductsText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'single-products']/div/p")
    WebElement searchedProductName;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-image-wrapper']/div/div/p")
    List<WebElement> productList;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-default add-to-cart']")
    WebElement addToProductButton;

    @CacheLookup
    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    WebElement viewCartLink;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    WebElement continueShoppingLink;

    @CacheLookup
    @FindBy(xpath = "((//a[@class='btn btn-default add-to-cart'])[1]")
    WebElement firstProduct;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'productinfo text-center']/p")
    List<WebElement> productName;

    @CacheLookup
    @FindBy(css = "a[href='/product_details/1']")
    WebElement blueTopProduct;

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Women']")
    WebElement womenTabInCategory;

    @CacheLookup
    @FindBy (xpath = "//div[@id = 'Women']/div/ul/li/a")
    List<WebElement> womenSubMenuList;

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Men']")
    WebElement menTabInCategory;

    @CacheLookup
    @FindBy (xpath = "//div[@id = 'Men']/div/ul/li/a")
    List<WebElement> menSubMenuList;

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Kids']")
    WebElement kidsTabInCategory;

    @CacheLookup
    @FindBy (xpath = "//h2[@class = 'title text-center']")
    WebElement subMenuPageTitle;

    @CacheLookup
    @FindBy (xpath = "//ul[@class = 'nav nav-pills nav-stacked']/li/a")
    List<WebElement> brandsList;


    public String getAllProductsText() {
        log.info("Getting All Products Text: " + allProductsText.toString());
        return getTextFromElement(allProductsText);
    }

    public String getProductList(String products) {
        List<WebElement> product = new ArrayList<>();
        for (WebElement e : allProductList) {
            if (e.getText().equals(products)) {
                break;
            }
        }
        return products;
    }

    public void clickOnViewProductOfFirstProduct() {
        WebElement element = viewFirstProduct;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        log.info("Clicking on first product: " + viewFirstProduct.toString());
    }

    public void sendTextToSearchBar(String pName) {
        sendTextToElement(searchBar, pName);
        log.info("Sending " + pName + " to search bar : " + searchBar.toString());
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
        log.info("Clicking on the search button : " + searchButton.toString());
    }

    public String getSearchedProductsText() {
        log.info("Getting Searched Products text : " + searchedProductsText.toString());
        return getTextFromElement(searchedProductsText);
    }

    public String getSearchedProductName() {
        log.info("Getting Searched Product name : " + searchedProductName.toString());
        return getTextFromElement(searchedProductName);
    }

    public void mouseHoverAndClickAddToCartOnProduct(String pName) {
        for (WebElement pr : productList) {
            if (pr.getText().equalsIgnoreCase(pName)) {
                mouseHoverToElement(pr);
                log.info("Hovering mouse over " + pName + " : " + productList.toString());
                try {
                    addToProductButton.click();
                } catch (Exception e) {
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@class='btn btn-default add-to-cart']")));
                }
                log.info("Click on " + pName + " Add to Cart button : " + productList.toString());
                break;
            }
        }
    }

    public void clickOnViewCartLink() {
        clickOnElement(viewCartLink);
        log.info("Clicking on view cart link after adding product to the cart : " + viewCartLink.toString());
    }

    public void clickOnContinueShoppingLink() {
        clickOnElement(continueShoppingLink);
        log.info("Clicking on continuer shopping link : " + continueShoppingLink.toString());
    }

    public void mouseHoverAndClickOnFirstProduct() {
        mouseHoverToElementAndClick(firstProduct);
        log.info("Clicking on product : " + firstProduct.toString());
    }

    public void clickOnViewProductWithProductName(String pName) {
        for (WebElement p : productName) {
            if (p.getText().equalsIgnoreCase(pName)) {
                driver.findElement(with(By.xpath("//ul[@class = 'nav nav-pills nav-justified']/li/a")).below(p)).click();
                log.info("Clicking on view product tab of " + pName);
                break;
            }
        }
    }

    public void clickOnViewProduct() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", blueTopProduct);
        log.info("Clicking on blue top product: " + blueTopProduct.toString());
    }

    public void clickOnCategory(String category) {
        if (category.equalsIgnoreCase("Men")) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", menTabInCategory);
//            clickOnElement(menTabInCategory);
            log.info("Clicking on Men category : " + menTabInCategory.toString());
        } else if (category.equalsIgnoreCase("Women")) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", womenTabInCategory);
//            clickOnElement(womenTabInCategory);
            log.info("Clicking on Women category : " + womenTabInCategory.toString());
        } else if (category.equalsIgnoreCase("Child")) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", kidsTabInCategory);
//           clickOnElement(kidsTabInCategory);
            log.info("Clicking on Kids category : " + kidsTabInCategory.toString());
        } else {
            System.out.println("Category is not available");
        }
    }

    public void clickOnSubCategoryOfWomen(String womenSubCategory) {
        for (WebElement s : womenSubMenuList) {
            if (s.getText().equalsIgnoreCase(womenSubCategory)) {
                clickOnElement(s);
                log.info("Clicking on " + womenSubCategory + " of women sub category : " + womenSubMenuList.toString());
                break;
            } else {
                System.out.println("Sub category is not available");
            }
        }
    }
    public void clickOnSubCategoryOfMen(String menSubCategory) {
        for (WebElement s : menSubMenuList) {
            if(s.getText().equalsIgnoreCase(menSubCategory)){
                clickOnElement(s);
                log.info("Clicking on " + menSubCategory + " of men sub category : " + menSubMenuList.toString());
                break;
            }else {
                System.out.println("Sub category is not available");
            }
        }
    }
    public String getSubMenuPageTitle() {
        log.info("Getting Sub Menu Page Title : " + subMenuPageTitle.toString());
        return getTextFromElement(subMenuPageTitle);
    }

    public void clickOnBrandOnBrandsTab(String brand){
        for (WebElement b : brandsList) {
            System.out.println(b);
            if (b.getText().equalsIgnoreCase(brand)){
                b.click();
                log.info("Clicking on " + brand + " in Brands tab : " + brandsList.toString());
                break;
            } else {
                System.out.println("Brand name is not available");
            }
        }
    }
    public void clickOnWomenCategory(String category){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", womenTabInCategory);
//        clickOnElement(womenTabInCategory);
    }

}