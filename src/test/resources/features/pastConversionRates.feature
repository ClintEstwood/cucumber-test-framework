Feature: Latest date data

  @Feature=2.1
  Scenario: As a user I want to verify specific date foreign exchange rates
    Given I get foreign exchange rates with specific date "2020-08-10" via REST API and save it into variable "Exchange data from REST"
    Then Verify that exchange rates in variable "Exchange data from REST" has base "EUR"
    Then Verify that exchange rates in variable "Exchange data from REST" has date "10-08-2020"
    Then Verify that exchange rates in variable "Exchange data from REST" has listed records:
      | GBP | 0.90155  |
      | IDR | 17221.03 |
      | ILS | 4.0124   |
      | DKK | 7.4479   |
      | INR | 88.1125  |
      | CHF | 1.079    |
      | MXN | 26.3047  |
      | CZK | 26.183   |
      | SGD | 1.6158   |
      | THB | 36.63    |
      | HRK | 7.4828   |
      | MYR | 4.9352   |
      | NOK | 10.629   |
      | CNY | 8.2003   |
      | BGN | 1.9558   |
      | PHP | 57.787   |
      | SEK | 10.2805  |
      | PLN | 4.4021   |
      | ZAR | 20.8452  |
      | CAD | 1.5739   |
      | ISK | 160.6    |
      | BRL | 6.3697   |
      | RON | 4.836    |
      | NZD | 1.784    |
      | TRY | 8.6055   |
      | JPY | 124.74   |
      | RUB | 86.6154  |
      | KRW | 1396.28  |
      | USD | 1.1763   |
      | HUF | 345.19   |
      | AUD | 1.6445   |

  @Feature=2.2
  Scenario: As a user I want to verify specific date and symbols foreign exchange rates
    Given I get foreign exchange rates with specific date "2020-08-10" and symbols "USD,GBP" via REST API and save it into variable "Exchange data from REST"
    Then Verify that exchange rates in variable "Exchange data from REST" has base "EUR"
    Then Verify that exchange rates in variable "Exchange data from REST" has date "10-08-2020"
    Then Verify that exchange rates in variable "Exchange data from REST" has listed records:
      | USD | 1.1763  |
      | GBP | 0.90155 |

  @Feature=2.3
  @Defect
  Scenario: As a user I want to verify specific date foreign exchange rates with base
    Given I get foreign exchange rates with specific date "2020-08-10" and base "USD" via REST API and save it into variable "Exchange data from REST"
    Then Verify that exchange rates in variable "Exchange data from REST" has base "USD"
    Then Verify that exchange rates in variable "Exchange data from REST" has date "10-08-2020"
    Then Verify that exchange rates in variable "Exchange data from REST" has listed records:
      | GBP | 0.7664286322     |
      | HKD | 7.7502337839     |
      | IDR | 14639.9982997535 |
      | ILS | 3.4110346        |
      | DKK | 6.3316330868     |
      | INR | 74.9064864405    |
      | CHF | 0.917283006      |
      | MXN | 22.3622375244    |
      | CZK | 22.2587775227    |
      | SGD | 1.3736291762     |
      | THB | 31.1400153022    |
      | HRK | 6.3613023888     |
      | EUR | 0.8501232679     |
      | MYR | 4.1955283516     |
      | NOK | 9.0359602142     |
      | CNY | 6.9712658335     |
      | BGN | 1.6626710873     |
      | PHP | 49.1260732806    |
      | SEK | 8.7396922554     |
      | PLN | 3.7423276375     |
      | ZAR | 17.7209895435    |
      | CAD | 1.3380090113     |
      | ISK | 136.5297968205   |
      | BRL | 5.4150301794     |
      | RON | 4.1111961234     |
      | NZD | 1.5166199099     |
      | TRY | 7.3157357817     |
      | JPY | 106.0443764346   |
      | RUB | 73.6337668962    |
      | KRW | 1187.0101164669  |
      | HUF | 293.4540508374   |
      | AUD | 1.398027714      |