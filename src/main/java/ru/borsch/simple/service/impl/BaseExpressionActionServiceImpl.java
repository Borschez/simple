package ru.borsch.simple.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.borsch.simple.model.BaseExpressionAction;
import ru.borsch.simple.repository.BaseExpressionActionRepository;
import ru.borsch.simple.service.BaseExpressionActionService;

import javax.transaction.Transactional;
import java.util.List;

@Service("baseExpressionActionService")
@Transactional
public class BaseExpressionActionServiceImpl implements BaseExpressionActionService {

    @Autowired
    private BaseExpressionActionRepository baseExpressionActionRepository;

    @Override
    public List<BaseExpressionAction> findByName(String name) {
        return baseExpressionActionRepository.findByName(name);
    }

    @Override
    public List<BaseExpressionAction> findByNameAndActive(String name, Boolean active) {
        return baseExpressionActionRepository.findByNameAndActive(name, active);
    }

    @Override
    public List<BaseExpressionAction> findAll() {
        return baseExpressionActionRepository.findAll();
    }

    @Override
    public List<BaseExpressionAction> findByActive(Boolean active) {
        return baseExpressionActionRepository.findByActive(active);
    }
}
