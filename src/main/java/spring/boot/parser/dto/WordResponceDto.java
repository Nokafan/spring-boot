package spring.boot.parser.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WordResponceDto {
    private String word;
    private Long count;
}
