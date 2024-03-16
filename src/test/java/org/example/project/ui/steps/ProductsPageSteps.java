package org.example.project.ui.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.project.configurations.scenario_context.Context;
import org.example.project.ui.browser.Actions;
import org.example.project.ui.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ProductsPageSteps extends Context {

    ProductsPage productsPage = new ProductsPage(webDriver);

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
