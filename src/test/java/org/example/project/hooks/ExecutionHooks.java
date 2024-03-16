package org.example.project.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.example.project.configurations.driverfactory.DriverFactory;
import org.example.project.configurations.properties.PropertyConfigurator;
import org.example.project.configurations.scenario_context.Context;

@Slf4j
public class ExecutionHooks extends Context {

    private final String URL = PropertyConfigurator.getProperty("URL");

    @Before("@UI")
    public void beforeUi(Scenario scenario) {
        log.info("Testing started on '" + scenario.getName() + "'");
        webDriver = DriverFactory.getDriver();
        webDriver.manage().window().maximize();
        log.info("Browser launched and maximized");
        webDriver.get(URL);
        log.info("Web application launched");
    }

    @Before("~@UI")
    public void beforeApi(Scenario scenario) {
        log.info("Testing started on '" + scenario.getName() + "'");

    }

    @After("@UI")
    public void tearDown(Scenario scenario) {
        log.info("Testing ended on '" + scenario.getName() + "'");
        DriverFactory.closeBrowser();
        DriverFactory.tearDown();
    }

}
