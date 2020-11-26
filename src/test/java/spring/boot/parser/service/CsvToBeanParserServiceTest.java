package spring.boot.parser.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.univocity.parsers.common.record.Record;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CsvToBeanParserServiceTest {
    public static final String FILE_EMPTY = "src/test/resources/test_file_empty.csv";
    private static final String FILE_NOT_EXIST = "src/test/resources/file_not_exist.csv";
    private static final String FILE_DATA_OK = "src/test/resources/test_file_ok.csv";
    private static final int TEN = 10;
    private static final int ZERO = 0;
    private static final String RECORD_SUMMARY = "Absolutely wonderful";
    private static final String RECORD_TEXT =
            "A family favorite.  These are really unique treats.  "
            + "The wonderful taste of flowers.  The violet and rose are great.  "
            + "Orange blossom wasn't to my liking.  "
            + "The company that makes them have been around for hundreds of years.  "
            + "They are made in a small French town that was featured "
            + "in a movie called \"Chocolat.\"";
    private static final Long RECORD_TIME = 1313539200L;
    private static final Long RECORD_SCORE = 5L;
    private static final Long RECORD_DENOMINATOR = 2L;
    private static final Long RECORD_NUMERATOR = 2L;
    private static final String RECORD_PROFILE_NAME = "Howard M.";
    private static final String RECORD_USER_ID = "ABWUZU0SCL5PW";
    private static final String RECORD_PRODUCT_ID = "B001FQ0UEE";
    private static final Long RECORD_ID = 1965L;
    private static final String ID = "Id";
    private static final String PRODUCT_ID = "ProductId";
    private static final String USER_ID = "UserId";
    private static final String PROFILE_NAME = "ProfileName";
    private static final String HELPFULNESS_NUMERATOR = "HelpfulnessNumerator";
    private static final String HELPFULNESS_DENOMINATOR = "HelpfulnessDenominator";
    private static final String SCORE = "Score";
    private static final String TIME = "Time";
    private static final String SUMMARY = "Summary";
    private static final String TEXT = "Text";

    @Autowired
    private CsvToBeanParserService csvToBeanParserService;

    @Test
    public void getRecords_Ok() {
        List<Record> records = csvToBeanParserService.getRecords(FILE_DATA_OK);
        assertEquals(TEN, records.size());
    }

    @Test
    public void getException_Ok() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            List<Record> records = csvToBeanParserService.getRecords(FILE_NOT_EXIST);
        });
        String expectedMessage = "File not found! " + FILE_NOT_EXIST;
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void readEmptyFile_Ok() {
        List<Record> records = csvToBeanParserService.getRecords(FILE_EMPTY);
        assertEquals(ZERO, records.size());
    }

    @Test
    public void checkFirstRecord_Ok() {
        List<Record> records = csvToBeanParserService.getRecords(FILE_DATA_OK);
        Record record = records.get(ZERO);
        assertEquals(RECORD_ID, record.getLong(ID));
        assertEquals(RECORD_PRODUCT_ID, record.getString(PRODUCT_ID));
        assertEquals(RECORD_USER_ID, record.getString(USER_ID));
        assertEquals(RECORD_PROFILE_NAME, record.getString(PROFILE_NAME));
        assertEquals(RECORD_NUMERATOR, record.getLong(HELPFULNESS_NUMERATOR));
        assertEquals(RECORD_DENOMINATOR, record.getLong(HELPFULNESS_DENOMINATOR));
        assertEquals(RECORD_SCORE, record.getLong(SCORE));
        assertEquals(RECORD_TIME, record.getLong(TIME));
        assertEquals(RECORD_SUMMARY, record.getString(SUMMARY));
        assertEquals(RECORD_TEXT, record.getString(TEXT));
    }
}
