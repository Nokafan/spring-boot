package spring.boot.parser.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import spring.boot.parser.model.Product;

public interface ProductService extends GeneralService<Product> {
    Product getByProductId(String externalProductId);

    List<Product> findTopProductsByReview(Pageable pageable);
}
