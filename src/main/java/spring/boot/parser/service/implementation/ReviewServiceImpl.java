package spring.boot.parser.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.parser.model.Review;
import spring.boot.parser.repository.ReviewRepository;
import spring.boot.parser.service.ReviewService;

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
    public List<Review> saveAll(Iterable<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }

    @Override
    public Review getById(Long id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    @Override
    public Review getByReviewId(Long externalReviewId) {
        return reviewRepository.findReviewByReviewId(externalReviewId);
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }
}
