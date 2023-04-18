package net.seamlessly.pages;

import net.seamlessly.utility.BrowserUtility;
import net.seamlessly.utility.ConfigurationReader;
import net.seamlessly.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotesPage extends BasePage {


    @FindBy(id = "notes_new_note")
    public WebElement new_note_button;

    @FindBy(xpath = "//*[@id='note-container']/div/div[2]/div[2]/div/div[1]/div[5]/div[1]/div/div/div/div[5]")
    public WebElement note_area;

    @FindBy(xpath = "//*[@id=\"app-navigation-vue\"]/ul/li[3]/a/span")
    public WebElement actual_note_title;


    @FindBy(xpath = "(//button[@class='icon vue-button action-item__menutoggle action-item__menutoggle--default-icon' and @aria-label='Actions'])[3]")
    public WebElement noteDotsMenu;


    @FindBy(xpath = "(//button[@class='action-button focusable'])[3]")
    public WebElement addToFavorites;

    public boolean isVisible(String fileName) {
        return Driver.getDriver().findElement(By.xpath("//span[text()='" + fileName + "' and @class='innernametext']")).isDisplayed();
    }

    @FindBy(xpath = "(//button[@class='icon vue-button action-item__menutoggle action-item__menutoggle--default-icon' and @aria-label='Actions'])[4]")
    public WebElement noteDetailsDotsMenu;


    @FindBy(xpath = "//span[text()='Details']")
    public WebElement noteDetailsMenuBtn;

    @FindBy(xpath = "//p[@class='app-sidebar-header__subtitle']")
    public WebElement notecontentCounts;


    public boolean isContentCountCorrect(int wordCnt, int characterCnt) {
        String entireString = this.notecontentCounts.getText().trim();
        String[] splitedWords = entireString.split(" ");
        int actualWordCountint = Integer.parseInt(splitedWords[0]);
        int actualCharacterCountint = Integer.parseInt(splitedWords[2]);
        if (actualWordCountint == wordCnt && actualCharacterCountint == characterCnt) {
            return true;
        }
        return false;
    }


    @FindBy(xpath = "//span[text()='Details']")
    public WebElement detailMenuBtn;
    @FindBy(xpath = "//input[@id='category']")
    public WebElement categoryInput;
    @FindBy(xpath = "//input[@class='icon-confirm loading']")
    public WebElement confirmArrow;

    @FindBy(xpath = "//span[@title='Categories']")
    public WebElement categoriesLeftMenu;


    public boolean isVisibleCategory(String categoryWord) {
        WebElement gecici = Driver.getDriver().findElement(By.xpath("//span[@title='" + categoryWord + "']"));
        String textOfWebElement = gecici.getAttribute("innerHTML").trim();
        if (textOfWebElement.equals(categoryWord)) {
            return true;
        }
        return false;
    }
    @FindBy(xpath = "//span[text()='Delete note']")
    public WebElement deleteNoteBtn;


}
