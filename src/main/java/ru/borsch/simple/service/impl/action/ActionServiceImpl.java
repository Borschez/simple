package ru.borsch.simple.service.impl.action;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.borsch.simple.api.Action;
import ru.borsch.simple.service.action.ActionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("actionService")
@Transactional
public class ActionServiceImpl implements ActionService {
    private List<Action> registeredActions;

    public ActionServiceImpl() {
        this.registeredActions = new ArrayList<>();
    }

    @Override
    public void registerAction(Action action) {
        this.registeredActions.add(action);
    }

    @Override
    public Collection<Action> getRegisteredActions() {
        return this.registeredActions;
    }
}
