package org.example.project.ui.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.project.configurations.scenario_context.Context;
import org.example.project.ui.browser.Actions;
import org.example.project.ui.pages.CheckoutOverviewPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static org.example.project.configurations.scenario_context.Context.ContextKeys.DRIVER;

public class CheckoutOverviewPageSteps {

    private static final Context context = Context.getInstance();

    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(context.getContext(DRIVER, WebDriver.class));

    @Then("Checkout overview page is displayed")
    public void checkoutOverviewPageIsDisplayed() {
        Assertions.assertTrue(checkoutOverviewPage.isAt());
    }

    @When("User clicks on Finish button")
    public void userClicksOnFinishButton() {
        Actions.clickOnWebElement(checkoutOverviewPage.getFinishButton());
    }
}
