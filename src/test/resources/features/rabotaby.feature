Feature: rabotaby tests

  Scenario: search QA Automation vacancies
    Given I open rabota.by
    When I enter vacancy "Qa automation"
    And I click search button
    Then I check header match
    And I check if results quantity is greater than 5
    And I check if results quantity equals actual quantity
