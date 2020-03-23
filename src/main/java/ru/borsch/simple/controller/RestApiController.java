package ru.borsch.simple.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.borsch.simple.api.Action;
import ru.borsch.simple.model.action.BaseExpressionAction;
import ru.borsch.simple.model.document.DocumentEntity;
import ru.borsch.simple.service.action.ActionService;
import ru.borsch.simple.service.action.BaseExpressionActionService;
import ru.borsch.simple.service.document.DocumentEntityService;
import ru.borsch.simple.service.document.DocumentService;
import ru.borsch.simple.service.impl.action.ActionContextImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RestApiController {
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    private BaseExpressionActionService baseExpressionActionService;

    @Autowired
    DocumentService documentService;

    @Autowired
    private ActionService actionService;

    @RequestMapping(value = "/baseactions", method = RequestMethod.GET)
    public ResponseEntity<List<BaseExpressionAction>> getAllBaseActions() {
        logger.info("Fetching All Base Actions");
        List<BaseExpressionAction> baseActions = baseExpressionActionService.findAll();
        if (baseActions.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(baseActions, HttpStatus.OK);
    }

    @RequestMapping(value = "/baseaction/{name}/execute", method = RequestMethod.POST)
    public ResponseEntity<Object> baseActionExecute(@PathVariable("name") String name, @RequestBody ActionContextImpl context) {
        logger.info("Executing {} base action", name);

        List<BaseExpressionAction> actions = baseExpressionActionService.findByNameAndActive(name, true);
        if (actions.isEmpty()) {
            logger.error("Unable to find action with name {}", name);
            return new ResponseEntity(String.format("Unable to find action with name %s", name),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(actionService.execute(actions.get(0), context),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/document/action/{name}/execute", method = RequestMethod.POST)
    public ResponseEntity<Object> documentActionExecute(@PathVariable("name") String name, @RequestBody ActionContextImpl context) {
        logger.info("Executing {} document action", name);

        List<Action> actions = actionService.getAvailableActions(context).stream()
                .filter(action -> name.equals(action.getName()))
                .collect(Collectors.toList());

        if (actions.isEmpty()) {
            logger.error("Unable to find available action with name {}", name);
            return new ResponseEntity(String.format("Unable to find available action with name %s", name),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(actions.get(0).execute(context),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/documents/{type}", method = RequestMethod.GET)
    public ResponseEntity<DocumentEntity> getDocumentsByType(@PathVariable("type") String type) {
        logger.info("Fetching Documents by Type {}", type);

        DocumentEntityService entityService = documentService.getServiceByDocumentType(type);
        if (entityService != null) {
            return new ResponseEntity(entityService.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
