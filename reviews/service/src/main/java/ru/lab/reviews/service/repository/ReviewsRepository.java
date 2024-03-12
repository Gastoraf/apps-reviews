package ru.lab.reviews.service.repository;

import ru.lab.reviews.service.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByUserId(Long userId);
    List<Review> findAllByAppId(Long appId);
    void deleteAllByUserId(Long userId);
}
