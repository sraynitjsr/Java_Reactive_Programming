import reactor.core.publisher.Flux;

public class FactorialExample {

    public static void main(String[] args) {
        int n = 5;

        Flux<Integer> factorialFlux = Flux.range(1, n)
                .reduce((x, y) -> x * y)
                .flux();

        factorialFlux.subscribe(
                result -> System.out.println("Factorial: " + result),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Factorial calculation completed!")
        );
    }
}
