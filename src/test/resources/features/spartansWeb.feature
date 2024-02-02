Feature: Manage Spartans Army

  Agile Story: As the commander of the army, I should manage my soldiers, so that I can win.

  Background: Navigate to main page
    Given Commander navigates to the Spartan Crud Operation Page

  Scenario Outline: Verify Search and Clear Functionality
    When Commander enters "<name>" to the "Name Search Text Box" on the Spartan Crud Operation Page
    And Commander clicks on the "Search" button on the Spartan Crud Operation Page
    Then Verify that the "Name" data on the table are "<name>" on the Spartan Crud Operation Page
    When Commander clicks on the "Clear" button on the Spartan Crud Operation Page
    Then Verify that "Total Result" is equal to "Total"
    Examples:
      | name    |
      | Melania |

  Scenario Outline: Verify View Functionality
    When Commander clicks on the "View" button of the Spartan ID "<id>"
    Then Verify that the "Name" of the Spartan is "<name>" on the Spartan Details Page
    And Verify that the "Gender" of the Spartan is "<gender>" on the Spartan Details Page
    And Verify that the "Phone" of the Spartan is "<phone>" on the Spartan Details Page
    Examples:
      | id | name    | phone      | gender |
      | 30 | Melania | 8916944276 | Female |

#  Scenario Outline: Verify Edit Functionality
#    When Commander clicks on the "Edit" button of the Spartan ID "<id>"
#    Then Commander enters "<newName>" to the "name text box" on the "Spartan Detail Page"
#    And Commander enters "<newPhone>" to the "phone text box" on the "Spartan Detail Page"
#    And Commander clicks on the "Update" button on the "Spartan Detail Page"
#    Then Verifies the success message "<message>" on the "Spartan Detail Page"
#    When Commander clicks on the "Back to the List" button on the "Spartan Detail Page"
#    Then Verifies the name of the Spartan ID "<id>" is "<newName>" on the "Spartan Crud Operation Page"
#    And Verifies the phone of the Spartan ID "<id>" is "<newPhone>" on the "Spartan Crud Operation Page"
#    Examples:
#      | id | newName      | newPhone   | message                    |
#      | 35 | new Gardiner | 3751113352 | Successfully Updated Data! |
#
#  Scenario Outline: Verify Delete Functionality
#    When Commander clicks on the "Delete" button of the Spartan ID "<id>"
#    And Commander enters "<name>" to the search box on the "Spartan Crud Operation Page"
#    And Commander clicks on the "Search" button on the "Spartan Crud Operation Page"
#    Then Verifies "Total Returned" is "0" on the "Spartan Crud Operation Page"
#    Examples:
#      | id | name  |
#      | 36 | Sylas |
#
#  Scenario Outline: Verify Add Spartan Functionality
#    When Commander clicks on the "Add Spartan" button on the "Spartan Crud Operation Page"
#    And Commander enters "<name>" to the "name" text box
#    And Commender selects "<gender>" from the dropdown
#    And Commander enters "<phone>" to the "phone" text box
#    And Commander clicks on the "Submit" button on the "Spartan Detail Page"
#    Then Verifies the success message "<message>"
#    When Commander clicks on the "Back to the List" button
#    When Commander enters "<name>" to the "search box" on the "Spartan Crud Operation Page"
#    And Commander clicks on the "Search" button on the "Spartan Crud Operation Page"
#    Then Verifies the phone is "<phone>" on the table on the "Spartan Crud Operation Page"
#    Then Verifies the gender is "<gender>" on the table on the "Spartan Crud Operation Page"
#    Examples:
#      | name   | gender | phone      | message                      |
#      | Samuel | Female | 9876543210 | Successfully Added new Data! |