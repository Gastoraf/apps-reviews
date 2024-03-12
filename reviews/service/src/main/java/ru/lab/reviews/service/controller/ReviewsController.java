package ru.lab.reviews.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import ru.lab.reviews.service.entity.Review;
import ru.lab.reviews.service.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    private final ReviewsService reviewsService;

    @Autowired
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping
    public List<Review> listReviews(@RequestParam(required = false) Long userId, @RequestParam(required = false) Long appId) {
        if (userId != null) {
            return reviewsService.listByUserId(userId);
        } else if (appId != null) {
            return reviewsService.listByAppId(appId);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Необходимо указать либо userId, либо appId");
        }
    }

    @PostMapping("/add")
    public void add(@RequestBody Review cart) {
        reviewsService.add(cart);
    }

    @PostMapping("/remove")
    public void remove(@RequestBody Review cart) {
        reviewsService.remove(cart);
    }

    @PostMapping("/removeAll")
    public void removeAllByUser(@RequestParam Long id) {
        reviewsService.removeAllByUserId(id);
    }

}