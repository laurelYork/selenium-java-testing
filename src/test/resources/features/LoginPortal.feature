Feature: WebDriver University - Login Portal Page


  Scenario: Validate Successful Submission with user credentials
    Given I access the webdriver university login portal page
    When I enter a first name of user name
    And I enter the user password
    And I click on the login button