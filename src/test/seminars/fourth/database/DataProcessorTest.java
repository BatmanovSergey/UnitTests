package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class DataProcessorTest {
    @Test
    void testDataProcessor() {
        Database db = mock(Database.class);
        DataProcessor dP = new DataProcessor(db);
        when(db.query(anyString())).thenReturn(Arrays.asList("строка1", "строка2"));

        List<String> result = dP.processData("строка");

        verify(db).query("строка");
        assertThat(result).isNotEmpty().hasSize(2).isEqualTo(Arrays.asList("строка1", "строка2"));

    }

}