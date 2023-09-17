Feature: Reqres Patch Update Feature test
  @Tugas
  Scenario Outline: Patch update user with valid json
    Given Patch update user with valid json "PatchUpdate.json" and user id 7
    When Send patch update user request
    Then Status code should be 200 OK
    And Response body patch name was "<name>" and job was "<job>"
    And Validate patch update user json schema "PatchUpdate.json"
    Examples:
      | name     | job           |
      | morpheus | zion resident |

  @Tugas
  Scenario: Patch update user with blank name and job
    Given Patch update user with empty name and job with id 2
    When Send patch update user request
    Then Status code should be 400 Bad Request