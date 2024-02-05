@spartansAPI
Feature: API Tests

  @DisplayAllSpartans
  Scenario Outline: "GET" "/api/spartans" "Display List of All Spartans"
    When Send a request to display all Spartans
    Then Verify that response "status code" is "<Status Code>"
    Then Verify that response "content type" is "<Content Type>"
    Then Verify that response body is not empty
    Examples:
      | Status Code | Content Type     |
      | 200         | application/json |

  @AddANewSpartan
  Scenario Outline: "POST" "/api/spartans" "Add a New Spartan"
    When Send a request to add a new Spartan "<Name>" "<Gender>" "<Phone>"
    Then Verify that response "status code" is "<Status Code>"
    Then Verify that response "content type" is "<Content Type>"
    Examples:
      | Status Code | Content Type     | Name | Gender | Phone      |
      | 201         | application/json | Jane | Female | 9874563210 |

  @DisplayOneSpartansInfo
  Scenario Outline: "GET" "/api/spartans/{id}" "Display One Spartans Info"
    When Send a request to display last created Spartan
    Then Verify that response "status code" is "<Status Code>"
    Then Verify that response "content type" is "<Content Type>"
    Then Verify that response "name" is "<Name>"
    Then Verify that response "gender" is "<Gender>"
    Then Verify that response "phone" is "<Phone>"
    Examples:
      | Status Code | Content Type     | Name | Gender | Phone      |
      | 200         | application/json | Jane | Female | 9874563210 |

  @UpdateASpartan
  Scenario Outline: "PUT" "/api/spartans/{id}" "Update a Spartan"
    When Send a request to update the last created Spartan "<Name>" "<Gender>" "<Phone>"
    Then Verify that response "status code" is "<Status Code>"
    Examples:
      | Status Code | Name | Gender | Phone      |
      | 204         | Matt | Male   | 9874563210 |

  @PartialUpdateASpartan
  Scenario Outline: "PATCH" "/api/spartans" "Partial Update a Spartan"
    When Send a request to partially update the last created Spartan "<Name>"
    Then Verify that response "status code" is "<Status Code>"
    Examples:
      | Status Code | Name  |
      | 204         | Smith |

  @SearchForASpartan
  Scenario Outline: "GET" "/api/spartans/search" "Search for a Spartan"
    When Send a request to search for the last created Spartan "<Data>"
    Then Verify that response "status code" is "<Status Code>"
    Then Verify that response "content type" is "<Content Type>"
    Then Verify that response "<Data Type>" list contains "<Data>"
    Examples:
      | Status Code | Content Type     | Data Type | Data  |
      | 200         | application/json | name      | Smith |
      | 200         | application/json | gender    | Male  |

  @DeleteASpartan
  Scenario Outline: "DELETE" "/api/spartans" "Delete a Spartan"
    When Send a request to delete the last created Spartan
    Then Verify that response "status code" is "<Status Code>"
    Examples:
      | Status Code |
      | 204         |


