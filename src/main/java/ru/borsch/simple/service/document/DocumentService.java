package ru.borsch.simple.service.document;

public interface DocumentService {
    void registerService(DocumentEntityService documentEntityService);

    DocumentEntityService getServiceByDocumentType(String documentType);
}
