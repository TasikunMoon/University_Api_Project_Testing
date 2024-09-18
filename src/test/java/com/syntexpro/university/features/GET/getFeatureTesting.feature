Feature: University Registration Form

  Background:
    * url 'http://localhost:8086'
  Scenario: Find student information
#Testing Automation Steps + # Testing Validation = Automation Testing

    #Testing Automation Steps
    Given path 'api/v1/university/findAll'
    When method GET

    #Testing Validation
    Then status 200
    Then match responseType == 'json'
    Then print 'Response is', response