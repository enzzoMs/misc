package enzzoms;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeAPI {
    private static final String apiKey = "9f777f628fea72de278a7c42";

    public static double getConversionRate(CurrencyCodes from, CurrencyCodes to) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                    "https://v6.exchangerate-api.com/v6/%s/latest/%s".formatted(
                        apiKey, from.toString()
                    )
                ))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonElement element = JsonParser.parseString(response.body());
            JsonObject objectRoot = element.getAsJsonObject();

            return objectRoot
                .get("conversion_rates")
                .getAsJsonObject()
                .get(to.toString())
                .getAsDouble();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
