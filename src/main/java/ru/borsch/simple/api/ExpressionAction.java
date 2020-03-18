package ru.borsch.simple.api;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public interface ExpressionAction extends Action {
    ExpressionParser parser = new SpelExpressionParser();

    String getEvaluateExpression();
    String getExecutionExpression();

    default Object execute(ActionContext actionContext) {
        try {
            Expression exp = parser.parseExpression(this.getExecutionExpression());
            return exp.getValue(actionContext.getData());
        } catch (SpelEvaluationException ex) {
            return null;
        }
    }

    default Boolean evaluate(ActionContext actionContext) {
        try {
            Expression exp = parser.parseExpression(this.getEvaluateExpression());
            return exp.getValue(actionContext.getData(), Boolean.class);
        } catch (SpelEvaluationException ex) {
            return false;
        }
    }
}
