package se.salt.foreignexchangeapi.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
@Configuration
public class ApiClient {

    private final RestClient restClient;

    public ApiClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public String convertCurrency(String baseCurrency, String wantedCurrency){
        return restClient.get().uri("/latest?base=" + baseCurrency+ "&symbols=" + wantedCurrency)
                .retrieve()
                .body(String.class);
    }
}
