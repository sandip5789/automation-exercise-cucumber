@regression
Feature: Contact us feature

  As a user I want to submit contact us form

  Background:
    Given I Navigate to url "http://automationexercise.com"
    Then I Verify that home page is visible successfully

  @author_Sandip_Patel @sanity @smoke
  Scenario: I can fill contact us form
    When I click on "Contact Us" button
    Then I Verify "GET IN TOUCH" is visible in contact us page
    And I  Enter name "Rohit Sharma", email "rohit279@gmail.com", subject "Where is my order" and message "I have not received my items yet"
    And I upload file
    And I Click "Submit" button
    And I Click "OK" button
    Then I Verify text "Success! Your details have been submitted successfully." is visible
    And I Click "Home" button
    Then I verify that landed to home page successfully.









