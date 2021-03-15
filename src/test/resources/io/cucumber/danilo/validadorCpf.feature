@ignore
Feature: Validator CPF

  Scenario: The CPF validator
    Given I access the validator page
    When I fill the name
    And I fill de CPF "306.353.760-83"
    Then A have a valid CPF


  Scenario: The invalid CPF validator
    Given I access the validator page
    When I fill the name
    And I fill de CPF "306.353.760-86"
    Then A have a invalid CPF
