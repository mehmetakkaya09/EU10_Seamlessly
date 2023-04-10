package net.seamlessly.pages;


import net.seamlessly.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilesPage extends BasePage{

	UploadPage uploadPage=new UploadPage();

	@FindBy(xpath = "//span[text()='Add to favorites']")
	public WebElement addToFavoritesBtn;

	@FindBy(linkText = "Favorites")
	public WebElement favoritesTabBtn;

	@FindBy(xpath = "//a[@data-action='Rename']")
	public WebElement renameBtn;

	@FindBy(xpath = "//a[@data-action='Details']")
	public WebElement detailsBtn;

	@FindBy(id = "comments")
	public WebElement commentsTab;

	@FindBy(xpath = "//div[@class='comment__editor ']/div")
	public WebElement commentBox;

	@FindBy(xpath = "//span[.='Delete comment']")
	public WebElement deleteCommentButton;

	@FindBy(xpath = "//a//span[.='Delete folder']")
	public WebElement deleteButton;


	public void createFolder(String fileName){
		uploadPage.plusButton.click();

		uploadPage.newFolderLink.click();

		uploadPage.newFolderNameInputBox.sendKeys(fileName+ Keys.ENTER);
	}

	public void clickMoreBtn(String fileName){
		 Driver.getDriver().findElement(By.xpath("(//tr[@data-file='"+fileName+"']//a)[3]")).click();
	}

	public WebElement isVisible(String fileName){
		return Driver.getDriver().findElement(By.xpath("//tr[@data-file='"+fileName+"']"));
	}


	public WebElement renameFolder(String fileName){

		return Driver.getDriver().findElement(By.xpath("//input[@class='filename']"));

	}

        @FindBy(xpath = "//*[@id=\"appmenu\"]/li[2]/a")
        public WebElement All_Files;

        @FindBy(xpath = "//*[@id=\"controls\"]/div[2]/a")
        public WebElement AddFile;

        @FindBy(xpath = "//*[@id=\"controls\"]/div[2]/div[2]/ul/li[3]/a/span[2]")
        public WebElement AddNewTextFile;

        @FindBy(xpath = "//*[@id=\"view11-input-file\"]")
        public WebElement NewTextFileTextBox;

        @FindBy(xpath = "//*[@id=\"controls\"]/div[2]/div[2]/ul/li[3]/a/form/input[2]")
        public WebElement CreateNewTextFile;

        @FindBy(xpath = "//*[@id=\"viewer\"]/div[1]/div[2]/button/span[1]")
        public WebElement CloseTextFileEditBox;

        @FindBy(xpath = "//span[.=\"New Text Delete 1\"]")
        public WebElement NewTextDelete1File;

        @FindBy(xpath = "//span[.=\"New Text Delete 2\"]")
        public WebElement NewTextDelete2File;

        @FindBy(xpath = "//*[@id=\"rightClickMenu\"]/ul/li[7]/a")
        public WebElement DeleteWithRightClick;
        @FindBy(xpath = "//*[@id=\"app-navigation\"]/ul/li[6]/a")
        public WebElement Deleted_Files_Tab;

        @FindBy(xpath = "//*[@id=\"headerName-container\"]/a/span[2]")
        public WebElement SortbyName;

        @FindBy(xpath = "//*[.=\"Deleted\"]//span[@class=\"sort-indicator icon-triangle-s\"]")
        public WebElement SortbyDateAsc;

        @FindBy(xpath = "//*[.=\"Deleted\"]//span[@class=\"sort-indicator icon-triangle-n\"]")
        public WebElement SortbyDateDes;

        @FindBy(xpath = "//*[@id=\"fileList\"]/tr[1]")
        public WebElement FirstElementOfTheDeletedItems;


}
