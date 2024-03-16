@Api
Feature: Delete a User via API

  Scenario: Delete a User via API with Response = 204
    Given Specifications are installed with expected response code 204
    When A user deletion request is sent to endpoint: DELETE_USER
    Then Response body is empty