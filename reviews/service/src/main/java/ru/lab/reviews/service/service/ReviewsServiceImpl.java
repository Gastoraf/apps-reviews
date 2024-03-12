package ru.lab.reviews.service.service;

import ru.lab.reviews.service.entity.Review;
import ru.lab.reviews.service.repository.ReviewsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    private final ReviewsRepository reviewsRepository;

    @Autowired
    public ReviewsServiceImpl(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    @Override
    @Transactional
    public void add(Review review) {
        reviewsRepository.save(review);
    }

    @Override
    @Transactional
    public void remove(Review review) {
        reviewsRepository.delete(review);
    }

    @Override
    @Transactional
    public void removeAllByUserId(Long userId) {
        reviewsRepository.deleteAllByUserId(userId);
    }

    @Override
    public List<Review> listByUserId(Long userId) {
        return reviewsRepository.findAllByAppId(userId);
    }

    @Override
    public List<Review> listByAppId(Long appId) {
        return reviewsRepository.findAllByAppId(appId);
    }

}
