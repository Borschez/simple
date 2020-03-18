package ru.borsch.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        /*ActionService actionService = new ActionServiceImpl();
        actionService.registerAction(new AddSpace());
        actionService.registerAction(new AddContextString());
        actionService.registerAction(new ShowCarl());
        actionService.registerAction(new ShowOwner());

        DefaultActionContext context = new DefaultActionContext();
        context.addContextData("base_string", "Base_String");
        context.addContextData("context_string", "Added_String");

        OwnerString ownerContext = new OwnerString("Carl");

        Collection<Action> actions = actionService.getAvailableActions(context);
        actions.stream().forEach(action -> {
            System.out.println(action.execute(context));
            return;
        });

        actions = actionService.getAvailableActions(ownerContext);
        actions.stream().forEach(action -> {
            System.out.println(action.execute(ownerContext));
            return;
        });
        ownerContext.setOwner("Craig");
        actions = actionService.getAvailableActions(ownerContext);
        actions.stream().forEach(action -> {
            System.out.println(action.execute(ownerContext));
            return;
        });*/

        SpringApplication.run(Main.class, args);
    }
}
