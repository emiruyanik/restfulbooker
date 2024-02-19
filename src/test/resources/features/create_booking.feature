Feature: Create Booking

  Scenario:Validate create booking functionality
    Given The user is on the correct Base URI
    When The user sends a POST request to the create booking endpoint with following details:
      | firstname       | merve      |
      | lastname        | genc       |
      | totalprice      | 500        |
      | depositpaid     | true       |
      | checkin         | 2023-01-01 |
      | checkout        | 2024-01-01 |
      | additionalneeds | Breakfast  |
    Then The status code should be as 200
    And The booking id should not be empty or null
    And The booking object in response should match with given datas



