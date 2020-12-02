package spring.boot.parser.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import spring.boot.parser.model.Word;

public interface WordService extends GeneralService<Word> {
    List<Word> findTopPopularWords(Pageable pageable);
}
