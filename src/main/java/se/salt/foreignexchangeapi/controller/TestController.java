package se.salt.foreignexchangeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.salt.foreignexchangeapi.client.ApiClient;
@RestController
public class TestController {
    private final ApiClient apiClient;

    public TestController(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping("/test")
    public String test() {
        return apiClient.convertCurrency("EUR", "SEK");
    }
}
