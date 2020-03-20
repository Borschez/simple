package ru.borsch.simple.repository.document;

import ru.borsch.simple.model.document.IncomingDocument;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IncomingDocumentRepository extends DocumentEntityRepository<IncomingDocument> {
    List<IncomingDocument> findByAddressee(String addressee);
}
