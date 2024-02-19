Feature: Update Booking
  Background:
    Given The user is on the correct Base URI
    When The user sends a POST request "admin" as username and "password123" as password to the create token endpoint
    And The user sends a POST request to the create booking endpoint with following details:
      | firstname       | merve      |
      | lastname        | genc       |
      | totalprice      | 500        |
      | depositpaid     | true       |
      | checkin         | 2023-01-01 |
      | checkout        | 2024-01-01 |
      | additionalneeds | Breakfast  |

  Scenario: Validate update booking functionality
    When The user sends a PUT request to the update endpoint with details and specific id
    Then The status code should be as 200
    And The information updated as expected