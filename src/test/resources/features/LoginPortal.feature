Feature: WebDriver University - Login Portal Page


  Scenario: Validate Successful Submission with user credentials
    Given I access the webdriver university login portal page
    When I enter a first name of user name
    And I enter the user password
    And I click on the login button

Feature: Login Portal functionality

  Scenario: User can login with valid credentials
    Given I am on the Login Portal page
    When I enter valid username and password
    And I click the Login button
    Then I should see a success message
    And I should be redirected to the Dashboard page

  Scenario: User cannot login with invalid credentials
    Given I am on the Login Portal page
    When I enter invalid username and/or password
    And I click the Login button
    Then I should see an error message

  Scenario: User can reset password with valid email
    Given I am on the Login Portal page
    When I click the Forgot Password link
    And I enter a valid email address
    And I click the Reset Password button
    Then I should see a success message
    And I should receive an email with password reset instructions

  Scenario: User cannot reset password with invalid email
    Given I am on the Login Portal page
    When I click the Forgot Password link
    And I enter an invalid email address
    And I click the Reset Password button
    Then I should see an error message

  Scenario: User can navigate to the home page from the Login Portal page
    Given I am on the Login Portal page
    When I click the Home link in the navigation menu
    Then I should be taken to the home page
