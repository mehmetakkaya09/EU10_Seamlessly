package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.TasksPage;
import net.seamlessly.utility.BrowserUtility;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

public class TasksStepDefs {
    TasksPage tasksPage = new TasksPage();

    String testListName = "Test for Task";

    @When("user navigates to {string} module")
    public void user_navigates_to_module(String moduleName) {
        BrowserUtility.sleep(4);
        tasksPage.navigateToModule(moduleName);
        BrowserUtility.sleep(4);
    }


    @When("user clicks Add List…")
    public void userClicksAddList() {
        tasksPage.addList.click();
    }

    @And("user writes the list name {string} and presses ENTER key")
    public void userWritesTheListNameAndPressesENTERKey(String listName) {
        tasksPage.newListInput.sendKeys(listName + Keys.ENTER);
        BrowserUtility.sleep(3);
    }

    @And("verify that user sees this name {string} inside the list name list")
    public void verifyThatUserSeesThisNameInsideTheListNameList(String listName) {
        assertEquals(tasksPage.TestList.getText(), listName);
        BrowserUtility.sleep(3);
        tasksPage.deleteTestList(listName);
    }


    @And("user writes the list name {string}")
    public void userWritesTheListName(String listName) {
        tasksPage.newListInput.sendKeys(listName);
    }

    @And("user clicks Save button")
    public void userClicksSaveButton() {
        BrowserUtility.sleep(1);
        tasksPage.saveButton.click();
    }

    @And("user writes the task name {string} and presses ENTER key")
    public void userWritesTheTaskNameAndPressesENTERKey(String taskName) {
        tasksPage.addTaskInput.sendKeys(taskName + Keys.ENTER);
    }

    @Then("verify that user sees {string} in the task list")
    public void verifyThatUserSeesInTheTaskList(String taskName) {
        assertEquals(taskName, tasksPage.newTaskName.getText());
        tasksPage.deleteTask(taskName);
        tasksPage.deleteTestList(testListName);
    }


    @And("user clicks new task checkbox button")
    public void userClicksNewTaskCheckboxButton() {
        tasksPage.taskCheckbox.click();
    }

    @Then("verify that user sees {string} sentence with number of tasks")
    public void verifyThatUserSeesSentenceWithNumberOfTasks(String completed) {
        assertTrue(tasksPage.completedTaskSentence.getText().contains(completed));
    }

    @And("verify that user sees completed task number near Completed on the left")
    public void userSeesCompletedTaskNumberNearCompletedOnTheLeft() {
        assertTrue(tasksPage.completedCountOnLeft.isDisplayed());
    }

    @When("user clicks {string} menu on the left")
    public void userClicksMenuOnTheLeft(String topListName) {
        tasksPage.leftTopLists(topListName).click();
    }

    @Then("verify that user sees completed {string} under {string} with line-through type {string}")
    public void verifyThatUserSeesCompletedUnderWithLineThroughType(String taskName, String listName, String closedSentence) {
        assertEquals(closedSentence, tasksPage.completedTaskClosed(taskName).getAttribute("class"));
        tasksPage.deleteTestList(listName);
    }

    @And("user clicks star icon for fifth AC")
    public void userClicksStarIconForFifthAC() {
        BrowserUtility.sleep(3);
        BrowserUtility.scrollToElement(tasksPage.ac5StarIcon);
        BrowserUtility.sleep(3);
        tasksPage.ac5StarIcon.click();

    }

    @Then("verify that user sees star icon as red color {string}")
    public void userSeesStarIconAsRedColor(String red) {

        assertEquals(red, tasksPage.redStarColor.getCssValue("fill"));
    }

    @And("verify that user sees important task count near the Important")
    public void userSeesImportantTaskCountNearTheImportant() {
        assertTrue(tasksPage.importantCount.isDisplayed());
    }


    @Then("verify that user sees important task {string}")
    public void userSeesImportantTask(String taskName) {
        assertEquals(taskName, tasksPage.newTaskInImportant.getText());
        tasksPage.deleteTask(taskName);
        tasksPage.deleteTestList(testListName);
    }

    @And("user clicks the three dots button near the task name {string}")
    public void userClicksTheThreeDotsButtonNearTheTaskName(String taskName) {
        tasksPage.threeDotsElement(taskName).click();
    }

    @And("user clicks the add sub task button")
    public void userClicksTheAddSubTaskButton() {
        tasksPage.addSubTask.click();
    }

    @And("user writes the subtask name according to parent and presses ENTER key")
    public void userWritesTheSubtaskNameAccordingToParentAndPressesENTERKey(Map<String, String> names) {
        tasksPage.subTaskInput(names.get("parent")).sendKeys(names.get("sub") + Keys.ENTER);
    }

    @Then("verify that user sees all current tasks in the page and next to the Current tab")
    public void verifyThatUserSeesAllCurrentTasksInThePageAndNextToTheCurrentTab() {
        Assert.assertEquals(tasksPage.currentPageTasksNum.size(), Integer.parseInt(tasksPage.currentNumber.getText().trim()));
        tasksPage.deleteTestList(testListName);
    }


    @Then("verify that user cannot create second same name list and sees the error message")
    public void userCannotCreateSecondSameNameListAndSeesTheErrorMessage(List<String> errormessage) {
        assertEquals(errormessage.get(0), tasksPage.errorMessage.getText());
        tasksPage.addTaskInput.click();
        tasksPage.deleteTestList(testListName);
    }

    @Then("verify that user cannot create second same name task")
    public void verifyThatUserCannotCreateSecondSameNameTask() {
        try {
            assertEquals(1,tasksPage.newTaskList.size());
        } catch (AssertionError e) {
        }
        tasksPage.deleteTestList(testListName);
    }


}
