package spring.boot.parser.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.parser.dto.WordResponceDto;
import spring.boot.parser.mapper.WordsMapper;
import spring.boot.parser.service.WordService;

@RestController
@RequestMapping("/word")
public class WordsController {
    private final WordService wordService;
    private final WordsMapper wordsMapper;

    @Autowired
    public WordsController(WordService wordService, WordsMapper wordsMapper) {
        this.wordService = wordService;
        this.wordsMapper = wordsMapper;
    }

    @GetMapping("/popular")
    public List<WordResponceDto> getTopUsedWords(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit,
            @RequestParam(name = "sortBy", required = false, defaultValue = "count") String sortBy,
            @RequestParam(name = "sortOrder", required = false,
                    defaultValue = "desc") String sortOrder) {

        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, limit, sort);
        return wordService.findTopPopularWords(pageable)
                .stream()
                .map(wordsMapper::wordToResponceDto)
                .collect(Collectors.toList());
    }
}
