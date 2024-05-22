package org.example.project.ui.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.project.configurations.scenario_context.Context;
import org.example.project.ui.browser.Actions;
import org.example.project.ui.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static org.example.project.configurations.properties.PropertyConfigurator.getProperty;
import static org.example.project.configurations.scenario_context.Context.ContextKeys.DRIVER;

public class LoginPageSteps {

    private static final Context context = Context.getInstance();

    LoginPage loginPage = new LoginPage(context.getContext(DRIVER, WebDriver .class));

    @Given("Login page is displayed")
    public void loginPageIsDisplayed() {
        Assertions.assertTrue(loginPage.isAt());
    }

    @When("User Logs in with credentials for standard user")
    public void userLogsInWithCredentialsForStandardUser() {
        Actions.sendKeys(loginPage.getUserNameInput(), getProperty("STANDARD_USER"));
        Actions.sendKeys(loginPage.getPasswordInput(), getProperty("PASSWORD"));
        Actions.clickOnWebElement(loginPage.getLoginButton());
    }

    @And("User is logged in")
    public void userIsLoggedIn() {
        loginPageIsDisplayed();
        userLogsInWithCredentialsForStandardUser();
    }
}
