package spring.boot.parser.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.boot.parser.model.Word;
import spring.boot.parser.repository.WordRepository;
import spring.boot.parser.service.WordService;

@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public Word save(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public List<Word> saveAll(Iterable<Word> words) {
        return wordRepository.saveAll(words);
    }

    @Override
    public Word getById(Long id) {
        return wordRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Word> getAll() {
        return wordRepository.findAll();
    }

    @Override
    public List<Word> findTopPopularWords(Pageable pageable) {
        return wordRepository.findAll(pageable).getContent();
    }
}
