Feature: notes module feature

  Background: login
    Given user login with valid credentials
    When user navigates to "notes" module

  #Acceptance Criteria:**
  #1- User can create a new note


#smoke
  Scenario: verify that user can create a new note
    When user click the plus sign
    And user write notes to note area
    Then user should see the new note title at the left console

  #Acceptance Criteria:***
  #2- User can add any note to the favorites

  Scenario: verify that user can add any note to the favorites
    When user click note dots menu
    And user click to Add to favorites
    And user navigates to "files" module
    And user clicks on favorites tab button
    Then user must see starred "Hello World" file

  #Acceptance Criteria:**
  #3- User can see the number of letters and words
  # that the note includes under the note title
  # when clicked on the details of the note

  Scenario Outline: verify that user can see correct word and character counts in details
    When user click note details dots menu
    And user click to Details
    Then user must see correct counts of <word_count> and <character_count>
    Examples:
      | word_count | character_count |
      | 5          | 25              |
  #Acceptance Criteria:**
  #4- User can create a new category by passing
  # a new category name from inside the notes details

  Scenario Outline: verify that user can create a new category
    When user click note details dots menu
    And user click Details on the menu
    And user write "<category>"
    And user click arrow button
    And user clicks Categories from left menu
    Then user must see the new "<category>"
    Examples:
      | category    |
      | NewCategory |

  #Acceptance Criteria:**
  #5- User can delete any note
  @wipVO
  Scenario: verify that user can delete any note
    When user click note dots menu
    And user click to Delete
    Then note must be disappear
