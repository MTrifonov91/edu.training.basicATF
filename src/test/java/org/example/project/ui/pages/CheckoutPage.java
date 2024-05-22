package org.example.project.ui.pages;

import lombok.Getter;
import org.example.project.ui.browser.Actions;
import org.example.project.ui.htmlelements.annotations.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class CheckoutPage extends Page {

    @FindBy(xpath = "//span[@class='title' and text()='Checkout: Your Information']")
    private WebElement pageTitle;

    @Name("Continue button")
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@type='text']")
    private List<WebElement> inputFields;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return pageTitle.isDisplayed();
    }

    public WebElement getInputByName(String name) {
        return inputFields.stream()
                .filter(element -> element.getAttribute("placeholder").equals(name))
                .findFirst()
                .orElseThrow();
    }

    public void setInput(String inputName, String value) {
        Actions.sendKeys(getInputByName(inputName), value);
    }
}
