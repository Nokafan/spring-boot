package spring.boot.parser.mapper;

import org.springframework.stereotype.Component;
import spring.boot.parser.dto.WordResponceDto;
import spring.boot.parser.model.Word;

@Component
public class WordsMapper {
    public WordResponceDto wordToResponceDto(Word word) {
        return WordResponceDto.builder()
                .word(word.getWord())
                .count(word.getCount())
                .build();
    }
}
