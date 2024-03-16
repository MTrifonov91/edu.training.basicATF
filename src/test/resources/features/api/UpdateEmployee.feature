@Api
Feature: Validate update employee via API

  Scenario: Validate update employee's updated at time via API with Response = 200
    Given Specifications are installed with expected response code 200
    When An Employee is created with the following data:
      | name | morpheus      |
      | job  | zion resident |
    And A user update request is sent to endpoint: UPDATE_USER
    Then Response contains updatedAt timestamp equal to current time