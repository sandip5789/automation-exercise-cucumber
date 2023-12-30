@regression
Feature: Register User Feature
  As a user I can register account

  Background:
    Given I Navigate to url "http://automationexercise.com"
    Then I Verify that home page is visible successfully

  @author_Sandip_Patel @sanity @smoke
  Scenario: Verify that user can register new account and delete account
    When I click on "Signup / Login" button
    Then I  Verify "New User Signup!" is visible
    And I  Enter name "Virat Kohli"
    And I Enter email address "virat123@gmail.com"
    And I click on Signup button
    Then I verify that "ENTER ACCOUNT INFORMATION" is visible
    And I Fill details Title, Name, Email, Password "viru123" , Date Of Birth "12","November","1989"
    And I Select checkbox Sign up for our newsletter!
    And I Select checkbox Receive special offers from our partners!
    And I fill details with firstName "Virat" lastName "Kohli" company "MRF" address "10 Regent Street" addressTwo "Taj Mahal road" country "India" state "Delhi" city "New Delhi" zipcode "380015" mobileNumber "919898023568"
    And I Click on Create Account button
    Then I Verify that "ACCOUNT CREATED!" is displayed
    And I Click Continue button
    Then I  Verify that "Logged in as" username is visible
    And I click Delete Account button
    Then I  Verify that "ACCOUNT DELETED!" is visible after deleted
    And I Click Continue button








