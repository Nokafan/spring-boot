package com.gmail.stepura.volodymyr.service;

import com.gmail.stepura.volodymyr.model.Review;
import java.util.List;

public interface ReviewService {
    Review save(Review review);

    Review getById(Long id);

    Review getByReviewId(Long reviewId);

    List<Review> getAll();

    List<Review> saveAll(List<Review> entities);
}
