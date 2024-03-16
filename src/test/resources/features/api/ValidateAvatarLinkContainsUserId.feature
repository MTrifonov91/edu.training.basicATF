@Api
Feature: Validate User's Avatar link to contain ID via API

  Scenario: Validate User's Avatar link to contain ID via API with Response = 200
    Given Specifications are installed with expected response code 200
    When A GET request is sent to endpoint: GET_USER
    Then Response user's Avatar link contains user's id

  Scenario: Validate all Users Avatar links to contain IDs via API with Response = 200
    Given Specifications are installed with expected response code 200
    When A GET request is sent to endpoint: GET_USERS_LIST
    Then Response users list Avatar links contains users ids