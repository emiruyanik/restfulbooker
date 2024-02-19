Feature: Get All Booking Ids
  Scenario: Validate get all booking functionality

    Given The user is on the correct Base URI
    When The user sends a GET request to get all booking endpoint with "firstname" as "Josh" and "lastname" as "Allen"
    Then The status code should be as 200
    And The user should get only an id
    And The user's firstname and lastname which has getting id should match with specified "Josh" and "Allen"
