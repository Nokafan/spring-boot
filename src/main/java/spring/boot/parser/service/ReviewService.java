package spring.boot.parser.service;

import spring.boot.parser.model.Review;

public interface ReviewService extends GeneralService<Review> {
    Review getByReviewId(Long externalReviewId);
}
