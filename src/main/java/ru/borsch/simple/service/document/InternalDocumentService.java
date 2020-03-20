package ru.borsch.simple.service.document;

import ru.borsch.simple.model.document.InternalDocument;

import java.util.List;

public interface InternalDocumentService extends DocumentEntityService<InternalDocument> {
    List<InternalDocument> findByExecutor(String executor);
}
