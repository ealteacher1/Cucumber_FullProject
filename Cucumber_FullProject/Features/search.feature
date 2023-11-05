@search
Feature: search



  Background: Navigate to homepage
    Given navigate to amazonHomePage

  Scenario Outline: Verify The Search Function with different items
    Then write keyword "<Item>" in search Field.
    When I clicked on search icon
    And waiting to load the Search result page
    Then the Number of result shows <Results>

    Examples: 
      | Item     | Results |
      | Computer |    5000 |
      | Phone |    2000 |

