package org.example.project.ui.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.project.configurations.scenario_context.Context;
import org.example.project.ui.browser.Actions;
import org.example.project.ui.pages.CheckoutOverviewPage;
import org.junit.jupiter.api.Assertions;

public class CheckoutOverviewPageSteps extends Context {

    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(webDriver);

    @Then("Checkout overview page is displayed")
    public void checkoutOverviewPageIsDisplayed() {
        Assertions.assertTrue(checkoutOverviewPage.isAt());
    }

    @When("User clicks on Finish button")
    public void userClicksOnFinishButton() {
        Actions.clickOnWebElement(checkoutOverviewPage.getFinishButton());
    }
}
