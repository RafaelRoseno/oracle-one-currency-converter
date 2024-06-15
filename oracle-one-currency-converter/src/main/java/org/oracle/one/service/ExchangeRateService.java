package org.oracle.one.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.oracle.one.utils.Currencies;
import org.oracle.one.utils.ExchangeRateApiConfig;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRate {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ExchangeRateResponse processExchangeRate(Currencies baseCurrency, Currencies targetCurrency, Long amount){
        var formattedUrl = String.format(ExchangeRateApiConfig.EXCHANGE_RATE_PAIR_URI, baseCurrency, targetCurrency, amount);
        return convertCurrency(formattedUrl);
    }


    private ExchangeRateResponse convertCurrency(String uri){
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return objectMapper.readValue(response.body(), ExchangeRateResponse.class);

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
