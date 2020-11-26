package spring.boot.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.parser.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findReviewByReviewId(Long reviewId);
}
