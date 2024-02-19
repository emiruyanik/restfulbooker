Feature: Delete Booking

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

  Scenario: Validate delete booking functionality with authorization
    When The user sends a DELETE request to the delete booking endpoint with valid authorization and id
    Then The status code should be as 201
    And Validate that specified user is deleted