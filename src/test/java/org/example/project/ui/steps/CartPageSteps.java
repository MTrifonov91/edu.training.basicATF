package org.example.project.ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.project.configurations.scenario_context.Context;
import org.example.project.ui.browser.Actions;
import org.example.project.ui.pages.CartPage;
import org.junit.jupiter.api.Assertions;

public class CartPageSteps extends Context {

    CartPage cartPage = new CartPage(webDriver);

    @Given("Your Cart page is displayed")
    public void cartPageIsDisplayed() {
        Assertions.assertTrue(cartPage.isAt());
    }

    @When("User clicks on Checkout button")
    public void userClicksOnCheckoutButton() {
        Actions.clickOnWebElement(cartPage.getCheckoutButton());
    }
}
