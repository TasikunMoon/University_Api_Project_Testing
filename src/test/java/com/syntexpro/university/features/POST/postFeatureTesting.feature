Feature: University Registration Form

  Background:
    * url 'http://localhost:8086'

  Scenario Outline: Find student information
#Testing Automation Steps + # Testing Validation = Automation Testing

    #Testing Automation Steps
    Given path 'api/v1/university/newRegistration'
    When request {"firstName": "<firstName>","lastName": "<lastName>","email": "<email>","age": <age>}

    When method POST

    #Testing Validation
    Then status 200
    Examples:
      | firstName | lastName | email          | age |
      | Tasikun   | Moon     | 8798@gmail.com  | 32 |
      | Tasikun   | Moon     | 920@gmail.com  | 32  |
      | Tasikun   | Moon     | 369@gmail.com  | 32  |
      | Tasikun   | Moon     | 422@gmail.com  | 32  |
      | Tasikun   | Moon     | 579c@gmail.com | 32  |
      | Tasikun   | Moon     | 091@gmail.com | 25  |


