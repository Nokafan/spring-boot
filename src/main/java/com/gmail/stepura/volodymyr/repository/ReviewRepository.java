package com.gmail.stepura.volodymyr.repository;

import com.gmail.stepura.volodymyr.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findReviewByReviewId(Long reviewId);
}
