package ru.borsch.simple.service.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.borsch.simple.action.document.Promote;
import ru.borsch.simple.service.action.ActionService;
import ru.borsch.simple.service.action.BaseExpressionActionService;
import ru.borsch.simple.service.document.DocumentService;
import ru.borsch.simple.service.document.IncomingDocumentService;
import ru.borsch.simple.service.document.InternalDocumentService;

import javax.annotation.PostConstruct;

@Component
public class InitializationBean {
    public static final Logger logger = LoggerFactory.getLogger(InitializationBean.class);

    @Autowired
    private BaseExpressionActionService baseExpressionActionService;

    @Autowired
    private ActionService actionService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private IncomingDocumentService incomingDocumentService;

    @Autowired
    private InternalDocumentService internalDocumentService;

    @Autowired
    private Promote promoteAction;

    @PostConstruct
    public void postConstruct() {
        baseExpressionActionService.findByActive(true).forEach(action -> {
            actionService.registerAction(action);
            logger.info("Action {} registered", action );
        });

        actionService.registerAction(promoteAction);

        documentService.registerService(incomingDocumentService);
        documentService.registerService(internalDocumentService);

        logger.info("PostConstruct");
    }
}
