package com.gmail.stepura.volodymyr.service.implementation;

import com.gmail.stepura.volodymyr.model.Product;
import com.gmail.stepura.volodymyr.repository.ProductRepository;
import com.gmail.stepura.volodymyr.service.ProductService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Product> saveAll(Set<Product> productSet) {
        return productRepository.saveAll(productSet);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public Product getByProductId(String string) {
        return productRepository.findProductByProductId(string).orElseThrow();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
