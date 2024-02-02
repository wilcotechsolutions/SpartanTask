Feature: Manage Spartans Army

  Agile Story: As the commander of the army, I should manage my soldiers, so that I can win.

  Background: Navigate to main page
    Given Commander navigates to the Spartan Crud Operation Page

  Scenario Outline: Verify Search and Clear Functionality
    When Commander enters "<NAME>" to the "Name Search Text Box" on the "Spartan Crud Operation" page
    And Commander clicks on the "Search" button on the "Spartan Crud Operation" page
    Then Verify that the "Name" data on the table are "<NAME>" on the Spartan Crud Operation Page
    When Commander clicks on the "Clear" button on the "Spartan Crud Operation" page
    Then Verify that "Total Result" is equal to "Total"
    Examples:
      | NAME    |
      | Melania |

  Scenario Outline: Verify View Functionality
    When Commander clicks on the "View" button of the Spartan ID "<ID>"
    Then Verify that the "Name" of the Spartan is "<NAME>" on the Spartan Details Page
    And Verify that the "Gender" of the Spartan is "<GENDER>" on the Spartan Details Page
    And Verify that the "Phone" of the Spartan is "<PHONE>" on the Spartan Details Page
    Examples:
      | ID | NAME    | PHONE      | GENDER |
      | 30 | Melania | 8916944276 | Female |

  Scenario Outline: Verify Edit Functionality
    When Commander clicks on the "Edit" button of the Spartan ID "<ID>"
    Then Commander enters "<NEW NAME>" to the "Name Input Box" on the "Spartan Edit" page
    And Commander enters "<NEW PHONE>" to the "Phone Input Box" on the "Spartan Edit" page
    And Commander clicks on the "Update" button on the "Spartan Edit" page
    Then Verify "SUCCESS MESSAGE" is "<SUCCESS MESSAGE>" on the "Spartan Edit" page
    When Commander clicks on the "Back to the List" button on the "Spartan Edit" page
    When Commander enters "<NEW NAME>" to the "Name Search Text Box" on the "Spartan Crud Operation" page
    And Commander clicks on the "Search" button on the "Spartan Crud Operation" page
    Then Verify that the "Name" data on the table are "<NEW NAME>" on the Spartan Crud Operation Page
    Then Verify that the "Phone" data on the table are "<NEW PHONE>" on the Spartan Crud Operation Page
    Examples:
      | ID | NEW NAME     | NEW PHONE  | SUCCESS MESSAGE            |
      | 35 | new Gardiner | 3751113352 | Successfully Updated Data! |

#  Scenario Outline: Verify Delete Functionality
#    When Commander clicks on the "Delete" button of the Spartan ID "<ID>"
#    And Commander enters "<NAME>" to the "Name Search Text Box" on the "Spartan Crud Operation" page
#    And Commander clicks on the "Search" button on the "Spartan Crud Operation" page
#    Then Verify that "Total Result" is equal to "0"
#    Examples:
#      | ID | NAME  |
#      | 41 | Rosy |

  Scenario Outline: Verify Add Spartan Functionality
    When Commander clicks on the "Add Spartan" button on the "Spartan Crud Operation" page
    Then Commander enters "<NAME>" to the "Name Input Box" on the "Add Spartan" page
    And Commander select "<GENDER>" from the "Gender" dropdown on the "Add Spartan" page
    And Commander enters "<PHONE>" to the "Phone Input Box" on the "Add Spartan" page
    And Commander clicks on the "Submit" button on the "Add Spartan" page
    Then Verify "SUCCESS MESSAGE" is "<SUCCESS MESSAGE>" on the "Add Spartan" page
    When Commander clicks on the "Back to the List" button on the "Add Spartan" page
    When Commander enters "<NAME>" to the "Name Search Text Box" on the "Spartan Crud Operation" page
    And Commander clicks on the "Search" button on the "Spartan Crud Operation" page
    Then Verify that the "Name" data on the table are "<NAME>" on the Spartan Crud Operation Page
    Then Verify that the "Phone" data on the table are "<PHONE>" on the Spartan Crud Operation Page
    Examples:
      | NAME  | GENDER | PHONE      | SUCCESS MESSAGE              |
      | Tariq | Male   | 9876543210 | Successfully Added new Data! |