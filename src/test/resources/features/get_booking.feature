Feature: Get Booking

  Scenario:Validate get booking functionality with specific id

    Given The user is on the correct Base URI
    When The user send a GET request to the get booking endpoint with id as 45
    Then The status code should be as 200
