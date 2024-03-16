@Api
  Feature: Register User via API

    Scenario: Register User via API with response = 200
      Given Specifications are installed with expected response code 200
      When A new Registration with email 'eve.holt@reqres.in' and password 'pistol' is created
      And A registration request is send to endpoint: POST_NEW_REGISTRATION
      Then Response contains token: 'QpwL5tke4Pnpja7X4'