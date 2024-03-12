package ru.lab.workflow.task;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.lab.apps.client.App;
import ru.lab.authorization.client.UserDto;
import ru.lab.reviews.client.Review;
import ru.lab.reviews.client.ReviewsService;

@Component
@ExternalTaskSubscription("writereview-task")
public class WriteReviewTask implements ExternalTaskHandler {

    private final ReviewsService reviewsService;

    @Autowired
    public WriteReviewTask(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        App app = externalTask.getVariable("app");
        UserDto user = externalTask.getVariable("user");
        Long rating = externalTask.getVariable("rating");
        String content = externalTask.getVariable("content");

        Review review = new Review();
        review.setUserId(user.getId());
        review.setAppId(app.getId());
        review.setRating(Math.toIntExact(rating));
        review.setContent(content);

        reviewsService.add(review);
        externalTaskService.complete(externalTask);
    }
}
