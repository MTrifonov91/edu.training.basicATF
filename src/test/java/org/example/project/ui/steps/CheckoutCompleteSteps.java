package org.example.project.ui.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.project.configurations.scenario_context.Context;
import org.example.project.ui.browser.Actions;
import org.example.project.ui.pages.CheckoutCompletePage;
import org.junit.jupiter.api.Assertions;

public class CheckoutCompleteSteps extends Context {

    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(webDriver);

    @Then("Checkout Complete page is displayed")
    public void checkoutCompletePageIsDisplayed() {
        Assertions.assertTrue(checkoutCompletePage.isAt());
    }

    @When("User clicks on Back Home button")
    public void userClicksOnBackHomeButton() {
        Actions.clickOnWebElement(checkoutCompletePage.getBackToProductsButton());
    }
}
