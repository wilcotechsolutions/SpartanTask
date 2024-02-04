@api
Feature: API Tests

  @DisplayAllSpartans
  Scenario Outline: "GET" "/api/spartans" "Display List of All Spartans"
    When Send a "<Request Type>" request to the "<Endpoint>"
    Then Verify that respond "status code" is "<Status Code>"
    Then Verify that respond "content type" is "<Content Type>"
    Examples:
      | Request Type | Endpoint      | Status Code | Content Type     |
      | GET          | /api/spartans | 200         | application/json |

  @AddANewSpartan
  Scenario Outline: "POST" "/api/spartans" "Add a New Spartan"
    When Send a "<Request Type>" request to the "<Endpoint>" with data "<Name>" "<Gender>" "<Phone>"
    Then Verify that respond "status code" is "<Status Code>"
    Then Verify that respond "content type" is "<Content Type>"
    Then Verify that respond "name" is "<Name>"
    Then Verify that respond "gender" is "<Gender>"
    Then Verify that respond "phone" is "<Phone>"
    Examples:
      | Request Type | Endpoint      | Status Code | Content Type     | Name | Gender | Phone      |
      | POST         | /api/spartans | 201         | application/json | Matt | Male   | 9874563210 |

  @DisplayOneSpartansInfo
  Scenario Outline: "GET" "/api/spartans/{id}" "Display One Spartans Info"
    When Send a "<Request Type>" request to the "<Endpoint>" with data "<Id>"
    Then Verify that respond "status code" is "<Status Code>"
    Then Verify that respond "content type" is "<Content Type>"
    Then Verify that respond "name" is "<Name>"
    Then Verify that respond "gender" is "<Gender>"
    Then Verify that respond "phone" is "<Phone>"
    Examples:
      | Request Type | Endpoint      | Id | Status Code | Content Type     | Name     | Gender | Phone      |
      | GET          | /api/spartans | 20 | 200         | application/json | Lothario | Male   | 7551551687 |

  @UpdateASpartan
  Scenario Outline: "PUT" "/api/spartans" "Update a Spartan"
    When Send a "<Request Type>" request to the "<Endpoint>" with data "<Id>" "<Name>" "<Gender>" "<Phone>"
    Then Verify that respond "status code" is "<Status Code>"
    Examples:
      | Request Type | Endpoint      | Id  | Status Code | Name | Gender | Phone      |
      | POST         | /api/spartans | 115 | 204         | Matt | Male   | 9874563210 |

  @DeleteASpartan
  Scenario Outline: "DELETE" "/api/spartans" "Delete a Spartan"
    When Send a "<Request Type>" request to the "<Endpoint>" with data "<Id>"
    Then Verify that respond "status code" is "<Status Code>"
    Examples:
      | Request Type | Endpoint      | Id  | Status Code |
      | DELETE       | /api/spartans | 141 | 204         |

  @PartialUpdateASpartan
  Scenario Outline: "PATCH" "/api/spartans" "Partial Update a Spartan"
    When Send a "<Request Type>" request to the "<Endpoint>" with data "<Id>" "<Name>"
    Then Verify that respond "status code" is "<Status Code>"
    Examples:
      | Request Type | Endpoint      | Id  | Status Code | Name  |
      | PATCH        | /api/spartans | 115 | 204         | Smith |

  @SearchForASpartan
  Scenario Outline: "GET" "/api/spartans/search" "Search for a Spartan"
    When Send a "<Request Type>" request to the "<Endpoint>" with data "<Data>"
    Then Verify that respond "status code" is "<Status Code>"
    Then Verify that respond "content type" is "<Content Type>"
    Then Verify that respond "names" contains "<Data>"
    Examples:
      | Request Type | Endpoint                           | Status Code | Content Type     | Data |
      | GET          | /api/spartans/search?nameContains= | 200         | application/json | Ma   |