Feature: Login User Feature test
  @Tugas
  Scenario: Post login user with valid json
    Given Post login user with valid json
    When Send post user login
    Then Status code should be 200 OK
    And Response body should contain token "QpwL5tke4Pnpja7X4"
    And Validate post login user json schema

  @Tugas
  Scenario: Post login user with invalid password
    Given Post login user with valid json invalid password
    When Send post user login
    Then Status code should be 400 Bad Request

  @Tugas
  Scenario: Post login user with invalid username and password
    Given Post login with valid json invalid username and password
    When Send post user login
    Then Status code should be 400 Bad Request

  @Tugas
  Scenario: Post login unsuccessful user with valid json
    Given Post login unsuccessful user with valid json
    When Send post user login unsuccessful
    Then Status code should be 400 Bad Request
    And Response body should contain error "Missing password"
    And Validate post login unsuccessful json schema