package spring.boot.parser.service.implementation;

import com.univocity.parsers.common.DataProcessingException;
import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.RetryableErrorHandler;
import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring.boot.parser.service.RecordToDatabaseService;

@Log4j
@Service
public class RecordToDatabaseServiceImpl implements RecordToDatabaseService {
    @Value("${input.file.path}")
    private String fileName;

    @Override
    public List<Record> getRecords() {
        log.info("Starting to build parser at getRows() method");
        CsvParser parser = new CsvParser(getCsvParserSettings());
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {
            return parser.parseAllRecords(bufferedReader);
        } catch (IOException e) {
            throw new RuntimeException("File not found! " + fileName);
        }
    }

    private CsvParserSettings getCsvParserSettings() {
        CsvParserSettings parserSettings = new CsvParserSettings();
        parserSettings.setLineSeparatorDetectionEnabled(true);
        parserSettings.setNullValue("null");
        parserSettings.setEmptyValue("");
        parserSettings.setDelimiterDetectionEnabled(true);
        parserSettings.setIgnoreLeadingWhitespaces(true);
        parserSettings.setQuoteDetectionEnabled(true);
        parserSettings.setSkipEmptyLines(true);
        parserSettings.setHeaderExtractionEnabled(true);
        parserSettings.setMaxCharsPerColumn(25000);
        parserSettings.setIgnoreTrailingWhitespacesInQuotes(true);
        parserSettings.setReadInputOnSeparateThread(true);
        parserSettings.setErrorContentLength(10);
        parserSettings.setAutoConfigurationEnabled(true);
        parserSettings.setHeaderExtractionEnabled(true);
        parserSettings.setProcessorErrorHandler(new RetryableErrorHandler<ParsingContext>() {
            @Override
            public void handleError(DataProcessingException error,
                                    Object[] inputRow, ParsingContext context) {
                System.out.println("Error processing row: " + Arrays.toString(inputRow));
                System.out.println("Error details: column '" + error.getColumnName()
                        + "' (index " + error.getColumnIndex() + ") has value '"
                        + inputRow[error.getColumnIndex()] + "'. Setting it to null");

                if (error.getColumnIndex() == 0) {
                    setDefaultValue(null);
                } else {
                    keepRecord();
                }
            }
        });
        RowListProcessor rowProcessor = new RowListProcessor();
        parserSettings.setProcessor(rowProcessor);
        return parserSettings;
    }
}
