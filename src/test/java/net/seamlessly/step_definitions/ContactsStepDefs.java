package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.ContactsPage;
import net.seamlessly.utility.BrowserUtility;
import net.seamlessly.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class ContactsStepDefs {

    ContactsPage contactsPage = new ContactsPage();

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String NewContact) {
        contactsPage.newContactButton.click();
        BrowserUtility.sleep(3);

    }

    @And("user should see a form to enter contact information")
    public void user_should_see_a_form_to_enter_contact_information() {

        Assert.assertTrue(contactsPage.form.isDisplayed());
      //  BrowserUtility.sleep(10);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(contactsPage.form));
        Assert.assertTrue(contactsPage.form.isDisplayed());
        }

    @And("user fills in the required fields")
    public void user_fills_in_the_required_fields() {
        contactsPage.inputName.sendKeys("QUENTIN"+ Keys.ENTER);
        BrowserUtility.sleep(10);
        contactsPage.inputLastName.sendKeys("TARANTINO"+ Keys.ENTER);
        BrowserUtility.sleep(10);
    }
    @Then("a new contact should be created and added to the list of contacts")
    public void a_new_contact_should_be_created_and_added_to_the_list_of_contacts() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(contactsPage.form));
        Assert.assertTrue(contactsPage.listOfContacts.isDisplayed());

    }
    @When("user clicks on picture icon button")
    public void user_clicks_on_picture_icon_button() {
      contactsPage.pictureIconBtn.click();
        BrowserUtility.sleep(10);
    }
    @When("user should see Choose from files option")
    public void user_should_see_choose_from_files_option() {
        contactsPage.filesBtn.click();
        BrowserUtility.sleep(10);

    }
    @When("user select a picture")
    public void user_select_a_picture() {
        contactsPage.selectPicture.click();
        BrowserUtility.sleep(10);

    }
    @When("user clicks on Choose button")
    public void user_clicks_on_choose_button() {
        contactsPage.chooseBtn.click();
        BrowserUtility.sleep(10);

    }
    @Then("a new profile picture should be changed")
    public void a_new_profile_picture_should_be_changed() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(contactsPage.newProfilePicture));
        Assert.assertTrue(contactsPage.newProfilePicture.isDisplayed());

    }
    @When("user selects a contact")
    public void user_selects_a_contact() {
       contactsPage.contact.click();
       BrowserUtility.sleep(10);

    }
    @When("user clicks on the three dots button")
    public void user_clicks_on_the_three_dots_button() {
      contactsPage.threeDotsBttn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(contactsPage.threeDotsBttn));
    }
    @Then("user clicks on the delete button")
    public void user_clicks_on_the_delete_button() {
        contactsPage.deleteBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(contactsPage.deleteBtn));
      
    }

    }

