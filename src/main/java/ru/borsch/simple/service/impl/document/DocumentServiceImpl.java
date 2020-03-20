package ru.borsch.simple.service.impl.document;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.borsch.simple.service.document.DocumentEntityService;
import ru.borsch.simple.service.document.DocumentService;

import java.util.ArrayList;
import java.util.List;

@Service("documentService")
@Transactional
public class DocumentServiceImpl implements DocumentService {
    private List<DocumentEntityService> registeredService;

    public DocumentServiceImpl() {
        this.registeredService = new ArrayList<>();
    }

    public List<DocumentEntityService> getRegisteredService() {
        return registeredService;
    }

    @Override
    public void registerService(DocumentEntityService documentEntityService) {
        this.registeredService.add(documentEntityService);
    }

    @Override
    public DocumentEntityService getServiceByDocumentType(String documentType) {
        return registeredService.stream().filter(service -> documentType.equals(service.getDocumentTypeCode())).findFirst().orElse(null);
    }
}
