@SEAMLES10-675
Feature: tasks module feature

  User Story :

  As a user, I should be able to create a new task list or a single task and add any task to completed and importants tasks list.

  Acceptance Criteria:

  User can create a new list of tasks**
  User can create a new task
  User can add any task to the list of completed tasks by clicking on the checkbox near the task name
  User can add any task to the list of important tasks by clicking on the star icon on the right side of task line
  User can see the number of all uncompleted tasks next to the Current tab

  Background: login
    Given user login with valid credentials
    And user navigates to "tasks" module
@SEAMLES10-676
  Scenario: User can create a new list of tasks with "ENTER" key
    When user clicks Add List…
    And user writes the list name "Test List" and presses ENTER key
    Then verify that user sees this name "Test List" inside the list name list
@SEAMLES10-677
  Scenario: User can create a new list of tasks by clicking save button
    When user clicks Add List…
    And user writes the list name "Test List"
    And user clicks Save button
    Then verify that user sees this name "Test List" inside the list name list
@SEAMLES10-678
  Scenario: User cannot create a new list of tasks with the same name
    When user clicks Add List…
    And user writes the list name "Test for Task" and presses ENTER key
    And user clicks Add List…
    And user writes the list name "Test for Task" and presses ENTER key
    Then verify that user cannot create second same name list and sees the error message
      | The name "Test for Task" is already used. |
@SEAMLES10-679
  Scenario: User can create a new task
    When user clicks Add List…
    And user writes the list name "Test for Task" and presses ENTER key
    And user writes the task name "new task" and presses ENTER key
    Then verify that user sees "new task" in the task list

@SEAMLES10-680  @ignore
  Scenario: User cannot create a new task with the same name
    When user clicks Add List…
    And user writes the list name "Test for Task" and presses ENTER key
    And user writes the task name "new task" and presses ENTER key
    And user writes the task name "new task" and presses ENTER key
    Then verify that user cannot create second same name task
@SEAMLES10-681
  Scenario Outline: User can add any task to the list of completed tasks by clicking on the checkbox near the task name
    When user clicks Add List…
    And user writes the list name "<ListName>" and presses ENTER key
    And user writes the task name "<TaskName>" and presses ENTER key
    And user clicks new task checkbox button
    Then verify that user sees "<Sentence>" sentence with number of tasks
    And verify that user sees completed task number near Completed on the left
    When user clicks "<Menu>" menu on the left
    Then verify that user sees completed "<TaskName>" under "<ListName>" with line-through type "<LineType>"
    Examples:
      | ListName      | TaskName | Sentence       | Menu      | LineType                    |
      | Test for Task | new task | Completed Task | Completed | task-item task-item--closed |
      | 11111111      | 22222222 | Completed Task | Completed | task-item task-item--closed |
@SEAMLES10-682
  Scenario: User can add any task to the list of important tasks by clicking on the star icon on the right side of task line
    When user clicks Add List…
    And user writes the list name "Test for Task" and presses ENTER key
    And user writes the task name "new task AC-5" and presses ENTER key
    And user clicks star icon for fifth AC
    Then verify that user sees star icon as red color "rgb(179, 49, 45)"
    And verify that user sees important task count near the Important
    When user clicks "Important" menu on the left
    Then verify that user sees important task "new task AC-5"

@SEAMLES10-683
  Scenario: User can see the number of all uncompleted tasks next to the Current tab
    When user clicks Add List…
    And user writes the list name "Test for Task" and presses ENTER key
    And user writes the task name "first task AC-6" and presses ENTER key
    And user clicks the three dots button near the task name "first task AC-6"
    And user clicks the add sub task button
    And user writes the subtask name according to parent and presses ENTER key
      | sub    | subtask AC-6    |
      | parent | first task AC-6 |
    And user clicks "Current" menu on the left
    Then verify that user sees all current tasks in the page and next to the Current tab




