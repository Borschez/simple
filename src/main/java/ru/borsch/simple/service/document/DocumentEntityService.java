package ru.borsch.simple.service.document;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.borsch.simple.model.document.DocumentEntity;

import java.util.List;
import java.util.Optional;

public interface DocumentEntityService<T extends DocumentEntity> {
    Class getDocumentTypeClass();
    String getDocumentTypeCode();
    Optional<T> findById(Long id);
    List<T> findByRegistrationNumber(String registrationNumber);
    Page<T> findByName(String name, Pageable pageable);
    List<T> findByState(String state);
    Page<T> findAll(Pageable pageable);
    T save(T entity);
}
