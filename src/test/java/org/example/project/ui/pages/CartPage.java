package org.example.project.ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class CartPage extends Page{

    @FindBy(xpath = "//span[@class='title' and text()='Your Cart']")
    private WebElement pageTitle;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return pageTitle.isDisplayed();
    }
}
