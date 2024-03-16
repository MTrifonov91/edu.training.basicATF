@ProductList
Feature: Products List test

  Background: Sauce demo Website is opened
    Given User is logged in

  Scenario: Login to sauce demo
    When Products page is displayed
    Then Product list contains the following items

      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
