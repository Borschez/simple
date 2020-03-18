package ru.borsch.simple.api;

public interface ActionContext {
    default Object getData() {
        return this;
    }
}
