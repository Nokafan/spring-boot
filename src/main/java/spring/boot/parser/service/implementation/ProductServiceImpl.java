package spring.boot.parser.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.boot.parser.model.Product;
import spring.boot.parser.repository.ProductRepository;
import spring.boot.parser.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveAll(Iterable<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public Product getByProductId(String externalProductId) {
        return productRepository.findProductByProductId(externalProductId).orElseThrow();
    }

    @Override
    public List<Product> findTopProductsByReview(Pageable pageable) {
        return productRepository.findTopProductsByReview(pageable);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
