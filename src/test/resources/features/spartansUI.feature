@spartansUI
Feature: UI Tests

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

  @SearchAndClear
  Scenario Outline: Verify Search and Clear Functionality
    When Commander enters "<NAME>" to the "Name Search Text Box" on the "Spartan Crud Operation" page
    And Commander clicks on the "Search" button on the "Spartan Crud Operation" page
    Then Verify that the "Name" data on the table are "<NAME>" on the Spartan Crud Operation Page
    When Commander clicks on the "Clear" button on the "Spartan Crud Operation" page
    Then Verify that "Total Result" is equal to "Total"
    Examples:
      | NAME  |
      | Tariq |

  @View
  Scenario Outline: Verify View Functionality
    When Commander enters "<NAME>" to the "Name Search Text Box" on the "Spartan Crud Operation" page
    And Commander clicks on the "Search" button on the "Spartan Crud Operation" page
    When Commander clicks on the "View" button of Spartan named "<NAME>" after search
    Then Verify that the "Name" of the Spartan is "<NAME>" on the Spartan Details Page
    And Verify that the "Gender" of the Spartan is "<GENDER>" on the Spartan Details Page
    And Verify that the "Phone" of the Spartan is "<PHONE>" on the Spartan Details Page
    Examples:
      | NAME  | GENDER | PHONE      |
      | Tariq | Male   | 9876543210 |

  @Edit
  Scenario Outline: Verify Edit Functionality
    When Commander enters "<NAME>" to the "Name Search Text Box" on the "Spartan Crud Operation" page
    And Commander clicks on the "Search" button on the "Spartan Crud Operation" page
    And Commander clicks on the "Edit" button of Spartan named "<NAME>" after search
    And Commander enters "<NEW NAME>" to the "Name Input Box" on the "Spartan Edit" page
    And Commander enters "<NEW PHONE>" to the "Phone Input Box" on the "Spartan Edit" page
    And Commander clicks on the "Update" button on the "Spartan Edit" page
    Then Verify "SUCCESS MESSAGE" is "<SUCCESS MESSAGE>" on the "Spartan Edit" page
    When Commander clicks on the "Back to the List" button on the "Spartan Edit" page
    And Commander enters "<NEW NAME>" to the "Name Search Text Box" on the "Spartan Crud Operation" page
    And Commander clicks on the "Search" button on the "Spartan Crud Operation" page
    Then Verify that the "Name" data on the table are "<NEW NAME>" on the Spartan Crud Operation Page
    And Verify that the "Phone" data on the table are "<NEW PHONE>" on the Spartan Crud Operation Page
    Examples:
      | NAME  | NEW NAME  | NEW PHONE  | SUCCESS MESSAGE            |
      | Tariq | new Tariq | 1259516767 | Successfully Updated Data! |

  @Delete
  Scenario Outline: Verify Delete Functionality
    When Commander enters "<NAME>" to the "Name Search Text Box" on the "Spartan Crud Operation" page
    And Commander clicks on the "Search" button on the "Spartan Crud Operation" page
    And Commander checks the "Total" before deletion
    When Commander clicks on the "Delete" button of Spartan named "<NAME>" after search
    Then Verify that "Total" decreased by 1
    Examples:
      | NAME      |
      | new Tariq |