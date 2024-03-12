package ru.lab.workflow.task;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lab.apps.client.AppsService;

import java.util.Collections;

@Component
@ExternalTaskSubscription("loadapps-task")
public class LoadAllAppsTask implements ExternalTaskHandler {

    private final AppsService appsService;

    @Autowired
    public LoadAllAppsTask(AppsService appsService) {
        this.appsService = appsService;
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        externalTaskService.complete(externalTask, Collections.singletonMap("apps", appsService.getAllApps()));
    }
}
