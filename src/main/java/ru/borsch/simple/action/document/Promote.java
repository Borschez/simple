package ru.borsch.simple.action.document;

import ru.borsch.simple.api.Action;
import ru.borsch.simple.api.ActionContext;

import java.util.Map;

public class Promote implements Action {
    @Override
    public String getName() {
        return "promote";
    }

    @Override
    public Object execute(ActionContext actionContext) {
        return null;
    }

    @Override
    public Boolean evaluate(ActionContext actionContext) {
        if (actionContext.getData() instanceof Map) {
            Map contextData = (Map) actionContext.getData();
            //contextData.get("state") != ""
        }
        return false;
    }
}
