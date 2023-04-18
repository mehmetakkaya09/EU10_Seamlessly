package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.BasePage;
import net.seamlessly.pages.LoginPage;
import net.seamlessly.runners.SeamlesslyRunner;
import net.seamlessly.utility.BrowserUtility;
import net.seamlessly.utility.ConfigurationReader;
import net.seamlessly.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void userIsOnTheHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
    }

    @Then("user sees dashboard")
    public void userSeesDashboard() {
        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains("dashboard"));
    }

    @When("user clicks login button")
    public void userClicksLoginButton() {
        loginPage.loginButton.click();
    }

    @When("user writes valid username")
    public void userWritesValidUsername() {
        loginPage.userName.sendKeys("Employee170");
        BrowserUtility.sleep(2);

    }

    @And("user writes valid password")
    public void userWritesValidPassword() {
        loginPage.inputPassword.sendKeys("Employee123");
        BrowserUtility.sleep(2);
    }

    @When("user presses enter key")
    public void userPressesEnterKey() {
        loginPage.inputPassword.click();
        loginPage.inputPassword.sendKeys(Keys.ENTER);
    }

    @When("user writes invalid username {string}")
    public void userWritesInvalidUsername(String username) {
        loginPage.userName.sendKeys(username);
    }

    @When("user writes invalid password {string}")
    public void userWritesInvalidPassword(String password) {
        loginPage.inputPassword.sendKeys(password);
    }

    @Then("user cannot see dashboard and sees the notice wrong message")
    public void userCannotSeeDashboardAndSeesTheNoticeWrongMessage() {
        Assert.assertEquals(loginPage.wrongPassword.getText(), "Wrong username or password.");
    }

    @Then("user cannot see dashboard and sees the notice blank message")
    public void userCannotSeeDashboardAndSeesTheNoticeBlankMessage() {
        if (loginPage.userName.getAttribute("value").isEmpty()) {
            Assert.assertEquals(loginPage.userName.getAttribute("validationMessage"), "Please fill out this field.");
        }
        if (loginPage.inputPassword.getAttribute("value").isEmpty()) {
            Assert.assertEquals(loginPage.inputPassword.getAttribute("validationMessage"), "Please fill out this field.");
        }
    }

    @Then("user sees the password in a form of dots")
    public void userSeesThePasswordInAFormOfDots() {
        if (loginPage.inputPassword.getAttribute("type").equals("password")) {
            Assert.assertEquals(loginPage.inputPassword.getAttribute("value"), "Employee123");
        }
    }

    @And("User clicks to toggle button")
    public void userClicksToToggleButton() {
        loginPage.passwordEye.click();
    }

    @Then("User sees the password")
    public void userSeesThePassword() {
        Assert.assertEquals(loginPage.inputPassword.getAttribute("value"), "Employee123");
    }

    @Then("user sees the Forgot password link")
    public void userSeesTheForgotPasswordLink() {
        Assert.assertTrue(loginPage.forgotPassword.isDisplayed());
    }

    @And("User clicks Forgot password link")
    public void userClicksForgotPasswordLink() {
        loginPage.forgotPassword.click();
        BrowserUtility.sleep(2);
    }

    @Then("user sees reset password link")
    public void userSeesResetPasswordLink() {
        Assert.assertTrue(loginPage.resetPassword.isDisplayed());
    }

    @Then("user sees username placeholder")
    public void userSeesUsernamePlaceholder() {
        Assert.assertEquals(loginPage.userName.getAttribute("placeholder"), "Username or email");
    }

    @Then("user sees password placeholder")
    public void userSeesPasswordPlaceholder() {
        Assert.assertEquals(loginPage.inputPassword.getAttribute("placeholder"), "Password");
    }
    @Given("user login with valid credentials")
    public void userLoginWithValidCredentials() {
        loginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
    }
}
