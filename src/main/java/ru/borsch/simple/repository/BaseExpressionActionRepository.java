package ru.borsch.simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.borsch.simple.model.BaseExpressionAction;

import java.util.List;

public interface BaseExpressionActionRepository extends JpaRepository<BaseExpressionAction, Long> {
    List<BaseExpressionAction> findByName(String name);
    List<BaseExpressionAction> findByNameAndActive(String name, Boolean active);
    List<BaseExpressionAction> findByActive(Boolean active);
}
