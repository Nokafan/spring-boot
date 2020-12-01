package spring.boot.parser.mapper;

import org.springframework.stereotype.Component;
import spring.boot.parser.dto.ProductResponseDto;
import spring.boot.parser.model.Product;

@Component
public class ProductMapper {
    public ProductResponseDto productToResponseDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .productId(product.getProductId())
                .build();
    }
}
