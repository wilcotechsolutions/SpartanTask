@ui
Feature: UI Tests (Extra)

  Agile Story: As the commander of the army, I should manage my soldiers, so that I can win.

  Background: Navigate to main page
    Given Commander navigates to the Spartan Crud Operation Page

  @AddSpartan
  Scenario Outline: Verify Add Spartan Functionality (Extra)
    When Commander clicks on the "Add Spartan" button on the "Spartan Crud Operation" page
    And Commander enters "<NAME>" to the "Name Input Box" on the "Add Spartan" page
    And Commander select "<GENDER>" from the "Gender" dropdown on the "Add Spartan" page
    And Commander enters "<PHONE>" to the "Phone Input Box" on the "Add Spartan" page
    And Commander clicks on the "Submit" button on the "Add Spartan" page
    Then Verify "SUCCESS MESSAGE" is "<SUCCESS MESSAGE>" on the "Add Spartan" page
    Examples:
      | NAME  | GENDER | PHONE      | SUCCESS MESSAGE              |
      | Tariq | Male   | 9876543210 | Successfully Added new Data! |