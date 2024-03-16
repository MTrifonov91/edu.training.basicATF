Feature: Login test

  Background: Sauce demo Website is opened

  Scenario: Login to sauce demo
    Given Login page is displayed
    When User Logs in with credentials for standard user
    Then Products page is displayed