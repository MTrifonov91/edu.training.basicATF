package org.example.project.configurations.scenario_context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String, Object> context;

    public ScenarioContext() {
        context = new HashMap<>();
    }

    public <T> T getContext(String key, Class<T> type) {
        return type.cast(context.get(key));
    }

    public void setContext(String key, Object value) {
        context.put(key, value);
    }
}
