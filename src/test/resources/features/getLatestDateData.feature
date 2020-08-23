Feature: Test framework development

  @Feature=1.1
  Scenario: As a user I want to verify latest foreign exchange rates
    Given I get latest foreign exchange rates via REST API
    When I go to the "www.ecb.europa.eu" page
    And I click on "Statistic > ECB/Eurosystem policy and exchange rates" element on "European Central Bank Main" page
    And I click on "Euro foreign exchange reference rates" link on "ECB/Eurosystem policy and exchange rates" page
    Then I get latest foreign exchange rates from the ECB page