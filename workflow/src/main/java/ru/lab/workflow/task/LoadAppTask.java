package ru.lab.workflow.task;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lab.apps.client.App;
import ru.lab.apps.client.AppsService;

import java.util.Collections;

@Component
@ExternalTaskSubscription("loadapp-task")
public class LoadAppTask implements ExternalTaskHandler {

    private final AppsService appsService;

    @Autowired
    public LoadAppTask(AppsService appsService) {
        this.appsService = appsService;
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        Long appId = externalTask.getVariable("appId");

        App app = appsService.getAppById(appId);
        if (app != null) {
            externalTaskService.complete(externalTask, Collections.singletonMap("app", app));
        } else {
            externalTaskService.handleBpmnError(externalTask, "404", "not found app with id: " + appId);
        }
    }
}
