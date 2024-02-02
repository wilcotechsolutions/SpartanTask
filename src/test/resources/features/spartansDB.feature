Feature: Check DB Results

  @db
  Scenario: Check the name of the Spartan from DB
    When DB-User gets info of the Spartan with id of 5
    Then Spartan name should be "Blythe"


  @db
  Scenario: Check the name of the Spartan from DB
    When DB-User gets info of the Spartan with id of 5
    Then Spartan name should be "Blythe", gender should be "Female", and phone number should be "3677539542"

  @db
  Scenario Outline:
    When DB-User gets info of the Spartan with id of <id>
    Then Spartan "<name>", "<gender>" and "<phone>" number should fit with the following data

    Examples:
      | id | name    | gender | phone      |
      | 5  | Blythe  | Female | 3677539542 |
      | 10 | Lorenza | Female | 3312820936 |
      | 15 | Meta    | Female | 1938695106 |
