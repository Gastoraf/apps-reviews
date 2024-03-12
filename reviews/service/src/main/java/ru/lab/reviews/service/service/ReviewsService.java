package ru.lab.reviews.service.service;

import ru.lab.reviews.service.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewsService {
    void add(Review review);
    void remove(Review review);
    void removeAllByUserId(Long userId);
    List<Review> listByUserId(Long userId);
    List<Review> listByAppId(Long appId);
}
