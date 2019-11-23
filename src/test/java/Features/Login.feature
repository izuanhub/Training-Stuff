Feature: LoginFeature
  This login feature deals with login functionality of the application

  Scenario: Login as correct credentials (Happy path)
    Given I navigate to the login page of the application
    And I enter the following details for login
      | username | password      |
      | admin    | adminpassword |
    And I click on the login button
    Then I should see the userform page

  Scenario: Login as correct credentials (Unhappy path)
    Given I navigate to the login page of the application
    And I enter the following details for login
      | username | password      |
      | admin    | adminpassword |
    And I click on the login button
    Then I should see the userform page wrongly



#  Scenario Outline: Login as correct credentials using Scenario Outline
#    Given I navigate to the login page of the application
#    And I enter the <username> and <password>
#    And I click on the login button
#    Then I should see the userform page
#
#    Examples:
#      | username | password   |
#      | execute  | automation |
#      | testing  | qa         |
#      | halloo   | test       |