package spring.boot.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.parser.model.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
}
