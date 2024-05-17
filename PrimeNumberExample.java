import reactor.core.publisher.Flux;

public class PrimeNumberExample {

    public static void main(String[] args) {
        int n = 20;

        Flux<Integer> primeFlux = Flux.range(2, Integer.MAX_VALUE)
                .filter(PrimeNumberExample::isPrime)
                .take(n);

        primeFlux.subscribe(
                value -> System.out.println("Prime: " + value),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Prime number generation completed!")
        );
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
