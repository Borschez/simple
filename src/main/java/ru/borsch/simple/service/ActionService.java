package ru.borsch.simple.service;

import ru.borsch.simple.api.Action;
import ru.borsch.simple.api.ActionContext;

import java.util.Collection;
import java.util.stream.Collectors;

public interface ActionService {
    void registerAction(Action action);

    Collection<Action> getRegisteredActions();

    default Collection<Action> getAvailableActions(ActionContext context) {
        return getRegisteredActions().stream().filter(action -> action.evaluate(context)).collect(Collectors.toUnmodifiableList());
    }

    default Boolean evaluate(Action action, ActionContext context) {
        return action.evaluate(context);
    }

    default Object execute(Action action, ActionContext context) {
        if (action.evaluate(context)) {
            return action.execute(context);
        }
        return null;
    }
}
