package ru.borsch.simple.service.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.borsch.simple.service.ActionService;
import ru.borsch.simple.service.BaseExpressionActionService;

import javax.annotation.PostConstruct;

@Component
public class BaseExpressionActionBean {
    public static final Logger logger = LoggerFactory.getLogger(BaseExpressionActionBean.class);

    @Autowired
    private BaseExpressionActionService baseExpressionActionService;

    @Autowired
    private ActionService actionService;

    @PostConstruct
    public void postConstruct() {
        baseExpressionActionService.findByActive(true).forEach(action -> {
            actionService.registerAction(action);
            logger.info("Action {} registered", action );
        });
        logger.info("PostConstruct");
    }
}
