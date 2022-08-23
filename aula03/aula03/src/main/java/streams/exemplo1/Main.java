package streams.exemplo1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        Stream<String> streamVazia = Stream.empty();    // #elementos 0
        Stream<Integer> unicoElemento = Stream.of(1);   // #elementos 1
        Stream<Integer> usandoVarrags = Stream.of(1, 2, 3); // #elementos 3
        List<String> lista = List.of("a", "b", "c");
        Stream<String> streamDaLista = lista.stream();

        Stream<Double> randomicos = Stream.generate(Math::random);
        randomicos.forEach(x -> System.out.println(x));
        Stream<Integer> numerosImpares = Stream.iterate(1, n -> n + 2);

        Stream<Integer> numerosParesMenores100 = Stream.iterate(
                2,                // semente
                n -> n < 100,     // Predicate de verificação
                n -> n + 2);




    }

}
