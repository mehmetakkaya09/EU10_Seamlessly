@smoke
  Feature: Seamlessly Smoke Test

    Background: user is on the Files module
      Given user login with valid credentials

    #UPLOAD MODULE MM
    @SEAMLES10-650 #smoke
    Scenario: User can see the total number of files and folders under the files list table
      And user navigates to "files" module
      When user upload "selenium notlarim" with ".txt"
      And  user create a "muezzinoglu" folder
      Then user should see the all number of under the files list table
      And delete "selenium notlarim" with extension ".txt"
      And delete "muezzinoglu" with extension ""

    #TASKS MODULE MAKKAYA
    @SEAMLES10-679 #smoke
    Scenario: User can create a new task
      When user navigates to "tasks" module
      And user clicks Add List…
      And user writes the list name "Test for Task" and presses ENTER key
      And user writes the task name "new task" and presses ENTER key
      Then verify that user sees "new task" in the task list

    #FILES MODULE MAK
    @SEAMLES10-656 #smoke
    Scenario: verify user add any file to favorites from its own three dots menu
      When user navigates to "files" module
      And user clicks on "Folder1" file three dots button
      And user clicks on add to favorites button
      And user clicks on favorites tab button
      Then user see starred "Folder1" file

    #CALENDAR MODULE MUSATIK
    @SEAMLES10-613 #smoke
    Scenario: User  can create a new event  and see it on the calendar
      When   user navigates to "Calendar" module
      And  User  select Monthly view calendar
      And  User  click on New event button
      And  User  input "Alumni Meeting" as a new event in placeholder
      And  User  select beginning time and date
      And  User  select ending time and date
      And  User  click on Save  button
      Then User  should see new event on monthly calendar