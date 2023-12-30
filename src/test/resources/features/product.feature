@regression
Feature: Products page feature

  Background:
    Given I Navigate to url "http://automationexercise.com"
    Then I Verify that home page is visible successfully

  @author_Sandip_Patel @sanity @smoke
  Scenario: Verify All Products and product details page
    When I Click on "Products" button
    Then I Verify user is navigated to ALL PRODUCTS page successfully
    And I  Click on View Product of first product
    Then I landed to product detail page
    And I verify that product name "Blue Top" is visible
    And I verify that category "Category: Women > Tops" is visible
    And I verify that price "Rs. 500" is visible
    And I verify that availability "Availability: In Stock" is visible
    And I verify that condition "Condition: New" is visible
    And I verify that brand "Brand: Polo" is visible

  @author_Sandip_Patel @smoke
  Scenario: User should verify search product
    When I Click on "Products" button
    Then I Verify user is navigated to ALL PRODUCTS page successfully
    And I enter product name "Soft Stretch Jeans" in search bar
    And I click on search button
    Then I verify "SEARCHED PRODUCTS" is visible on page
    And I should see the searched product "Soft Stretch Jeans"


  @author_Sandip_Patel
  Scenario:  User should add products in cart
    When I Click on "Products" button
    Then I add product "Men Tshirt" to the cart
    And I click on continue shopping link
    And I add product "Blue Top" to the cart
    And I click on view cart in popup
    Then I verify the product "Blue Top" in shopping cart
    Then I verify the product "Men Tshirt" in shopping cart


  @author_Sandip_Patel
  Scenario: User should verify product quantity in cart
    When I click on view product of first product "Blue Top"
    And I am on product details page and verify the URL
    And I verify that product name "Blue Top" is visible
    And I verify that category "Category: Women > Tops" is visible
    And I verify that price "Rs. 500" is visible
    And I verify that availability "Availability: In Stock" is visible
    And I verify that condition "Condition: New" is visible
    And I verify that brand "Brand: Polo" is visible
    And I increase the quantity "4"
    And I click on add to cart button
    And I click on view cart link in success message
    Then I should see quantity "4"


  @author_Sandip_Patel
  Scenario: User should remove the product from cart
    When I add product "Blue Top" to the cart
    And I click on view cart in popup
    And I should see the welcome text on shopping cart page "Shopping Cart"
    Then I click on cross button to remove the product from the cart
    And I Verify that "Cart is empty!" message displayed


  @author_Sandip_Patel
  Scenario: User should view category products
    When I Click on "Products" button
    Then I click on "Women" category
    And I click on "Dress" in women category
    And I should see "WOMEN - DRESS PRODUCTS" page title
    Then I click on "Men" category
    And I click on "Tshirts" in men category
    And I should see "MEN - TSHIRTS PRODUCTS" page title


  @author_Sandip_Patel
  Scenario: UUser should view and cart brand products
    When I Click on "Products" button
    Then  I click on "Polo" brand in Brands tab
    And I should see "BRAND - POLO PRODUCTS" page title
    And I click on "Madame" brand in Brands tab
    And I should see "BRAND - MADAME PRODUCTS" page title


  @author_Sandip_Patel
  Scenario: User should view and cart brand products
    When I Click on "Products" button
    Then I Verify user is navigated to ALL PRODUCTS page successfully
    And I enter product name "Men Tshirt" in search bar
    And I click on search button
    Then I verify "SEARCHED PRODUCTS" is visible on page
    And I should see the searched product "Men Tshirt"
    And I add product "Men Tshirt" to the cart
    And I click on view cart in popup
    Then I verify the product "Men Tshirt" in shopping cart
    And I click on "Signup / Login" button
    Then I Verify "Login to your account" is visible
    And I enter correct email address "YSNvirat123@gmail.com", password "viru123"
    And I click on login button
    And I click on "Cart" button
    Then I verify the product "Men Tshirt" in shopping cart


  @author_Sandip_Patel
  Scenario: User should add review on product
    When I Click on "Products" button
    Then I Verify user is navigated to ALL PRODUCTS page successfully
    And I click on view product of first product "Blue Top"
    And I enter "Virat" name at your name field
    And I enter "virat123@gmail.com" email at email address field
    And I enter "Item as expected" message to review here field
    And I click on review submit button
    Then I should see "Thank you for your review." message

  @author_Sandip_Patel
  Scenario: User should add to cart from recommended items
    When I scroll down up to recommended items text
    Then I should see "RECOMMENDED ITEMS" text at bottom
    And I add to cart "Stylish Dress" product from recommended items
    And I click on view cart in popup
    Then I verify the product "Stylish Dress" in shopping cart















