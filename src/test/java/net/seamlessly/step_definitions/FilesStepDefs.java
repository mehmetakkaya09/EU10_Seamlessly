package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.FilesPage;
import net.seamlessly.pages.UploadPage;
import net.seamlessly.utility.BrowserUtility;
import net.seamlessly.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class FilesStepDefs {
	FilesPage filesPage=new FilesPage();
	UploadPage uploadPage=new UploadPage();


	@When("user clicks on {string} file three dots button")
	public void userClicksOnFileThreeDotsButton(String fileName) {

		filesPage.createFolder(fileName);

		filesPage.clickMoreBtn(fileName);
	}


	@And("user clicks on add to favorites button")
	public void userClicksOnAddToFavoritesButton() {
		filesPage.addToFavoritesBtn.click();
	}

	@And("user clicks on favorites tab button")
	public void userClicksOnFavoritesTabButton() {
		filesPage.favoritesTabBtn.click();
	}


	@Then("user see starred {string} file")
	public void userSeeStarredFile(String fileName) {

		WebElement starred = Driver.getDriver().findElement(By.xpath("(//tr[@data-file='" + fileName + "'])[2]"));

		Assert.assertTrue(starred.isDisplayed());

	}


	@And("user clicks on Rename button")
	public void userClicksOnRenameButton() {

		filesPage.renameBtn.click();
	}

	@And("user rename {string} to {string}")
	public void userRenameTo(String oldName, String newName) {
		BrowserUtility.scrollToElement(filesPage.renameFolder(oldName));

		filesPage.renameFolder(oldName).sendKeys(newName+ Keys.ENTER);

	}


	@Then("user see new name as {string}")
	public void userSeeNewNameAs(String newName) {
		Assert.assertTrue(filesPage.isVisible(newName).isDisplayed());
	}

	@And("user clicks on Details button")
	public void userClicksOnDetailsButton() {
		filesPage.detailsBtn.click();
	}

	@And("user clicks to Comments tab")
	public void userClicksToCommentsTab() {
		filesPage.commentsTab.click();
	}

	@And("user put comment as {string} into comment box and send it")
	public void userPutCommentAsIntoCommentBoxAndSendIt(String comment) {
		filesPage.commentBox.sendKeys(comment+Keys.ENTER);
	}

	@Then("user observe comment {string} is displayed")
	public void userObserveCommentIsDisplayed(String comment) {
		String actualComment = Driver.getDriver().findElement(By.xpath("//div[.='" + comment + "']")).getText();
		Assert.assertEquals(comment,actualComment);
	}

	@And("user clicks on {string} comment three dots menu")
	public void userClicksOnCommentThreeDotsMenu(String comment) {
		Driver.getDriver().findElement(By.xpath("(//div[.='"+comment+"']/../div/div)[2]")).click();
	}

	@And("user clicks on Delete comment button")
	public void userClicksOnDeleteCommentButton() {
		filesPage.deleteCommentButton.click();
	}

	@Then("user observe comment {string} is disappeared")
	public void userObserveCommentIsDisappeared(String comment) {
		WebElement commentHere = Driver.getDriver().findElement(By.xpath("//div[.='" + comment + "']"));
		Assert.assertFalse(commentHere.isDisplayed());
	}

}
