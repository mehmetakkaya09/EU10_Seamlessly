package net.seamlessly.pages;

import io.cucumber.java.en.And;
import net.seamlessly.utility.BrowserUtility;
import net.seamlessly.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadPage extends BasePage {

    public WebElement uploadedFileOrFolder(String fileName) {
        return Driver.getDriver().findElement(By.xpath("//span[text()='" + fileName + "']"));
    }

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusButton;

    @FindBy(xpath = "//input[@id='file_upload_start']")
    public WebElement uploadFile;

    @FindBy(xpath = "//span[text()='New folder']")
    public WebElement newFolderLink;

    @FindBy(id = "view11-input-folder")
    public WebElement newFolderNameInputBox;

    @FindBy(xpath = "//a[@data-action='MoveCopy']")
    public WebElement moveOrCopyButton;

    @FindBy(xpath = "//a[@data-action='Delete']")
    public WebElement deleteAnyItem;

    @FindBy(xpath = "//span[@class='fileinfo']")
    public WebElement fileInfo;

    @FindBy(xpath = "//span[@class='dirinfo']")
    public WebElement dirInfo;

    public WebElement targetFolder(String createdFolder) {
        return Driver.getDriver().findElement(By.xpath("//tr[@data-entryname='" + createdFolder + "']"));
    }

    public WebElement targetFolder2(String createdFolder) {
        return Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + createdFolder + "']"));
    }

    public void copyOrMoveAction(String action) {
        Driver.getDriver().findElement(By.xpath("//button[.='" + action + " to muezzinoglu']")).click();
    }

    public void clickThreeDotsButton(String fileName, String extension) {
        Driver.getDriver().findElement(By.xpath("(//tr[@data-file='" + fileName + extension + "']//a)[3]")).click();
    }

    public void deleteAnyItem(String fileName, String extension) {
        clickThreeDotsButton(fileName, extension);
        BrowserUtility.sleep(2);
        deleteAnyItem.click();
        BrowserUtility.sleep(2);
    }

    public void uploadFileWithExtension(String fileName, String extension) {
        plusButton.click();
        String str = System.getProperty("user.dir");
        String filePath = str + "\\src\\test\\resources\\files\\" + fileName + extension;
        uploadFile.sendKeys(filePath);
        BrowserUtility.sleep(2);
        plusButton.click();
        BrowserUtility.sleep(2);
    }

    public void createANewFolder(String newFolder) {
        plusButton.click();
        newFolderLink.click();
        BrowserUtility.sleep(2);
        newFolderNameInputBox.sendKeys(newFolder + Keys.ENTER);
        BrowserUtility.sleep(2);
    }

}
