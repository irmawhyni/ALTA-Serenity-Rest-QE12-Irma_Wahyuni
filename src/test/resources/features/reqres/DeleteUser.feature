Feature: Delete User
  @Tugas
  Scenario Outline: Delete user with invalid parameter should failed and return 400 response code
    Given Delete user with invalid id "<id>"
    When Send request delete user
    Then Status code should be 400 Bad Request
    Examples:
      | id   |
      | Irma |
      | ?&*@ |