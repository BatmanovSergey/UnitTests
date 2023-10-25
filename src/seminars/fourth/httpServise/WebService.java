package seminars.fourth.httpServise;

public class WebService {
    HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getHttp (String url) {
        String answer = httpClient.getHTTPRequest(url);
        System.out.println(answer);
        return answer;
    }
}
