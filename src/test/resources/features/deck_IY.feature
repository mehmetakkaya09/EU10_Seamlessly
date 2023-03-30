Feature: Deck Module Functionality
  As a user, I should be able to manage my works by creating a new board/list/card and modifying them under Deck Module.



  Acceptance Criteria

  User can create a new board
  User can create a new list of card/task under any board
  User can add a new card/task on any list on the current board
  User can assign any card/task to himself/herself by using the three dots on the related card
  User can move any card on the current board to any other list of other board

  Background:
    Given user login with valid credentials
    And   user navigates to "Deck" module

  @SEAMLES10-614
  Scenario: US-015-TC1 Verify that user can create a new board
    When user opens the navigation menu
    And user clicks on Add board button
    And user enters a name as the board name
    And user clicks on the Right Arrow button or push Enter
    Then user should see a new board with the given name under All Boards Menu

  @SEAMLES10-615
  Scenario: US-015-TC2 User can create a new list of card/task under any board

    When user is on board page
    And user selects any board from the All boards
    And user enters a list name for the selected board
    Then user should see the created list name for



