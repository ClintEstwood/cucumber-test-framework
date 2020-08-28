Feature: Latest date data

  @Feature=2.1
  Scenario: As a user I want to verify specific date foreign exchange rates
    Given I get foreign exchange rates with specific date "2020-08-10" via REST API and save it into variable "Exchange data from REST"
    Then Verify that exchange rates in variable "Exchange data from REST" has base "EUR"
    Then Verify that exchange rates in variable "Exchange data from REST" has date "10-08-2020"
    Then Verify that exchange rates in variable "Exchange data from REST" has listed records:
      | GBP    | 0.90155  |
      | IDR    | 17221.03 |
      | ILS    | 4.0124   |
      | DKK    | 7.4479   |
      | INR    | 88.1125  |
      | CHF    | 1.079    |
      | MXN    | 26.3047  |
      | CZK    | 26.183   |
      | SGD    | 1.6158   |
      | THB    | 36.63    |
      | HRK    | 7.4828   |
      | MYR    | 4.9352   |
      | NOK    | 10.629   |
      | CNY    | 8.2003   |
      | BGN    | 1.9558   |
      | PHP    | 57.787   |
      | SEK    | 10.2805  |
      | PLN    | 4.4021   |
      | ZAR    | 20.8452  |
      | CAD    | 1.5739   |
      | ISK    | 160.6    |
      | BRL    | 6.3697   |
      | RON    | 4.836    |
      | NZD    | 1.784    |
      | TRY    | 8.6055   |
      | JPY    | 124.74   |
      | RUB    | 86.6154  |
      | KRW    | 1396.28  |
      | USD    | 1.1763   |
      | HUF    | 345.19   |
      | AUD    | 1.6445   |
