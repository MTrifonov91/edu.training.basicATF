package org.example.project.ui.browser;

import org.example.project.configurations.driverfactory.DriverFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Actions {

    private static final Wait<WebDriver> waiter = new FluentWait<>(DriverFactory.getDriver())
            .withTimeout(Duration.of(30, ChronoUnit.SECONDS))
            .pollingEvery(Duration.of(2, ChronoUnit.SECONDS))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);

    public static void clickOnWebElement(WebElement webElement) {
        waiter.until(ExpectedConditions.visibilityOf(webElement));
        waiter.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static void sendKeys(WebElement field, String inputData) {
        waiter.until(ExpectedConditions.visibilityOf(field));
        waiter.until(ExpectedConditions.elementToBeClickable(field));
        field.clear();
        field.sendKeys(inputData);
    }
}
