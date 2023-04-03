Feature: Contact Us page functionality


  Scenario: Validate Successful Submission
    Given I access the web driver university contact us page
    When I enter a first name
    And I enter a last name
    And I enter an email address
    And I enter a comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission message


  Scenario: User can submit a valid contact form
    Given I am on the Contact Us page
    When I enter valid information into all required fields
    And I click the Submit button
    Then I should see a success message
    And I should receive an email confirming my message was sent

  Scenario: User cannot submit a contact form with missing required fields
    Given I am on the Contact Us page
    When I leave one or more required fields blank
    And I click the Submit button
    Then I should see an error message for the missing field(s)

  Scenario: User cannot submit a contact form with invalid email
    Given I am on the Contact Us page
    When I enter an invalid email address
    And I enter valid information into all other required fields
    And I click the Submit button
    Then I should see an error message for the invalid email address

  Scenario: User can clear the contact form and start again
    Given I am on the Contact Us page
    When I enter valid information into all required fields
    And I click the Clear button
    Then all fields should be empty

  Scenario: User can navigate to the home page from the Contact Us page
    Given I am on the Contact Us page
    When I click the Home link in the navigation menu
    Then I should be taken to the home page