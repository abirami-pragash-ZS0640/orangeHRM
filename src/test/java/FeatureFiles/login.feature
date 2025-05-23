Feature:Login function for Orange HRM Application

  Scenario Outline:TC-1 Valid login for Orange HRM
    Given User is on the login page
    And user enters "<username>" and "<password>"
    Then user should be successfully logged in

    Examples:

     | username | password   |
     | Admin    | admin123   |


  Scenario Outline:TC-2 Invalid login for Orange HRM
    Given User is on the login page
    When user enters "<username>" and "<password>"
    Then error message "<errorMsg>" should be displayed


    Examples:
      | username | password   | errorMsg              |
      | invalid  | invalid123 | Invalid credentials   |





