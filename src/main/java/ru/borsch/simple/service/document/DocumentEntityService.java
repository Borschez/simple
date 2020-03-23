package ru.borsch.simple.service.document;

import ru.borsch.simple.model.document.DocumentEntity;

import java.util.List;
import java.util.Optional;

public interface DocumentEntityService<T extends DocumentEntity> {
    String getDocumentTypeCode();
    Optional<T> findById(Long id);
    List<T> findByRegistrationNumber(String registrationNumber);
    List<T> findByName(String name);
    List<T> findByState(String state);
    List<T> findAll();
    T save(T entity);
}
