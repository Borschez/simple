package ru.borsch.simple.action;

import ru.borsch.simple.api.ActionContext;
import ru.borsch.simple.api.ExpressionAction;

import java.util.Map;

public class AddContextString implements ExpressionAction {
    public final static String EXPRESSION = "getData().get('base_string') != null AND getData().get('context_string') != null";
    public final static String CONTEXT_DATA = "context_string";
    public final static String BASE_DATA = "base_string";

    @Override
    public String getEvaluateExpression() {
        return EXPRESSION;
    }

    @Override
    public String getExecutionExpression() {
        return null;
    }

    @Override
    public Object execute(ActionContext context) {
        if (context instanceof Map) {
            String baseString = (String) ((Map) context).get(BASE_DATA);
            String contextString = (String) ((Map) context).get(CONTEXT_DATA);
            return String.join(" ", baseString, contextString);
        }
        return null;
    }
}
