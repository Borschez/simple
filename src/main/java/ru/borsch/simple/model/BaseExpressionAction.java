package ru.borsch.simple.model;

import ru.borsch.simple.api.ExpressionAction;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class BaseExpressionAction extends BaseActionEntity implements ExpressionAction {
    @Column(length = 1024)
    private String evaluateExpression;
    @Column(length = 1024)
    private String executionExpression;

    @Override
    public String getEvaluateExpression() {
        return evaluateExpression;
    }

    public void setEvaluateExpression(String evaluateExpression) {
        this.evaluateExpression = evaluateExpression;
    }

    @Override
    public String getExecutionExpression() {
        return executionExpression;
    }

    public void setExecutionExpression(String executionExpression) {
        this.executionExpression = executionExpression;
    }
}
