package ru.borsch.simple.service;

import ru.borsch.simple.model.BaseExpressionAction;

import java.util.List;

public interface BaseExpressionActionService {
    List<BaseExpressionAction> findByName(String name);
    List<BaseExpressionAction> findByNameAndActive(String name, Boolean active);
    List<BaseExpressionAction> findAll();
    List<BaseExpressionAction> findByActive(Boolean active);
}
