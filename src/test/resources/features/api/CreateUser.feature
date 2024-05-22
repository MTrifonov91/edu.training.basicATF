@Api @CreateUser
Feature: Create a User via API

  Scenario: Create a User via API with Response = 201
    Given Specifications are installed with expected response code 201
    When An Employee is created with the following data:
      | name | morpheus |
      | job  | leader   |
    And A user creation request is sent to endpoint: POST_NEW_USER
    Then Response contains createdAt timestamp within range of current time + 5 seconds