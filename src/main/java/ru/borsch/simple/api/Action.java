package ru.borsch.simple.api;

public interface Action {
    String getName();
    Object execute(ActionContext actionContext);
    Boolean evaluate(ActionContext actionContext);
}
