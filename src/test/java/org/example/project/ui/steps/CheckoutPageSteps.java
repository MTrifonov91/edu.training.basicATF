package org.example.project.ui.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.project.configurations.scenario_context.Context;
import org.example.project.ui.browser.Actions;
import org.example.project.ui.pages.CheckoutPage;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class CheckoutPageSteps extends Context {

    CheckoutPage checkoutPage = new CheckoutPage(webDriver);

    @Then("Checkout page is displayed")
    public void checkoutPageIsDisplayed() {
        Assertions.assertTrue(checkoutPage.isAt());
    }

    @And("User clicks on Continue button")
    public void userClicksOnContinueButton() {
        Actions.clickOnWebElement(checkoutPage.getContinueButton());
    }

    @When("User enters the following data")
    public void userEntersTheFollowingData(DataTable table) {
        Map<String, String> inputParameters = table.asMap();

        inputParameters.forEach((field, value) -> {
            checkoutPage.setInput(field, value);
        });

    }
}
