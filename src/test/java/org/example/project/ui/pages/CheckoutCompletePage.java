package org.example.project.ui.pages;

import lombok.Getter;
import org.example.project.ui.htmlelements.annotations.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class CheckoutCompletePage extends Page{

    @FindBy(xpath = "//span[@class='title' and text()='Checkout: Complete!']")
    private WebElement pageTitle;

    @Name("Back to Products button")
    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backToProductsButton;
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return pageTitle.isDisplayed();
    }
}
