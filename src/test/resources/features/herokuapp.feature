@hero
Feature: Verify Selenium actions

  Scenario: Verify File Upload

    When Navigate to the "File Upload" Page
    And Upload file "src/test/resources/textfile.txt"
    Then Verify file is upload successfully

  Scenario: Verify Broken Images

    When Navigate to the "Broken Images" Page
    Then Verify Broken Images