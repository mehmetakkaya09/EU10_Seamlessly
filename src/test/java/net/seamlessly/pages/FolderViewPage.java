package net.seamlessly.pages;

import net.seamlessly.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FolderViewPage extends BasePage{



    @FindBy(xpath = "//*[@id=\"headerName-container\"]/a/span[1]")
    public WebElement NamesFolder;

    @FindBy(xpath = "//table[@id='filestable']")
    public WebElement tableName;

    @FindBy(xpath = "(//table[@id='filestable']/thead/tr/th[2]/div/a/span[2])[1]")
    public WebElement sortIndicatorIcon;

    @FindBy(xpath = "(//*[@id=\"headerSize\"]/a/span[2])[1]")
    public WebElement sizeSortIndicator;

    @FindBy(xpath = "(//*[@id=\"modified\"]/span[2])[1]")
                      //*[@id="modified"]/span[2]
    public WebElement ModifiedDateSortIndicator;

    @FindBy(xpath = "(//*[@id=\"headerSize\"])[1]")
    public WebElement headerSize;

    @FindBy(xpath = "(//th[@id='headerDate'])[1]")
    public WebElement headerDate;

    @FindBy (xpath = "//label[@id=\'view-toggle\']")
        //label[@id="view-toggle"]
    public WebElement toggleViewButton;

    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement selectAllFiles;

    @FindBy(xpath = "(//*[@id=\"headerSize\"]/a/span[1])[1]")
    public WebElement totalSize;

    @FindBy(xpath = "//div[@id='headerName-container']//a[@class='name sort columntitle']/span[1]")
    public WebElement totalFilesAppearance;

    @FindBy(xpath = "//tbody[@id='fileList']//tr")
    public WebElement folderDataTypes;



//(//table[@id="filestable"])[1]

}
