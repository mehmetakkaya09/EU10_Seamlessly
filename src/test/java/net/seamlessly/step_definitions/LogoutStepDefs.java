package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.BasePage;
import net.seamlessly.utility.Driver;
import org.junit.Assert;

public class LogoutStepDefs {

        BasePage basePage = new BasePage();
    @When("user clicks the user avatar scrolldown area")
    public void user_clicks_the_user_avatar_scrolldown_area() {
        basePage.userAvatar.click();
    }
    @When("user clicks the Log out button")
    public void user_clicks_the_log_out_button() {
        basePage.logout.click();
    }
    @Then("user logs out")
    public void user_logs_out() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Seamlessly"));
    }

    @And("user clicks to step back button")
    public void userClicksToStepBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("user cannot go to home page again")
    public void userCannotGoToHomePageAgain() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Seamlessly"));
    }


}
