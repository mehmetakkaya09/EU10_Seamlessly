package net.seamlessly.pages;

import net.seamlessly.utility.BrowserUtility;
import net.seamlessly.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void navigateToModule(String moduleName) {
        WebElement module = Driver.getDriver().findElement(By.xpath("//li[@data-id='" + moduleName.toLowerCase() + "' and @tabindex='-1']/a"));
        BrowserUtility.waitForVisibility(module,10);
        BrowserUtility.clickWithJS(module);
    }

    @FindBy(xpath = "//div[@class='notifications']")
    public WebElement notifications;

    @FindBy(xpath = "//div[@id='unified-search']")
    public WebElement search;

    @FindBy(xpath = "//div[@id='contactsmenu']")
    public WebElement contactsMenu;

    @FindBy(xpath = "//div[@id='settings']")
    public WebElement userAvatar;

    @FindBy(xpath = "//a[@class='user-status-menu-item__header']")
    public WebElement userProfile;

    @FindBy(xpath = "//a[@class='user-status-menu-item__toggle']")
    public WebElement userStatus;

    @FindBy(xpath = "//li[@data-id='settings']/a")
    public WebElement settings;

    @FindBy(xpath = "//li[@data-id='firstrunwizard_about']/a")
    public WebElement about;

    @FindBy(xpath = "//li[@data-id='help']/a")
    public WebElement help;

    @FindBy(xpath = "//li[@data-id='logout']/a")
    public WebElement logout;

}
