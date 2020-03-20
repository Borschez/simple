package ru.borsch.simple.repository.document;

import ru.borsch.simple.model.document.InternalDocument;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface InternalDocumentRepository extends DocumentEntityRepository<InternalDocument> {
    List<InternalDocument> findByExecutor(String executor);
}
