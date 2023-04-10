package net.seamlessly.pages;

import net.seamlessly.utility.BrowserUtility;
import net.seamlessly.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TasksPage extends BasePage {

    @FindBy(xpath = "//span[normalize-space(text())='Add List…']")
    public WebElement addList;

    @FindBy(id = "newListInput")
    public WebElement newListInput;

    @FindBy(xpath = "//input[@id='newListInput']/following-sibling::input[2]")
    public WebElement saveButton;

    @FindBy(xpath = "//span[normalize-space(text())='Test List']")
    public WebElement TestList;

    @FindBy(xpath = "(//span[normalize-space(text())='Test List']/../..//button)[3]")
    private WebElement testListButton;

    private WebElement listButton(String listName) {
        String xpath = "//span[normalize-space(text())='" + listName + "']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    private WebElement list3DotsButton(String listName) {
        String xpath = "(//span[normalize-space(text())='" + listName + "']/../..//button)[3]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//span[.='Delete']/..")
    private WebElement testListDelete;

    public void deleteTestList(String listName) {

        BrowserUtility.sleep(1);
        BrowserUtility.scrollToElement(listButton(listName));
        BrowserUtility.sleep(1);
        listButton(listName).click();
        BrowserUtility.sleep(1);
        list3DotsButton(listName).click();
        BrowserUtility.sleep(1);
        BrowserUtility.clickWithJS(testListDelete);
        BrowserUtility.sleep(8);
    }

    @FindBy(xpath = "//input[contains(@placeholder,'Add a task to')]")
    public WebElement addTaskInput;
    @FindBy(xpath = "//span[.='new task']")
    public WebElement newTaskName;

    public WebElement navigateToList(String listOrTabName) {
        String xpath = "//span[normalize-space(text())='" + listOrTabName + "']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }


    @FindBy(xpath = "//label[contains(@for, 'checkbox-')]")
    public WebElement taskCheckbox;

    @FindBy(xpath = "//span[.='1 Completed Task']")
    public WebElement completedTaskSentence;

    @FindBy(css = "li#collection_completed>div>div>div.app-navigation-entry__counter")
    public WebElement completedCountOnLeft;

    public WebElement leftTopLists(String topListName) {
        String xpath = "(//span[normalize-space(text())='" + topListName + "']/../..)[1]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }


    public WebElement completedTaskClosed(String taskName){
        String xpath = "//span[.='"+taskName+"']/../../../..";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//span[.='new task AC-5']/../../../div[3]/button")
    public WebElement ac5StarIcon;
    @FindBy(css = "#app-content-vue > div > div.task-list > div > ol > li:nth-child(1) > div.task-item__body.reactive > div.task-body__icons > button > span.material-design-icon.star-icon > svg")
    public WebElement redStarColor;

    @FindBy(xpath = "//span[normalize-space(text())='Important']/../..//div[@class='app-navigation-entry__counter']")
    public WebElement importantCount;

    @FindBy(xpath = "//span[normalize-space(text())='Important']/../..")
    public WebElement important;

    @FindBy(xpath = "//span[.='new task AC-5']")
    public WebElement newTaskInImportant;

    public WebElement threeDotsElement(String elementName) {
        String xpath = "//span[.='" + elementName + "']/../../../div[3]/div/div/div/button";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }


    private WebElement deleteTask() {
        return Driver.getDriver().findElement(By.xpath("//span[.='Delete task']/.."));
    }


    public void deleteTask(String taskName) {
        BrowserUtility.sleep(1);
        BrowserUtility.scrollToElement(threeDotsElement(taskName));
        BrowserUtility.sleep(1);
        threeDotsElement(taskName).click();
        BrowserUtility.sleep(1);
        BrowserUtility.clickWithJS(deleteTask());
        BrowserUtility.sleep(8);
    }

    @FindBy(xpath = "//div[@class='task-list']//div[contains(@task-id,'.ics')]")
    public List<WebElement> currentPageTasksNum;

    @FindBy(xpath = "//li[@id='collection_current']/div/div[1]/div")
    public WebElement currentNumber;


    @FindBy(xpath = "//span[.='Add subtask']")
    public WebElement addSubTask;



    public WebElement subTaskInput(String taskName) {
        String xpath = "//input[@placeholder='Add a subtask to \""+taskName+"\"…']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//div[contains(text(),'is already used.')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//span[.='new task']")
    public List<WebElement> newTaskList;


}
