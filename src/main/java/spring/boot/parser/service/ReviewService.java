package spring.boot.parser.service;

import java.util.List;
import spring.boot.parser.model.Review;

public interface ReviewService {
    Review save(Review review);

    Review getById(Long id);

    Review getByReviewId(Long externalReviewId);

    List<Review> getAll();

    List<Review> saveAll(List<Review> reviews);
}
