package com.gmail.stepura.volodymyr.service.implementation;

import com.gmail.stepura.volodymyr.model.Review;
import com.gmail.stepura.volodymyr.repository.ReviewRepository;
import com.gmail.stepura.volodymyr.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review getById(Long id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    @Override
    public Review getByReviewId(Long reviewId) {
        return reviewRepository.findReviewByReviewId(reviewId);
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> saveAll(List<Review> entities) {
        return reviewRepository.saveAll(entities);
    }
}
