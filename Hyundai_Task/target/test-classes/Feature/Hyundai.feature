Feature: Verifying dropdown functionality of the hyundai dealer page

  Scenario: verify that hyundai dealer page details.
    Given User is on hyundai dealer page.
    When User clicks the model dropdown and clicks New Verna.
    Then User clicks the Choose the first option in fuel type.  
    Then User clicks the Choose the first option in Variant.
    Then User clicks the Choose the first option in Exterior Color.
    Then User clicks the Choose the first option in Interior Color.
    Then User clicks the Choose the state city and dealername and verifies all the dealers name in all state and cities.
    
  
