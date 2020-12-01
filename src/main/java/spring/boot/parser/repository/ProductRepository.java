package spring.boot.parser.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.parser.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByProductId(String productId);

    @Query("SELECT r.product FROM Review r GROUP BY r.product ORDER BY COUNT (r.product) DESC ")
    List<Product> findTopProductsByReview(Pageable pageable);
}
