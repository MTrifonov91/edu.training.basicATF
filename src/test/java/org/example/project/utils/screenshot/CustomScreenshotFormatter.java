package org.example.project.utils.screenshot;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Result;

public class CustomScreenshotFormatter implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(Result.class, this::handleResult);
    }

    private void handleResult(Result result) {

        // Capture screenshot here
        // Embed the screenshot in the report
        // You may need to use Selenium WebDriver to capture the screenshot
        // and then embed it into the report using the provided result object
    }
}

