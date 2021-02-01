@smoketest
Feature: smoke test #1, Code exercise in the Index Page of http://automationpractice.com/index.php

  Scenario: Verify add cart, check out, remove actions on the Dress page Demo Site

    #Scenario: "Code Exercise(QA Automation) - 2021"
    Given I open AutomationPractice website
    When I click on "BEST SELLERS" link
    Then I verify "Printed Chiffon Dress" has a discount of "20%"
    When I hover "Printed Chiffon Dress" and click on "Add to cart" button
    And I click on "Continue shopping" button
    And I hover "Blouse" and click on "Add to cart" button
    And I click on "Continue shopping" button
    And I go to the "View my shopping cart" dropdown and select "Check out"
    Then I verify "Printed Chiffon Dress" and "Blouse" are displayed in the summary table and the availability displays "In stock"
    Then I remove "Blouse" from the list
    Then I verify "Blouse" is no longer displayed in the table
    Then I verify the total amount to pay is "$18.40"

