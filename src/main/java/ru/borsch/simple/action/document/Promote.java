package ru.borsch.simple.action.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.borsch.simple.api.Action;
import ru.borsch.simple.api.ActionContext;
import ru.borsch.simple.model.document.DocumentEntity;
import ru.borsch.simple.service.document.DocumentEntityService;
import ru.borsch.simple.service.document.DocumentService;

@Component
public class Promote implements Action {

    @Autowired
    DocumentService documentService;

    @Override
    public String getName() {
        return "promote";
    }

    @Override
    public Object execute(ActionContext actionContext) {
        DocumentEntity documentEntity = documentService.getDocumentEntityFromContext(actionContext);
        documentEntity.setState("execute");

        DocumentEntityService entityService = documentService.getServiceByContext(actionContext);
        return entityService.save(documentEntity);
    }

    @Override
    public Boolean evaluate(ActionContext actionContext) {
        DocumentEntity documentEntity = documentService.getDocumentEntityFromContext(actionContext);
        if (!"execute".equals(documentEntity.getState())) return true;
        return false;
    }
}
