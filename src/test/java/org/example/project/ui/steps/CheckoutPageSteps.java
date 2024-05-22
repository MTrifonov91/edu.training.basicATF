package org.example.project.ui.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.project.configurations.scenario_context.Context;
import org.example.project.ui.browser.Actions;
import org.example.project.ui.pages.CheckoutPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.example.project.configurations.scenario_context.Context.ContextKeys.DRIVER;

public class CheckoutPageSteps {

    private static final Context context = Context.getInstance();

    CheckoutPage checkoutPage = new CheckoutPage(context.getContext(DRIVER, WebDriver.class));

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
