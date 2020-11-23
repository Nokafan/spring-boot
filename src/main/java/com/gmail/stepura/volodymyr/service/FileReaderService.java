package com.gmail.stepura.volodymyr.service;

import com.univocity.parsers.common.record.Record;
import java.util.List;

public interface FileReaderService {
    List<Record> getRows();
}
