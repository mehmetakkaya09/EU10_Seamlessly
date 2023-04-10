package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.UploadPage;
import net.seamlessly.utility.BrowserUtility;
import net.seamlessly.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class UploadStepDefs {

    UploadPage uploadPage = new UploadPage();

    @When("user clicks the + button")
    public void user_clicks_the_button() {
        uploadPage.plusButton.click();
    }

    @When("user clicks the uploadFile link to upload {string} with {string}")
    public void user_clicks_the_upload_file_link_to_upload(String fileName, String extension)
    // throws AWTException  // if you want to use robot class
    {
        String str = System.getProperty("user.dir");
        String filePath = str + "\\src\\test\\resources\\files\\" + fileName + extension;
        uploadPage.uploadFile.sendKeys(filePath);
        BrowserUtility.sleep(3);
        uploadPage.plusButton.click();
        BrowserUtility.sleep(3);

/*
//   also you can below codes to use windows explorer window:
        uploadPage.uploadFileLink.click();
        StringSelection s = new StringSelection("C:\\Users\\Asus\\OneDrive\\Masaüstü\\CYDEO\\a INTERVIEW\\selenium notlarim.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
        Robot robot = new Robot();
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_ENTER);
*/
    }

    @Then("user should see {string} file")
    public void user_should_see_file(String file) {
        String expectedFile = file;
        String actualFile = uploadPage.uploadedFileOrFolder(file).getText();
        Assert.assertEquals("file not uploaded", expectedFile, actualFile);
    }

    @When("user clicks the new folder link")
    public void user_clicks_the_new_folder_link() {
        uploadPage.newFolderLink.click();
        BrowserUtility.sleep(3);
    }

    @When("user create {string} folder")
    public void user_create_folder(String newFolder) {
        uploadPage.newFolderNameInputBox.sendKeys(newFolder + Keys.ENTER);
        BrowserUtility.sleep(3);
    }

    @Then("user should see {string} folder")
    public void user_should_see_folder(String folderName) {
        String expectedFolder = folderName;
        String actualFolder = uploadPage.uploadedFileOrFolder(folderName).getText();
        Assert.assertEquals("folder not uploaded", expectedFolder, actualFolder);
    }

    @When("user clicks the {string} item with {string} three dots button")
    public void user_clicks_the_item_with_extension_three_dots_button(String fileName, String extension) {
        uploadPage.clickThreeDotsButton(fileName, extension);
        BrowserUtility.sleep(2);
    }

    @When("user clicks the move or copy")
    public void user_clicks_the_move_or_copy() {
        uploadPage.moveOrCopyButton.click();
        BrowserUtility.sleep(2);
    }

    @When("user choose target folder {string}")
    public void user_choose_target_folder(String createdFolder) {
        uploadPage.targetFolder(createdFolder).click();
        BrowserUtility.sleep(2);
    }

    @When("user choose the action {string}")
    public void user_choose_the_button(String action) {
        uploadPage.copyOrMoveAction(action);
        BrowserUtility.sleep(2);
    }

    @When("user choose target2 folder {string}")
    public void user_choose_target2_folder(String createdFolder) {
        uploadPage.targetFolder2(createdFolder).click();
        BrowserUtility.sleep(2);
    }

    @Then("user should see {string} file in target folder")
    public void user_should_see_file_in_target_folder(String movedOrCopied) {
        String expectedResult = movedOrCopied;
        String actualResult = uploadPage.uploadedFileOrFolder(movedOrCopied).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @When("user clicks the delete item link")
    public void user_clicks_the_delete_item_link() {
        uploadPage.deleteAnyItem.click();
        BrowserUtility.sleep(2);
    }

    @Then("{string} item deleted")
    public void item_deleted(String selectedItem) {
        List<WebElement> items = Driver.getDriver().findElements(By.xpath("//span[@class='innernametext']"));
        for (WebElement item : items) {
            Assert.assertTrue(item.getText() != selectedItem);
        }
    }

    @Then("user should see the all number of under the files list table")
    public void userShouldSeeTheAllNumberOfFilesAndFoldersUnderTheFilesListTable() {

        List<WebElement> files = Driver.getDriver().findElements(By.xpath("//*[@data-type='file']"));
        String expectedTotalFileNumber = String.valueOf(files.size());

        String actualTotalFileNumber = uploadPage.fileInfo.getText();
        actualTotalFileNumber = actualTotalFileNumber.substring(0, actualTotalFileNumber.indexOf(" "));
        BrowserUtility.sleep(1);

        Assert.assertEquals(expectedTotalFileNumber, actualTotalFileNumber);
        BrowserUtility.sleep(1);

        List<WebElement> folders = Driver.getDriver().findElements(By.xpath("//*[@data-type='dir']"));
        String expectedTotalFolderNumber = String.valueOf(folders.size());

        String actualTotalFolderNumber = uploadPage.dirInfo.getText();
        actualTotalFolderNumber = actualTotalFolderNumber.substring(0, actualTotalFolderNumber.indexOf(" "));
        BrowserUtility.sleep(1);

        Assert.assertEquals(expectedTotalFolderNumber, actualTotalFolderNumber);
        BrowserUtility.sleep(1);

    }

    @When("user upload {string} with {string}")
    public void user_a_create_folder(String newFolder, String extension) {
        uploadPage.uploadFileWithExtension(newFolder, extension);
    }

    @When("user create a {string} folder")
    public void user_a_create_folder(String newFolder) {
        uploadPage.createANewFolder(newFolder);
    }

    @When("delete {string} with extension {string}")
    public void user_choose_the_button(String fileOrFolderName, String extension) {
        uploadPage.deleteAnyItem(fileOrFolderName, extension);
    }


}
