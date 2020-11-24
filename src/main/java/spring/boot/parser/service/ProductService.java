package spring.boot.parser.service;

import java.util.List;
import java.util.Set;
import spring.boot.parser.model.Product;

public interface ProductService {
    Product save(Product product);

    List<Product> saveAll(Set<Product> products);

    Product getById(Long id);

    Product getByProductId(String externalProductId);

    List<Product> getAll();
}
