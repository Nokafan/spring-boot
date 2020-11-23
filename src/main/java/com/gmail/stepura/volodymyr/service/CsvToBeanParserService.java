package com.gmail.stepura.volodymyr.service;

import com.univocity.parsers.common.record.Record;
import java.io.IOException;
import java.util.List;

public interface CsvToBeanParserService {
    void saveBeans(List<Record> strings) throws IOException;
}
