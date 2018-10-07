@ToRun
Feature: login

  Scenario: failed login when filling wrong credentials
    Given user on leverton login page
    When user fills random username
    And user fills random password
    And user submit login form
    Then redirection fails