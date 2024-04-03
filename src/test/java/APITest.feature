@Testing
Feature: API Testing

    @apiTest2
    Scenario: Create user
      Given user create user
      And user get userid
      And user update username