@e2e @UI
Feature: E2E (Add to card, Checkout, Set delivery address)

  Background: Sauce demo Website is opened
    Given User is logged in
    And Products page is displayed

  Scenario: Submit a 1 Backpack order
    When User adds 'Sauce Labs Backpack' to cart
    Then Your Cart has '1' label displayed
    When User clicks on Cart
    Then Your Cart page is displayed
    When User clicks on Checkout button
    Then Checkout page is displayed
    When User enters the following data
      | First Name      | John    |
      | Last Name       | Doe     |
      | Zip/Postal Code | MD-2072 |

    And User clicks on Continue button
    Then Checkout overview page is displayed
    When User clicks on Finish button
    Then Checkout Complete page is displayed
    When User clicks on Back Home button
    Then Products page is displayed
    And Your Cart is empty