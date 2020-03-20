package ru.borsch.simple.repository.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.borsch.simple.model.document.DocumentEntity;

import java.util.List;

@NoRepositoryBean
public interface DocumentEntityRepository<T extends DocumentEntity> extends JpaRepository<T , Long> {
    List<T> findByRegistrationNumber(String registrationNumber);
    List<T> findByName(String name);
    List<T> findByState(String state);
}
