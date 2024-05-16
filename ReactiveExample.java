import reactor.core.publisher.Flux;

public class ReactiveExample {

    public static void main(String[] args) {
        // Creating a Flux that emits integers from 1 to 5
        Flux<Integer> numbersFlux = Flux.just(1, 2, 3, 4, 5);

        // Subscribing to the Flux and printing each emitted item
        numbersFlux.subscribe(
                // onNext callback
                number -> System.out.println("Received number: " + number),
                // onError callback
                error -> System.err.println("Error: " + error),
                // onComplete callback
                () -> System.out.println("Flux completed.")
        );
    }
}
