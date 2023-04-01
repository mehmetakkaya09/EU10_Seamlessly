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
    Given user navigates to "files" module

  @SEAMLES10-646 #ac1
  Scenario:  User can upload a file
    When user clicks the + button
    And user clicks the uploadFile link

