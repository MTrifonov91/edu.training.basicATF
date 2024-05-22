package org.example.project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = {"src/test/resources/features/ui", "src/test/resources/features/api"},
        glue = {"org/example/project/ui/steps", "org/example/project/hooks", "org/example/project/api/actions"},
        tags = "@Api"
)
public class Runner {
}