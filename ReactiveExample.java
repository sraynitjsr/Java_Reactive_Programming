import reactor.core.publisher.Flux;

public class ReactiveExample {

    public static void main(String[] args) {
        // Create a Flux emitting integers from 1 to 10
        Flux<Integer> numbersFlux = Flux.range(1, 10);

        // Subscribe to the Flux and define actions for onNext, onError, and onComplete events
        numbersFlux.subscribe(
                value -> System.out.println("Received: " + value), // onNext
                error -> System.err.println("Error: " + error),   // onError
                () -> System.out.println("Completed!")           // onComplete
        );
    }
}
