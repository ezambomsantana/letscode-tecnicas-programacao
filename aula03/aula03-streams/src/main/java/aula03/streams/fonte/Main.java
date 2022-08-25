package aula03.streams.fonte;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // finitas
        List<Integer> numeros = Arrays.asList(5, 4, 2, 6, 7, 20, 21);
        Stream<Integer> stream = numeros.stream();

        System.out.println(stream.count());

        Stream<String> streamString = Stream.empty();
        System.out.println(streamString.count());
        Stream<String> streamOf = Stream.of("Eduardo", "Luiz", "Maria");
        streamOf.forEach(x -> System.out.println(x));

        Stream<Integer> numerosImparesMenor100 = Stream.iterate(
                5,
                n -> n < 100,
                n -> n + 2
        );
        numerosImparesMenor100.forEach(x -> System.out.println(x));
        // infinita
        Stream<Integer> doubles = Stream.generate(() -> 5);
        // doubles.forEach(x -> System.out.println(x));

        Stream<Integer> numerosImpares = Stream.iterate(5, n -> n + 2);
        numerosImpares.forEach(x -> System.out.println(x));



    }

}
