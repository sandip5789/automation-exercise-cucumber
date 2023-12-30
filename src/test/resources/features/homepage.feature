@regression
Feature: Home page feature

  Background:
    Given I Navigate to url "http://automationexercise.com"
    Then I Verify that home page is visible successfully

  @author_Sandip_Patel @sanity @smoke
  Scenario: Verify Test cases page
    When I click on "Test Cases" button
    Then I Verify user is navigated to "TEST CASES" page successfully

  @author_Sandip_Patel @smoke
  Scenario: User should Subscribe in the home page
    When I scroll down up to subscription link
    Then I should see "SUBSCRIPTION" text
    And I enter email "rohit123@gmail.com"
    And I click on arrow button
    And I should see the success subscription message "You have been successfully subscribed!"

  @author_Sandip_Patel
  Scenario: User should subscribe in the Cart page
    When I click on "Cart" button
    And  I scroll down up to subscription link
    Then I should see "SUBSCRIPTION" text
    And I enter email "rohit123@gmail.com"
    And I click on arrow button
    And I should see the success subscription message "You have been successfully subscribed!"

  @author_Sandip_Patel
  Scenario: User should scroll down and scroll up using Arrow button at bottom right corner
    And  I scroll down up to subscription link
    Then I should see "SUBSCRIPTION" text
    And I click on arrow up button at bottom right corner
    And I should see the message "Full-Fledged practice website for Automation Engineers"

  @author_Sandip_Patel
  Scenario: User should scroll down and scroll up using Arrow button at bottom right corner
    And  I scroll down up to subscription link
    Then I should see "SUBSCRIPTION" text
    And I scroll up to the top
    And I should see the message "Full-Fledged practice website for Automation Engineers"
