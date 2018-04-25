Feature: CategoriesFeature
  In order to use categories
  As a Rs Online user
  I want to be select search for or select a category.


  Scenario Outline: User can select categoery from category panel
    Given I am on the category page
    When I select a <Category> from category panel
    Then I should be taken to the <Selected Category> screen
    Examples:
      | Category  | Selected Category |
      | Connectors | connectors    |
      | Cables-wires  | cables-wires    |

  Scenario Outline: User can select categoery from AllProducts dropdown
    Given I am on the category page
    When I select a '<Category>' from All products dropdown
    Then I should be taken to the <Selected Category> screen
    Examples:
      | Category  | Selected Category |
      | Connectors | connectors    |
      | Cables-wires  | cables-wires    |
