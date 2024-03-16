package org.example.project.ui.pages;

import lombok.Getter;
import org.example.project.ui.pages.blocks.ProductCardBlock;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductsPage extends Page {

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement yourCartLabel;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> productElements;

    private List<ProductCardBlock> products;
    public ProductsPage(WebDriver driver) {
        super(driver);
        initializeProductCardBlocks();
    }

    private void initializeProductCardBlocks() {
        products = new ArrayList<>();
        for (WebElement productElement : productElements) {
            ProductCardBlock productCardBlock = new ProductCardBlock(productElement);
            products.add(productCardBlock);
        }
    }

    public boolean isAt() {
        return pageTitle.isDisplayed();
    }

    public boolean isCartEmpty() {
        try {
            return !yourCartLabel.isDisplayed();
        }
        catch (NoSuchElementException e) {
            return true;
        }
    }

    public ProductCardBlock getProductCardByTitle(String title) {
        return products.stream()
                .filter(product -> product.getProductTitle().getText().equals(title))
                .findFirst()
                .orElseThrow();
    }
}
