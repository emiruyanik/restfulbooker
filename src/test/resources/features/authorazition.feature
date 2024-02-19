Feature: Creating access token

  Scenario:Test auth create token method functionality
    Given The user is on the correct Base URI
    When The user sends a POST request "admin" as username and "password123" as password to the create token endpoint
    Then The status code should be as 200
    And The access token should not be empty or null

