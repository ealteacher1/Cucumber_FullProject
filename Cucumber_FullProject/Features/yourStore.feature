@yourstoreadmin
Feature: Your Store

  Background: Below are common stepr for Every Scenario
    Given User Launch "chrome" browser with "https://admin-demo.nopcommerce.com/login"
    Then user navigated to "Your store. Login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    Then click on Login

@smoke
  Scenario: Validate Successful Login- 1
    Then User land on "Dashboard / nopCommerce administration" Page
    
    
    
    
@regression
  Scenario Outline: Validate customers Page Title---- Regression --2
    Then User land on "Dashboard / nopCommerce administration" Page
    Then User click on "<Menu>" menu
    When User click on customer Button
    Then User land on "<Customer Search>" Page

    Examples: 
      | Menu      | Customer Search                        |
      | Customers | Customers / nopCommerce administration |
      
      
@smoke @regression 
  Scenario Outline: Validate Search Customer by Email
    Then User land on "Dashboard / nopCommerce administration" Page
    Then User click on "<Menu>" menu
    When User click on customer Button
    Then User land on "<Customer Search>" Page
    Then click on "Email" Field
    And insert "<EmailID>" as email
    Then click on Search button
    And Email should be visible 

    Examples: 
      | Menu      | Customer Search                        | EmailID                   |
      | Customers | Customers / nopCommerce administration | james_pan@nopCommerce.com |
