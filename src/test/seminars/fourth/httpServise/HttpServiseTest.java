package seminars.fourth.httpServise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class HttpServiseTest {
    //4.7.
    /*Вам нужно написать тест с использованием моков для класса, который выполняет HTTP-запросы.
            Условие: У вас есть класс HttpClient с методом public String get(String url), который выполняет
    HTTP-запрос и возвращает результат. Вам необходимо проверить правильность работы класса
    WebService, который использует HttpClient для получения данных с веб-сайта.*/
    @Test
    void httpRequestTest() {
        HttpClient httpClient = mock(HttpClient.class);
        WebService webService = new WebService(httpClient);
        when(httpClient.getHTTPRequest(anyString())).thenReturn("This is our Site");

        String check = webService.getHttp("Request");

        verify(httpClient).getHTTPRequest("Request");
        verify(httpClient).getHTTPRequest(anyString());

        assertThat(check).isEqualTo("This is our Site");

    }


}
