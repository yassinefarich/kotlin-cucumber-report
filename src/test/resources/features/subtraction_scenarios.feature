Feature: Subtraction operation

  Scenario: Test subtraction
    Given The first operand is 10
    Given The second operand is 20
    When Subtract second operand from the first
    Then No exception has been thrown
    And Result equals to -10