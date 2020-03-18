package ru.borsch.simple.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.borsch.simple.model.BaseExpressionAction;
import ru.borsch.simple.service.ActionService;
import ru.borsch.simple.service.BaseExpressionActionService;
import ru.borsch.simple.service.impl.ActionContextImpl;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RestApiController {
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    private BaseExpressionActionService baseExpressionActionService;

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
}
