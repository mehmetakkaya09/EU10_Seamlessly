package net.seamlessly.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.UploadPage;
import net.seamlessly.utility.BrowserUtility;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadStepDefs {

    UploadPage uploadPage = new UploadPage();
    String extension = "txt";

    @When("user clicks the + button")
    public void user_clicks_the_button() {
        uploadPage.plusButton.click();
    }

    @When("user clicks the uploadFile link to upload")
    public void user_clicks_the_upload_file_link() throws AWTException {
        String str = System.getProperty("user.dir");
        System.out.println("str = " + str);
        String filePath = str + "\\src\\test\\java\\net\\seamlessly\\files\\selenium notlarim"+"." + extension;
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
        Assert.assertTrue(uploadPage.uploadedFile(file).isDisplayed());
    }

    String folderName = "muezzinoglu";

    @When("user clicks the new folder link")
    public void user_clicks_the_new_folder_link() {
        uploadPage.newFolder.click();
        uploadPage.newFolderNameInputBox.sendKeys(folderName+ Keys.ENTER);
        BrowserUtility.sleep(3);
    }

    @Then("user should see {string} folder")
    public void user_should_see_folder(String folderName) {
        Assert.assertTrue(uploadPage.uploadedFile(folderName).isDisplayed());
    }


}
