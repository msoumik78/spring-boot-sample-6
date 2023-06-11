Feature: Karate Tests


  Background:
    * url env.urls.BankApp
    * path '/api/1/bank-customers'
    * header Accept = 'application/json'



  Scenario: Get customer name1
    * def userId = 'name1'
    Given path userId

    When method GET
    Then status 200

    * assert response.age == 40
    * assert response.city == 'kolkata'
    * assert response.state == 'wb'
    * assert response.profession == 'developer'


  Scenario: Get customer name2
    * def userId = 'name2'
    Given path userId

    When method GET
    Then status 200

    * assert response.age == 42
    * assert response.city == 'mumbai'
    * assert response.state == 'maharashtra'
    * assert response.profession == 'developer'


  Scenario: Get customer which does not exist
    * def userId = 'name3'
    Given path userId

    When method GET
    Then status 500


