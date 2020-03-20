package ru.borsch.simple.service.document;

import ru.borsch.simple.model.document.IncomingDocument;

import java.util.List;

public interface IncomingDocumentService extends DocumentEntityService<IncomingDocument> {
    List<IncomingDocument> findByAddressee(String addressee);
}
