@SEAMLES10-670
Feature:Profile Settings

  User Story :

  As a user, I should be able to change profile info settings under the Profile module

  Acceptance Criteria:
  User can see at least following titles inside personal info under Profile Settings page;=>Full name/Email/Phone Number
  User can change "Full name" info under Profile Settings page
  User can make "Phone number" info as private under Profile Settings page
  User can see the current local time under the Local dropdown

    Background: login
    Given user login with valid credentials

    @SEAMLES10-630
    Scenario:User can see Full name/Email/Phone Number titles inside personal info under Profile Settings page
    When user navigates the profile menu
    And user sees "Full name" in the profile page
    And user sees "Email" in the profile page
    And user sees "Phone Number" in the profile page
    Then user should see change profile button in the profile page

    @SEAMLES10-631
    Scenario Outline: User can change "Profile Name" info under Profile Settings page
    When user opens the profile menu
    And user changes "<arg0>" in the profile page
    Then user should see changed "<arg0>"  in the profile page
    Examples:
      | arg0         |
      | Employee170  |

    @SEAMLES10-632 #smoke
    Scenario: User can make "Phone number" info as private under Profile Settings page
    When user navigates the profile menu to phone number
    And user changes phone number info as private in the profile page
    Then user should see changed info in the profile page

    @SEAMLES10-632
    Scenario:User can see the current local time under the Local dropdown
    When user navigates the profile menu to local time menu
    And user clicks the local dropdown menu and selects his "location"
    Then user should see his local time











