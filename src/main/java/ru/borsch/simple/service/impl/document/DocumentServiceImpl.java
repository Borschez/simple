package ru.borsch.simple.service.impl.document;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.borsch.simple.api.ActionContext;
import ru.borsch.simple.model.document.DocumentEntity;
import ru.borsch.simple.service.document.DocumentEntityService;
import ru.borsch.simple.service.document.DocumentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("documentService")
@Transactional
public class DocumentServiceImpl implements DocumentService {

    @Value("${document.service.type.code}")
    private String documentTypeCode;

    @Value("${document.service.id.code}")
    private String documentIdCode;

    private List<DocumentEntityService> registeredService;

    public DocumentServiceImpl() {
        this.registeredService = new ArrayList<>();
    }

    @Override
    public String getDocumentTypeCode() {
        return this.documentTypeCode;
    }

    @Override
    public String getDocumentIdCode() {
        return this.documentIdCode;
    }

    @Override
    public void registerService(DocumentEntityService documentEntityService) {
        this.registeredService.add(documentEntityService);
    }

    @Override
    public DocumentEntityService getServiceByDocumentType(String documentType) {
        return registeredService.stream().filter(service -> documentType.equals(service.getDocumentTypeCode())).findFirst().orElse(null);
    }

    @Override
    public DocumentEntity getDocumentEntityFromContext(ActionContext actionContext) {
        if (actionContext.getData() instanceof Map) {
            Map contextData = (Map) actionContext.getData();
            if (contextData.get(getDocumentTypeCode()) != null && contextData.get(getDocumentIdCode()) != null) {
                String docType = (String) contextData.get(getDocumentTypeCode());
                Long docId = ((Number) contextData.get(getDocumentIdCode())).longValue();
                DocumentEntityService service = getServiceByDocumentType(docType);
                if (service != null) {
                    Object entity = service.findById(docId).orElse(null);
                    return (entity != null) ? (DocumentEntity) entity : null;
                }
            }
        }
        return null;
    }

    @Override
    public DocumentEntityService getServiceByContext(ActionContext actionContext) {
        if (actionContext.getData() instanceof Map) {
            Map contextData = (Map) actionContext.getData();
            if (contextData.get(getDocumentTypeCode()) != null && contextData.get(getDocumentIdCode()) != null) {
                String docType = (String) contextData.get(getDocumentTypeCode());
                return getServiceByDocumentType(docType);
            }
        }
        return null;
    }
}
