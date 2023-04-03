Feature: File Upload functionality

  Scenario: User can upload a file successfully
    Given I am on the File Upload page
    When I select a file to upload
    And I click the Upload button
    Then I should see a success message
    And the uploaded file should be displayed on the page

  Scenario: User cannot upload a file that exceeds the maximum file size
    Given I am on the File Upload page
    When I select a file that exceeds the maximum file size
    And I click the Upload button
    Then I should see an error message

  Scenario: User can clear the file upload field and start again
    Given I am on the File Upload page
    When I select a file to upload
    And I click the Clear button
    Then the file upload field should be empty

  Scenario: User can navigate to the home page from the File Upload page
    Given I am on the File Upload page
    When I click the Home link in the navigation menu
    Then I should be taken to the home page
