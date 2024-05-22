package org.example.project.configurations.scenario_context;

import io.restassured.response.Response;
import org.example.project.api.dtos.DTO;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private static Context instance;
    private Map<ContextKeys, Object> context;

    private Context() {
        instance = this;
        context = new HashMap<>();
    }

    public static Context getInstance() {
        if (instance == null) {
            new Context();
        }
        return instance;
    }

    public static void tearDown() {
        if (instance != null) {
            instance.context.clear();
        }
    }

    public <T> T getContext(ContextKeys key, Class<T> type) {
        return type.cast(context.get(key));
    }
    public void setContext(ContextKeys key, Object value) {
        context.put(key, value);
    }

    public enum ContextKeys {
        DRIVER,
        RESPONSE,
        DTO
    }

}
