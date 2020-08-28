Feature: Latest date data

  @Feature=1.1
  Scenario: As a user I want to verify latest foreign exchange rates
    Given I get latest foreign exchange rates via REST API and save it into variable "Exchange data from REST"
    When I go to the "https://www.ecb.europa.eu" page
    And I click on "Statistics" dropdown on European Central Bank Main page
    And I click on "ECB/Eurosystem policy and exchange rates" link on dropdown menu
    And I click on link "Euro foreign exchange reference rates"
    And I get latest foreign exchange rates from the ECB page and save it into variable "Exchange data from UI"
    Then Verify that variables "Exchange data from REST" and "Exchange data from UI" are the same

  @Feature=1.2
  Scenario: As a user I want to verify latest foreign exchange rates with symbols
    Given I get latest foreign exchange rates with symbols "USD,GBP,PLN" via REST API and save it into variable "Exchange data from REST"
    When I go to the Euro foreign exchange reference rates page
    And I get latest foreign rates for exchanges "USD,GBP,PLN" from the ECB page and save it into variable "Exchange data from UI"
    Then Verify that variables "Exchange data from REST" and "Exchange data from UI" are the same

  @Feature=1.3
  Scenario: As a user As a user I want to verify latest foreign exchang rates with base
    Given I get latest foreign exchange rates with base "USD" via REST API and save it into variable "Exchange data from REST"
    Then Verify that exchange rates in variable "Exchange data from REST" has base "USD"

  @Feature=1.4
  Scenario: As a user I want to verify latest foreign exchange rates with symbols and base
    Given I get latest foreign exchange rates with symbols "USD,GBP,PLN" and base "USD" via REST API and save it into variable "Exchange data from REST"
    Then Verify that exchange rates in variable "Exchange data from REST" has base "USD"
    Then Verify that exchange rates in variable "Exchange data from REST" has symbols "USD,GBP,PLN"

