package org.oracle.one.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.oracle.one.utils.Currencies;
import org.oracle.one.utils.ExchangeRateApiConfig;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateService {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ExchangeRateResponse processExchangeRate(ExchangeRequest operationRequest){
        var operationInput = buildOperation(operationRequest);
        var formattedUrl = String.format(ExchangeRateApiConfig.EXCHANGE_RATE_PAIR_URI, operationInput.getBase(), operationInput.getTarget(), operationInput.getAmount());
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

    private OperationInput buildOperation(ExchangeRequest request){
        switch (request.getMenuOperationSelected()){
            case 1:
                return new OperationInput(Currencies.BRL, Currencies.USD, request.getAmount());
            case 2:
                return new OperationInput(Currencies.BRL, Currencies.EUR, request.getAmount());
            case 3:
                return new OperationInput(Currencies.USD, Currencies.BRL, request.getAmount());
            case 4:
                return new OperationInput(Currencies.USD, Currencies.ARS, request.getAmount());
            case 5:
                return new OperationInput(Currencies.USD, Currencies.EUR, request.getAmount());
            case 6:
                return new OperationInput(Currencies.USD, Currencies.COP, request.getAmount());
            case 7:
                return new OperationInput(Currencies.ARS, Currencies.USD, request.getAmount());
            case 8:
                return new OperationInput(Currencies.COP, Currencies.USD, request.getAmount());
            case 9:
                return new OperationInput(Currencies.EUR, Currencies.BRL, request.getAmount());
            case 10:
                return new OperationInput(Currencies.EUR, Currencies.USD, request.getAmount());
            default:
                System.exit(0);
        }
        return null;
    }



}
