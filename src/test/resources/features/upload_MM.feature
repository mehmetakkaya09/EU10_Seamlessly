@SEAMLES10-593 #user story

Feature: seamlessly upload function
"""
   As a user, I should be able to upload a file, move or delete any selected file under the Files module

  Acceptance Criteria:

  1. User can upload a file
  2. User can create a new folder
  3. User can move or copy any selected item to any folder
  4. User can delete any selected item from its three dots menu
  5. User can see the total number of files and folders under the files list table
"""

  Background: user is on the Files module
    Given user login with valid credentials
    And user navigates to "files" module

  @wipp @SEAMLES10-646 #ac1
  Scenario:  User can upload a file
    When user clicks the + button
    And user clicks the uploadFile link to upload "selenium notlarim" with ".txt"
    Then user should see "selenium notlarim" file

  @wipp @SEAMLES10-647 #ac2
  Scenario: User can create a new folder
    When user clicks the + button
    And user clicks the new folder link
    And user create "muezzinoglu" folder
    Then user should see "muezzinoglu" folder

  @wipp @SEAMLES10-648 #ac3
  Scenario Outline: User can move or copy any selected item to any folder
    When user clicks the "selenium notlarim" item with ".txt" three dots button
    And user clicks the move or copy
    And user choose target folder "muezzinoglu"
    And user choose the action "<action>"
    And user choose target2 folder "muezzinoglu"
    Then user should see "selenium notlarim" file in target folder
    When user clicks the "selenium notlarim" item with ".txt" three dots button
    And user clicks on Rename button
    And user rename "selenium notlarim" to "selenium notlarim1"

    Examples:
      | action |
      | Copy   |
      | Move   |

  @wipp @SEAMLES10-649 #ac4
  Scenario: User can delete any selected item from its three dots menu
    When user clicks the "muezzinoglu" item with "" three dots button
    And user clicks the delete item link
    Then "muezzinoglu" item deleted

  @wipp @SEAMLES10-650 #ac5
  Scenario: User can see the total number of files and folders under the files list table
    When user upload "selenium notlarim" with ".txt"
    And  user create a "muezzinoglu" folder
    Then user should see the all number of under the files list table
    And delete "selenium notlarim" with extension ".txt"
    And delete "muezzinoglu" with extension ""

