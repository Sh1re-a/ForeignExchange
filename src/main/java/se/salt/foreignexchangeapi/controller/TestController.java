package se.salt.foreignexchangeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.salt.foreignexchangeapi.client.ApiClient;
import se.salt.foreignexchangeapi.dto.FrankfurterLatestResponse;

@RestController
public class TestController {
    private final ApiClient apiClient;

    public TestController(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping("/test")
    public double test() {
        FrankfurterLatestResponse frankfurterLatestResponse = apiClient.convertCurrency("EUR", "SEK");
        return frankfurterLatestResponse.rates().get("SEK");
    }
}
