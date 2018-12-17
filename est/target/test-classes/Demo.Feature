#Author: Vamsi Krishna
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: PHP Travels
@Test1
  Scenario Outline: PHP Travels login
    Given PHP Travels URL opened
    Then enter Valid user"<id>" and "<Password>"
     Then Close browser
    #Examples: 
     # | id                  | Password   |
     # | vamsi2787@gmail.com | Vamsi22338 |
@Test1 
  Scenario: New Order
    Then Create Order
    #Then Close browser
    Then End of Scenario
