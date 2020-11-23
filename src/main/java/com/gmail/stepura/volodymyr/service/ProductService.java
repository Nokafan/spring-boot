package com.gmail.stepura.volodymyr.service;

import com.gmail.stepura.volodymyr.model.Product;
import java.util.List;
import java.util.Set;

public interface ProductService {
    Product save(Product user);

    List<Product> saveAll(Set<Product> productSet);

    Product getById(Long id);

    Product getByProductId(String string);

    List<Product> getAll();
}
