Feature: Sum operation

  Scenario: Test sum operation
    Given The first operand is 10
    Given The second operand is 20
    When Add the first operand to the second
    Then No exception has been thrown
    And Result equals to 30