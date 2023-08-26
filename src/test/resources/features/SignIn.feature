@Smoke
Feature: Sign in

  Background: 
    Given User is on retail website homepage
    When User click on the login link

  @login
  Scenario: Verify user can sign in into Retail Application
    And User enter email 'Guardiansbdd10000@gmail.com' and password 'Student@12345675'
    And User click on login button
    Then User should be logged in into Account

  @createnewAccount
  Scenario: Verify user can create an account into Retail Website
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name | email                      | password | confirmPassword |
      | Bina | Guardiansbdd10000200@gmail.com | Student@123456750 | Student@123456750        |
    And User click on SignUp button
    Then User should be logged into account page