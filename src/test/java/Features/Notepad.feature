Feature: Notepad testing
  Scenario: Creating notes
    Given User is on notepad app
    When User creates notes


  Scenario: Changing colours of the notes
    When Change colour of first note
    And Change colour of second note
    And Change colour of third note
    Then Print time stamps of all the notes

  Scenario: Changing the settings
    When User clicks on options
    And User clicks on setting
    And User scrolls to day option and clicks
    Then User clicks on Monday


