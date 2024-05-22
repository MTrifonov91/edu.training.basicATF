package org.example.project.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.example.project.configurations.driverfactory.DriverFactory;
import org.example.project.configurations.logs.Log;
import org.example.project.configurations.properties.PropertyConfigurator;
import org.example.project.configurations.scenario_context.Context;
import org.example.project.utils.screenshot.ScreenShotUtil;
import org.openqa.selenium.WebDriver;

import static org.example.project.configurations.scenario_context.Context.ContextKeys.DRIVER;

public class ExecutionHooks {

//    private static String scenarioName = "";
    private static final Context context = Context.getInstance();
    private final String URL = PropertyConfigurator.getProperty("URL");
    Logger Log = LogManager.getLogger(ExecutionHooks.class);

//    @BeforeAll
//    public static void beforeAll() {
////        ThreadContext.put("scenarioName", scenarioName);
////        Configurator.reconfigure();
//    }
    @Before("@UI")
    public void beforeUi(Scenario scenario) {
        String scenarioName = scenario.getName().trim().replaceAll(" ", "_");
        ThreadContext.put("scenarioName", scenarioName);
        Configurator.reconfigure();
//        Log.startTestCase(scenario.getName());
        context.setContext(DRIVER, DriverFactory.getDriver());
        context.getContext(DRIVER, WebDriver.class).manage().window().maximize();
        Log.info("Browser launched and maximized");
        context.getContext(DRIVER, WebDriver.class).get(URL);
        Log.info("Web application launched");
        ScreenShotUtil.takeScreenShot(scenario);
    }

    @Before("@Api")
    public void beforeApi(Scenario scenario) {
        String scenarioName = scenario.getName().trim().replaceAll(" ", "_");
        ThreadContext.put("scenarioName", scenarioName);
        Configurator.reconfigure();
        Log.info("STARTED");
//        Log.startTestCase(scenario.getName());
    }

    @AfterStep("@UI")
    public void afterStep(Scenario scenario) {

        ScreenShotUtil.takeScreenShot(scenario);
    }

    @After("@UI")
    public void tearDownUi(Scenario scenario) {
//        Log.endTestCase(scenario.getName());
        DriverFactory.closeBrowser();
        DriverFactory.tearDown();
        Context.tearDown();
    }

    @After("@Api")
    public void tearDownApi(Scenario scenario) {
//        Log.endTestCase(scenario.getName());
        Context.tearDown();
    }

}
