package ru.lab.reviews.client;

import java.util.List;

public interface ReviewsService {
    void add(Review review);
    void remove(Review review);
    void removeAllByUserId(Long userId);
    List<Review> listByUserId(Long userId);
    List<Review> listByAppId(Long appId);
}
