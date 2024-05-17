import reactor.core.publisher.Flux;

public class FibonacciExample {

    public static void main(String[] args) {
        int n = 10;

        Flux<Integer> fibonacciFlux = Flux.generate(
                () -> new int[]{0, 1},
                (state, sink) -> {
                    sink.next(state[0]);
                    int nextValue = state[0] + state[1];
                    state[0] = state[1];
                    state[1] = nextValue;
                    return state;
                })
                .take(n);

        fibonacciFlux.subscribe(
                value -> System.out.println("Fibonacci: " + value),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Fibonacci generation completed!")
        );
    }
}
