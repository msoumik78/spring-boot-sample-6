Feature: Karate Tests


  Background:
    * url http://localhost:8085
    * path '/api/1/bank-customers'
    * header Accept = 'application/json'



  Scenario: Get customer
    * def userId = 'name1'
    Given path userId

    When method GET
    Then status 200

    * assert response.age == 40