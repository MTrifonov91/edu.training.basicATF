package org.example.project.ui.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.project.configurations.scenario_context.Context;
import org.example.project.ui.browser.Actions;
import org.example.project.ui.pages.CheckoutCompletePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static org.example.project.configurations.scenario_context.Context.ContextKeys.DRIVER;

public class CheckoutCompleteSteps {

    private static final Context context = Context.getInstance();

    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(context.getContext(DRIVER, WebDriver.class));

    @Then("Checkout Complete page is displayed")
    public void checkoutCompletePageIsDisplayed() {
        Assertions.assertTrue(checkoutCompletePage.isAt());
    }

    @When("User clicks on Back Home button")
    public void userClicksOnBackHomeButton() {
        Actions.clickOnWebElement(checkoutCompletePage.getBackToProductsButton());
    }
}
