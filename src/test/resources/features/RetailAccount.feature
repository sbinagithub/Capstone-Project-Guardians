@Smoke
Feature: Retail Account Page

  Background: 
    Given User is on retail website homepage
    When User click on the login link
    And User enter email 'Guardiansbdd10000@gmail.com' and password 'Student@12345675'
    And User click on login button
    Then User should be logged in into Account
    When User click on Account option

  @updatePI
  Scenario: Verify User can update Profile Information
    And User update Name 'name' and Phone '5713452311'
    And User click on Update button
    Then user profile information should be updated

  @addPaymentMethod
  Scenario: Verify User can add a payment method
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 4343222233335544 | Guardians  |              12 |           2024 |          561 |
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added sucessfully'

  @editDibitOrCredit
  Scenario: Verify User can edit Debit or Credit card
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1231233453455670 | Taban      |              10 |           2026 |          333 |
    And user click on Update Your Card button
    Then a message should be displayed 'Payment Method updated Successfully'

  @removeDibitOrCredit
  Scenario: Verify User can remove Debit or Credit card
    And User click on remove option of card section
    Then payment details should be removed

  @addAddress
  Scenario: Verify User can add an Address
    And User click on Add address option
    And user fill new address form with below information
      | country      | fullName      | phoneNumber | streetAddress | apt      | city      | state      | zipCode      |
      | countryValue | fullnameValue | PhoneValue  | stAddress       | aptValue | cityValue | stateValue | zipCodeValue |
    And User click Add Your Address button

@EditAddress
Scenario: Verify User can edit an Address added on account
    And User click on edit address option
    And user update new address form with below information
    |country|fullName|phoneNumber|streetAddress|apt       |city     | state |zipCode   |
    |countryValue|fullnameValue|PhoneValue|stAddress|aptValue|cityValue|stateValue|zipCodeValue|
    And User click update Your Address button
    Then a message should be displayed 'Address updated Successfully'
 
  @removeAddress
  Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed