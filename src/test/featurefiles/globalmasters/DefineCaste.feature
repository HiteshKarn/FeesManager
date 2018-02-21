Feature: Define Caste
  As a user I want to run test cases of this page
  So that I don't have to do it myself

  Background: Steps to open fee manager home page
    Given for url
    When user enter username and password
    And click sign in to open erp home page
    Then user click fee manager logo

  @save @scenario1
  Scenario: To test the validation messages when all fields are left blank
    When user open define caste page
    And click save on define caste page
    Then verify blank field on define caste page

  @save @scenario2
  Scenario: To test caste field with numeric value
    When user open define caste page
    And enter caste as "12345"
    And click save on define caste page
    Then verify numeric data on define caste page

  @save @scenario3
  Scenario: To test caste field with alphanumeric value
    When user open define caste page
    And enter caste as "abc123"
    And click save on define caste page
    Then verify alphanumeric data on define caste page

  @save @scenario4
  Scenario: To test caste field with less than 100 characters
    When user open define caste page
    And enter "99" characters in caste
    And click save on define caste page
    Then verify the saved value on define caste page

  @save @scenario5
  Scenario: To test caste field with 100 characters
    When user open define caste page
    And enter "100" characters in caste
    And click save on define caste page
    Then verify the saved value on define caste page

  @save @scenario6
  Scenario: To test caste field with more than 100 characters
    When user open define caste page
    And enter "101" characters in caste
    And click save on define caste page
    Then verify caste length on define caste page

  @save @scenario7
  Scenario: To test caste field with duplicate value
    When user open define caste page
    And enter caste as "general"
    And click save on define caste page
    Then verify duplicate value on define caste page

  @save @scenario8
  Scenario: To test caste field with valid data
    When user open define caste page
    And enter caste as "Brahmin"
    And click save on define caste page
    Then verify save message on define caste page

  @cancel @scenario9
  Scenario: To test the cancel button on define caste
    When user open define caste page
    And click cancel on define caste page
    Then verify cancel on define caste page

  @delete @scenario10
  Scenario: To test delete button when yes is clicked
    When user open define caste page
    And select record on define caste page
    And delete record on define caste page
    Then verify delete message on define caste page

  @modify @scenario11
  Scenario: To test modify button when yes is clicked
    When user open define caste page
    And select record on define caste page
    And modify record on define caste page
    Then verify modify message on define caste page