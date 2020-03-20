package ru.borsch.simple.action;

import ru.borsch.simple.api.ExpressionAction;

public class ShowOwner implements ExpressionAction {
    public final static String EXPRESSION = "getOwner().length() > 0";
    public final static String ACTION = "getOwner()";

    public String getEvaluateExpression() {
        return EXPRESSION;
    }

    @Override
    public String getExecutionExpression() {
        return ACTION;
    }

    @Override
    public String getName() {
        return "Show Owner";
    }
}
