import reactor.core.publisher.Flux;

import java.util.Random;

public class RandomNumberExample {

    public static void main(String[] args) {
        int n = 10;

        Flux<Integer> randomFlux = Flux.generate(
                () -> new Random(),
                (random, sink) -> {
                    int nextValue = random.nextInt(100);
                    sink.next(nextValue);
                    return random;
                })
                .take(n);

        randomFlux.subscribe(
                value -> System.out.println("Random Number: " + value),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Random number generation completed!")
        );
    }
}
