package ru.borsch.simple.subject;

import ru.borsch.simple.api.ActionContext;

import java.util.HashMap;
import java.util.Map;

public class DefaultActionContext implements ActionContext {
    Map<String, Object> contextData;

    public DefaultActionContext() {
        this.contextData = new HashMap<>();
    }

    public void addContextData(String key, Object value) {
        contextData.put(key, value);
    }
}
