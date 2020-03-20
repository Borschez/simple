package ru.borsch.simple.service.impl.action;

import ru.borsch.simple.api.ActionContext;

public class ActionContextImpl implements ActionContext {
    private Object data;

    @Override
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
