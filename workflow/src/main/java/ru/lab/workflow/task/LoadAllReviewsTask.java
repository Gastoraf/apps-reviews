package ru.lab.workflow.task;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lab.reviews.client.ReviewsService;

import java.util.Collections;

@Component
@ExternalTaskSubscription("loadreviews-task")
public class LoadAllReviewsTask implements ExternalTaskHandler {

    private final ReviewsService reviewsService;

    @Autowired
    public LoadAllReviewsTask(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        Long appId = externalTask.getVariable("appId");
        externalTaskService.complete(externalTask, Collections.singletonMap("reviews", reviewsService.listByAppId(appId)));
    }
}
