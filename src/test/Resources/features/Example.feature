@example
Feature: Example Page WorkFlows

  @ui @p1 @submitWithName
  Scenario Outline: Verify user is able to submit the application with only name input entered  in different formats
    Given example page is launched
    When user enter the name in <Format> format
    And click on submit button
    Then valid success message should be displayed

    Examples:
      | Format        |
      | ALPHA_NUMERIC |
      | SPECIAL       |
      | UNICODE       |
      | BLANK         |
      | LENGTHY       |

  @importantFeatures
  Scenario: Verify user is able submit the application with all the important features selected
    Given example page is launched
    When user enter the name in ALPHA_NUMERIC format
    And select all the IMPORTANT_FEATURES
    And click on submit button
    Then valid success message should be displayed

  @osType
  Scenario: Verify user is able submit the application with OS alone selected
    Given example page is launched
    When user enter the name in ALPHA_NUMERIC format
    And select an WINDOWS OS
    And click on submit button
    Then valid success message should be displayed

  @interface
  Scenario: Verify user is able submit the application by choosing TestCafe interface
    Given example page is launched
    When user enter the name in ALPHA_NUMERIC format
    And user select TestCafe Interface as COMMAND_LINE
    And click on submit button
    Then valid success message should be displayed

  @testCafe
  Scenario: Verify user is able submit the application with choosing Test Cafe
    Given example page is launched
    When user enter the name in ALPHA_NUMERIC format
    And user enable TestCafe and rate the TestCafe with value 5
    And specify I think "Its an wonderful tool" about TestCafe
    And click on submit button
    Then valid success message should be displayed

  @all
  Scenario: Verify user is not allowed to submit the form without specifying name and with all other options enabled
    Given example page is launched
    When select all the IMPORTANT_FEATURES
    And select an WINDOWS OS
    And user select TestCafe Interface as COMMAND_LINE
    And user enable TestCafe and rate the TestCafe with value 5
    Then submit button should be in DISABLED state