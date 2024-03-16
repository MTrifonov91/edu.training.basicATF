package org.example.project.ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class CheckoutOverviewPage extends Page{

    @FindBy(xpath = "//span[@class='title' and text()='Checkout: Overview']")
    private WebElement pageTitle;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return pageTitle.isDisplayed();
    }
}
