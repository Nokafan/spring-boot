package spring.boot.parser.service;

import spring.boot.parser.model.Product;

public interface ProductService extends GeneralService<Product> {
    Product getByProductId(String externalProductId);
}
