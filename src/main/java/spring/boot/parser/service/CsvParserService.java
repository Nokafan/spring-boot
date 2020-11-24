package spring.boot.parser.service;

import com.univocity.parsers.common.record.Record;
import java.util.List;

public interface CsvParserService {
    List<Record> getRecords();
}
