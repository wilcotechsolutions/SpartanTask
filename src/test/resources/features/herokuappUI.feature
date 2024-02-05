@herokuUI
Feature: HerokuApp UI Tests

  Scenario: Verify File Upload
    When Navigate to the "File Upload" Page
    And Upload file "src/test/resources/textfile.txt"
    Then Verify file is uploaded successfully "textfile.txt"

  Scenario: Verify Hover Over is Working for Additional Information
    When Navigate to the "Hovers" Page
    Then Verify additional information is shown when hover over
      |name: user1|

  Scenario: Verify Broken Images
    When Navigate to the "Broken Images" Page
    Then Verify there is no broken images
