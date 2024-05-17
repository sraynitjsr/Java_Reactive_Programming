import reactor.core.publisher.Flux;

public class EvenOddNumberExample {

    public static void main(String[] args) {
        int n = 10;

        Flux<Integer> evenOddFlux = Flux.range(1, n)
                .flatMap(num -> Flux.just(num * 2, num * 2 + 1))
                .take(n * 2);

        evenOddFlux.subscribe(
                value -> System.out.println(value % 2 == 0 ? "Even: " + value : "Odd: " + value),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Even/Odd number generation completed!")
        );
    }
}
