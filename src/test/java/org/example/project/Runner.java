package org.example.project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        plugin = {"pretty", "html:reports/cucumber-reports/cucumber-report.html"},
        features = {"src/test/resources/features/ui", "src/test/resources/features/api"},
        glue = {"org/example/project/ui/steps", "org/example/project/hooks", "org/example/project/api/actions"},
        tags = "@Res"
)
public class Runner {
}
