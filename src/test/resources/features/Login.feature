Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "andrei.butsko@testpro.io"
    And I enter password "SignZ1ex"
    And I submit
    Then I am logged in