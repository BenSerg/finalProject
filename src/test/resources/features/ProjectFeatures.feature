@group
Feature: Group tests

  Background:
    Given user is on home page with at least one group
    When user clicks on group button

  Scenario: Enter first group
    And user sees first group
    And clicks on enter button
    Then group entrance success should be seen

  Scenario: Check moderate chapter
    And user enter moderate chapter with no moderate group
    Then non-exist message should be visible


  Scenario: Create new group
    And user clicks on create group button
    And chooses public page
    And insert expected_name in name_field
    And insert expected_theme in theme_field
    And clicks on create button
    Then new group name should be equal to expected_name and theme should be equal to expected_theme