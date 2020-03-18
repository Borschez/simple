package ru.borsch.simple.action;

import ru.borsch.simple.api.ExpressionAction;

public class ShowCarl implements ExpressionAction {
    public final static String EXPRESSION = "\"Carl\".equals(getOwner())";
    public final static String ACTION = "getOwner()";

    public String getEvaluateExpression() {
        return EXPRESSION;
    }

    @Override
    public String getExecutionExpression() {
        return ACTION;
    }
}
