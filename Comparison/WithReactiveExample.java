import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WithReactiveExample {
    public static void main(String[] args) {
        Mono.fromCallable(() -> fetchDataFromAPI("https://jsonplaceholder.typicode.com/posts/1"))
                .subscribeOn(Schedulers.boundedElastic())
                .doOnSuccess(response -> System.out.println("Response from server: " + response))
                .doOnError(error -> System.out.println("Failed to fetch data: " + error.getMessage()))
                .block();
    }

    private static String fetchDataFromAPI(String apiUrl) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new RuntimeException("Failed to fetch data. Response code: " + response.statusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
