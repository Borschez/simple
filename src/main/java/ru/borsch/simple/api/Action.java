package ru.borsch.simple.api;

public interface Action {
    Object execute(ActionContext actionContext);
    Boolean evaluate(ActionContext actionContext);
}
