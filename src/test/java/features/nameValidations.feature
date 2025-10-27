@Smoke
Feature: Validating Names in API's


@VerifyNames
  Scenario Outline:: Verify if Personal Name and alternate name
    Given User calls "<url>" with get request
    Then the API call is success with status code 200
    And "<Personal Name>" and "<Alternate Name>" exist in response body

  Examples:
    | url                                       | Personal Name     | Alternate Name                   |
    | https://openlibrary.org/authors/OL1A.json | Sachi Routray     | Yugashrashta Sachi Routray |
