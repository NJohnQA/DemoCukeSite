Feature: Logging in as a new user
  As a person
	I want to add a user
	So that I can login as that user

  Scenario: Adding a new user
    Given The correct web address
    When I navigate to the 'Add a User' page
    Then I can add a new user
    
  Scenario: Adding a new user
    Given The correct web address
    When I navigate to the 'Login' page
    Then I can login as a new user
