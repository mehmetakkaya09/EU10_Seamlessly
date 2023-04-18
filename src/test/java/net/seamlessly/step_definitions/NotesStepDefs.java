package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.NotesPage;
import net.seamlessly.utility.BrowserUtility;
import net.seamlessly.utility.ConfigurationReader;
import net.seamlessly.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class NotesStepDefs {
    NotesPage notesPage = new NotesPage();

    @When("user click the plus sign")
    public void user_click_the_plus_sign() {
        notesPage.new_note_button.click();
    }
    @When("user write notes to note area")
    public void user_write_notes_to_note_area() {
        BrowserUtility.sleep(2);
        notesPage.note_area.sendKeys("Hello World"+Keys.ENTER);
        notesPage.note_area.sendKeys("How are you?"+Keys.ENTER);
        //BrowserUtility.sleep(5);
    }
    @Then("user should see the new note title at the left console")
    public void user_should_see_the_new_note_title_at_the_left_console() {
        String expectedNoteTitle = "Hello World";
        String actualNoteTitle = notesPage.actual_note_title.getAttribute("title");
        Assert.assertEquals(expectedNoteTitle,actualNoteTitle);
    }
    @When("user click note dots menu")
    public void user_click_note_dots_menu() {

        BrowserUtility.clickWithJS(notesPage.noteDotsMenu);

    }
    @When("user click to Add to favorites")
    public void user_click_to_add_to_favorites() {
        BrowserUtility.clickWithJS(notesPage.addToFavorites);
    }
    @Then("user must see starred {string} file")
    public void userSeeStarredFile(String fileName) {
        Assert.assertTrue(notesPage.isVisible(fileName));
    }

    @When("user click note details dots menu")
    public void user_click_note_details_dots_menu() {
        BrowserUtility.clickWithJS(notesPage.noteDetailsDotsMenu);
    }
    @And("user click Details on the menu")
    public void userClickDetailsOnTheMenu() {
        BrowserUtility.clickWithJS(notesPage.detailMenuBtn);
    }
    @When("user click to Details")
    public void user_click_to_details() {
        BrowserUtility.clickWithJS(notesPage.noteDetailsMenuBtn);
    }
    @Then("user must see correct counts of {int} and {int}")
    public void user_must_see_correct_counts_of_word_count_and_character_count(int wordCount, int characterCount) {
        Assert.assertTrue(notesPage.isContentCountCorrect(wordCount,characterCount));
    }

    @When("user write {string}")
    public void user_write(String categoryWord) {
        notesPage.categoryInput.sendKeys(categoryWord);
    }
    @When("user click arrow button")
    public void user_click_arrow_button() {
        notesPage.confirmArrow.click();

    }
    @When("user clicks Categories from left menu")
    public void user_clicks_categories_from_left_menu() {
        BrowserUtility.clickWithJS(notesPage.categoriesLeftMenu);
        BrowserUtility.sleep(5);

    }

    @When("user must see the new {string}")
    public void user_must_see_the_new(String categoryWord) {
        Assert.assertTrue(notesPage.isVisibleCategory(categoryWord));
    }

    @When("user click to Delete")
    public void user_click_to_delete() {
        BrowserUtility.clickWithJS(notesPage.deleteNoteBtn);
    }
    @Then("note must be disappear")
    public void note_must_be_disappear() {
        BrowserUtility.waitForInvisibility(notesPage.actual_note_title, 10);
    }



}
