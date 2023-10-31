Feature: Login
Scenario: Successful Login to the page
	Given I open the saucedemo login page
    When I provide username as "standard_user" and password as "secret_sauce"
    And I click on login button
    Then the "Products" page should be displayed
    When I click the menu button
    And I wait for the page to load
    And I click the logout link
    Then I Close the browser

Scenario: Buying the items
	Given I open the saucedemo login page
    When I provide username as "standard_user" and password as "secret_sauce"
    And I click on login button
    Then the "Products" page should be displayed
    And I select the "backpack" into AddToCart
    And I select the "bike-light" into AddToCart
    And I select the "bolt-t-shirt" into AddToCart
    And I click the ShoppingCart link
    And I remove the "backpack" from the cart
    And I proceed to the Checkout
    Then the "Checkout: Your Information" page should be displayed
    When I enter the firstname "Srinikesh" in the checkout information page
    And I enter the lastname "M" in the checkout information page
    And I enter the zip code "637016" in the checkout information page
    And I click the continue button in the checkout information page
    Then the "Checkout: Overview" page should be displayed
    When I click the finish button in the Checkout Overview page
    Then the order is placed and the page shout have the text "Thank you for your order!"
    And I Close the browser
    
Scenario: Buying the items with value between $30-$60
	Given I open the saucedemo login page
    When I provide username as "standard_user" and password as "secret_sauce"
    And I click on login button
    Then the "Products" page should be displayed
    And I select the "backpack" into AddToCart
    And I select the "bike-light" into AddToCart
    And I click the ShoppingCart link
    And I proceed to the Checkout
    Then the "Checkout: Your Information" page should be displayed
    When I enter the firstname "Srinikesh" in the checkout information page
    And I enter the lastname "M" in the checkout information page
    And I enter the zip code "637016" in the checkout information page
    And I click the continue button in the checkout information page
    Then the "Checkout: Overview" page should be displayed
    When I verify the order values are between 30.00 to 60.00 dollars
    And I click the finish button in the Checkout Overview page
    Then the order is placed and the page shout have the text "Thank you for your order!"
    And I Close the browser
    

 