@SEAMLES10-659
Feature: Files module functionalities

  User Story :As a user, I should be able to add a file to favorites, rename any file and give some comments on any file.

  Acceptance Criteria:

  1.User can add any file to favorites from its own three dots menu
  2.User can rename any file from its own three dots menu
  3.User can put some comments on any file from the file details menu opened right side
  4.User can delete the comments made on any file from the the file details menu opened right side

  Background:
    Given user login with valid credentials
    And user navigates to "files" module

  @SEAMLES10-656 @wip
  Scenario: verify user add any file to favorites from its own three dots menu
    When user clicks on "Folder1" file three dots button
    And user clicks on add to favorites button
    And user clicks on favorites tab button
    Then user see starred "Folder1" file

  @SEAMLES10-685 @wippp
  Scenario: verify User can rename any file from its own three dots menu
    When user clicks on "Folder2" file three dots button
    And user clicks on Rename button
    And user rename "Folder2" to "Folder222"
    Then user see new name as "Folder222"

  @SEAMLES10-662 @wip
  Scenario: verify user can put some comments on any file from the file details menu opened right side
    When user clicks on "Folder3" file three dots button
    And user clicks on Details button
    And user clicks to Comments tab
    And user put comment as "Significant File" into comment box and send it
    Then user observe comment "Significant File" is displayed

  @SEAMLES10-663 @wip
  Scenario: verify user can delete the comments made on any file from the the file details menu opened right side
    When user clicks on "Folder4" file three dots button
    And user clicks on Details button
    And user clicks to Comments tab
    And user put comment as "Significant File" into comment box and send it
    And user clicks on "Significant File" comment three dots menu
    And user clicks on Delete comment button
    Then user observe comment "Significant File" is disappeared






