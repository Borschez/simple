package ru.borsch.simple.service.document;

import ru.borsch.simple.api.ActionContext;
import ru.borsch.simple.model.document.DocumentEntity;

public interface DocumentService {

    String getDocumentTypeCode();
    String getDocumentIdCode();

    void registerService(DocumentEntityService documentEntityService);

    DocumentEntityService getServiceByDocumentType(String documentType);

    DocumentEntity getDocumentEntityFromContext(ActionContext actionContext);

    DocumentEntityService getServiceByContext(ActionContext actionContext);
}
