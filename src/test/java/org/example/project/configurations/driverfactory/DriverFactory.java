package org.example.project.configurations.driverfactory;

import lombok.extern.slf4j.Slf4j;
import org.example.project.configurations.properties.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Slf4j
public class DriverFactory {
    private static final String BROWSER_NAME = PropertyConfigurator.getProperty("BROWSER");
    private static WebDriver driver;

    private DriverFactory() {
        try {
            driver = createDriver(BROWSER_NAME);

        } catch (Exception e) {
            log.error("Error initializing WebDriver: " + e.getMessage());
            throw new RuntimeException("Error initializing WebDriver", e);
        }
    }

    public static WebDriver createDriver(String browserName) {
        return switch (browserName){
            case "CHROME" -> driver = createChromeDriver();
            case "FIREFOX" -> driver = createFirefoxDriver();
            default -> throw new IllegalArgumentException("Invalid browser name: " + browserName);
        };
    }

    private static WebDriver createChromeDriver() {
        return new ChromeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }

    public static WebDriver getDriver(){
        if (driver == null){
            new DriverFactory();
            log.info("WebDriver instance provided");
        }
        return driver;
    }

    public static void closeBrowser(){
        driver.manage().deleteAllCookies();
        driver.close();
        log.info("Browser closed, cookies deleted");
    }

    public static void tearDown(){
        if (driver != null){
            driver.quit();
            driver = null;
            log.info("Driver quit");
        }
    }
}
