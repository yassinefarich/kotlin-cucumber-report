Feature: Division operation

  Scenario: Test division
    Given The first operand is 100
    Given The second operand is 10
    When Divide the first by the second
    Then No exception has been thrown
    And Result equals to 10

  Scenario: Test division with denominator equals zero
    Given The first operand is 10
    Given The second operand is 0
    When Divide the first by the second
    Then An exception of type "java.lang.IllegalArgumentException" has been thrown