package spring.boot.parser.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.parser.dto.ProductResponseDto;
import spring.boot.parser.mapper.ProductMapper;
import spring.boot.parser.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductsController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductsController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/popular")
    public List<ProductResponseDto> getTopCommentedProducts(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit) {
        Pageable topProducts = PageRequest.of(page, limit);
        return productService.findTopProductsByReview(topProducts)
                .stream()
                .map(productMapper::productToResponseDto)
                .collect(Collectors.toList());
    }
}
