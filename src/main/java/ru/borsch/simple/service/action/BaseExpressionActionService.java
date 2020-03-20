package ru.borsch.simple.service.action;

import ru.borsch.simple.model.action.BaseExpressionAction;

import java.util.List;

public interface BaseExpressionActionService {
    List<BaseExpressionAction> findByName(String name);
    List<BaseExpressionAction> findByNameAndActive(String name, Boolean active);
    List<BaseExpressionAction> findAll();
    List<BaseExpressionAction> findByActive(Boolean active);
}
