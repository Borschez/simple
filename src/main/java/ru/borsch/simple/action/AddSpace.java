package ru.borsch.simple.action;

import ru.borsch.simple.api.ActionContext;
import ru.borsch.simple.api.ExpressionAction;

public class AddSpace implements ExpressionAction {
    public final static String EXPRESSION = "getModifiedString().length() > 0";


    public String getEvaluateExpression() {
        return EXPRESSION;
    }

    @Override
    public String getExecutionExpression() {
        return null;
    }

    @Override
    public Object execute(ActionContext context) {
        return null;
    }

    @Override
    public Boolean evaluate(ActionContext actionContext) {
        return false;
    }
}
