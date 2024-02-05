@ui
Feature: UI Tests (Extra)

  Agile Story: As the commander of the army, I should manage my soldiers, so that I can win.

  Background: Navigate to main page
    Given Commander clicks on the "Web Data" button on the "Spartan Home" page

  @AddSpartan
  Scenario Outline: Verify Add Spartan Functionality
    When Commander clicks on the "Add Spartan" button on the "Spartan Crud Operation" page
    And Commander enters "<NAME>" to the "Name Input Box" on the "Spartan Add" page
    And Commander select "<GENDER>" from the "Gender" dropdown on the "Spartan Add" page
    And Commander enters "<PHONE>" to the "Phone Input Box" on the "Spartan Add" page
    And Commander clicks on the "Submit" button on the "Spartan Add" page
    Then Verify "SUCCESS MESSAGE" is "<SUCCESS MESSAGE>" on the "Spartan Add" page
    Examples:
      | NAME  | GENDER | PHONE      | SUCCESS MESSAGE              |
      | Tariq | Male   | 9876543210 | Successfully Added new Data! |