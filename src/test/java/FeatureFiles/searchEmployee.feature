Feature: Search Employee Functionality

  Scenario Outline: TC-3 Admin searches for a employee
    Given Admin is logged in
    When Admin navigates to Add Employee page
    And Admin enters employee name "<employeeName>" and ID "<employeeId>"
    And Admin clicks on the Search button
    Then Admin should see the employee details in the search results
    Examples:
     | employeeName | employeeId |
     | bala kumar   | 0303       |
