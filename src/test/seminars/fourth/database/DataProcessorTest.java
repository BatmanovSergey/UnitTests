package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class DataProcessorTest {

    //4.6.
   /* Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
            Условие: У вас есть класс Database с методом public List<String> query(String sql),
            который выполняет SQLзапрос и возвращает результат.
    Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
    выполнения запроса и обработки результатов.
*/

    @Test
    void testDataProcessor() {
        Database db = mock(Database.class);
        DataProcessor dP = new DataProcessor(db);
        when(db.query(anyString())).thenReturn(Arrays.asList("строка1", "строка2"));
    //  anyString() - означает, что метод принимает любые строки
        List<String> result = dP.processData("строка");

        verify(db).query("строка");
        verify(db).query(anyString()); // сравнивает результат при любой строке в вызове метода выше
        assertThat(result).isNotEmpty().hasSize(2).isEqualTo(Arrays.asList("строка1", "строка2"));

    }

}