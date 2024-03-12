package ru.lab.workflow.task;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lab.authorization.client.*;

@Component
@ExternalTaskSubscription("register-task")
public class RegistrationTask implements ExternalTaskHandler {

    private final AuthorizationService authorizationService;

    @Autowired
    public RegistrationTask(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        String username = externalTask.getVariable("username");
        String password = externalTask.getVariable("password");
        String imagePath = externalTask.getVariable("image_path");

        RegisterUserDto user = new RegisterUserDto();
        user.setUsername(username);
        user.setPassword(password);
        user.setImagePath(imagePath);

        try {
            authorizationService.register(user);
            externalTaskService.complete(externalTask);
        } catch (UserAlreadyExistsException_Exception | InvalidUsernameException_Exception |
                 InvalidPasswordException_Exception e) {
            // externalTaskService.handleBpmnError(externalTask, "401", e.getLocalizedMessage());
            externalTaskService.complete(externalTask);
        }
    }
}
