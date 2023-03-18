package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.DashboardPage;
import net.seamlessly.utility.Driver;
import org.junit.Assert;

public class Logout_step_definitions {

        DashboardPage dashboardPage = new DashboardPage();
    @When("user can click the user avatar scrolldown area")
    public void user_can_click_the_user_avatar_scrolldown_area() {
        dashboardPage.userAvatar.click();
    }
    @When("user can click the Log out button")
    public void user_can_click_the_log_out_button() {
        dashboardPage.logOut.click();
    }
    @Then("user can log out")
    public void user_can_log_out() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Seamlessly"));
    }

    @And("user can click to step back button")
    public void userCanClickToStepBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("user cannot go to home page again")
    public void userCannotGoToHomePageAgain() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Seamlessly"));
    }
}