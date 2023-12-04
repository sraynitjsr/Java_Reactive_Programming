# Reactive Programming in Java

### Sample Code to Start With as Example

### Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5)
###    .map(i -> i * 3)
###    .filter(i -> i > 5);

### flux.subscribe(
###    value -> System.out.println("Received: " + value),
###    error -> System.err.println("Error: " + error),
###    () -> System.out.println("Done Process")
### );
