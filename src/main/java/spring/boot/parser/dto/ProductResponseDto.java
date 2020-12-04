package spring.boot.parser.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductResponseDto {
    private Long id;
    private String productId;
}
