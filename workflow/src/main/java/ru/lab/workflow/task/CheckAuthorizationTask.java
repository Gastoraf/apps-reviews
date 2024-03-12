package ru.lab.workflow.task;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lab.authorization.client.*;

import java.util.Collections;

@Component
@ExternalTaskSubscription("checkauth-task")
public class CheckAuthorizationTask implements ExternalTaskHandler {

    private final AuthorizationService authorizationService;

    @Autowired
    public CheckAuthorizationTask(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        String username = externalTask.getVariable("username");
        String password = externalTask.getVariable("password");

        LoginUserDto user = new LoginUserDto();
        user.setUsername(username);
        user.setPassword(password);

        try {
            UserDto dto = authorizationService.login(user);
            externalTaskService.complete(externalTask, Collections.singletonMap("user", dto));
        } catch (InvalidPasswordException_Exception | UserNotFoundException_Exception e) {
            externalTaskService.handleBpmnError(externalTask, "401", e.getLocalizedMessage());
        }
    }
}
