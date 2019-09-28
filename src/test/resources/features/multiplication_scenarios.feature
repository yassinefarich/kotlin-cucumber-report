Feature: Multiplication operation

  Scenario: Test multiplication
    Given The first operand is 10
    Given The second operand is 20
    When Multiply the operands
    Then No exception has been thrown
    And Result equals to 200