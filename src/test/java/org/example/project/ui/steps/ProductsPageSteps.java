package org.example.project.ui.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.project.configurations.scenario_context.Context;
import org.example.project.ui.browser.Actions;
import org.example.project.ui.pages.ProductsPage;
import org.example.project.utils.screenshot.ScreenShotUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.example.project.configurations.scenario_context.Context.ContextKeys.DRIVER;

public class ProductsPageSteps {

    private static final Context context = Context.getInstance();

    ProductsPage productsPage = new ProductsPage(context.getContext(DRIVER, WebDriver.class));

    @Then("Products page is displayed")
    public void productsPageIsDisplayed() {
        Assertions.assertTrue(productsPage.isAt());
    }

    @Then("Product list contains the following items")
    public void productListContainsTheFollowingItems(DataTable table) {
        List<String> expectedItems = table.asList();

        List<List<String>> eee = table.asLists();

        List<String> actualItems = productsPage.getProducts().stream()
                .map(product -> product.getProductTitle().getText())
                .toList();

        Assertions.assertLinesMatch(expectedItems, actualItems);

        System.out.println();
    }

    @When("User adds {string} to cart")
    public void userAddsSauceLabsBackpackToCart(String productTitle) {
        Actions.clickOnWebElement(productsPage.getProductCardByTitle(productTitle).getAddToCartButton());

    }

    @Then("Your Cart has {string} label displayed")
    public void yourCartHasLabelDisplayed(String label) {
        Assertions.assertEquals(productsPage.getYourCartLabel().getText(), label);
    }

    @And("User clicks on Cart")
    public void userClicksOnCart() {
        Actions.clickOnWebElement(productsPage.getYourCartLabel());
    }

    @And("Your Cart is empty")
    public void ensureYourCartIsEmpty() {
        Assertions.assertTrue(productsPage.isCartEmpty());
    }
}
