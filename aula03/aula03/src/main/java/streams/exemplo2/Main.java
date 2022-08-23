package streams.exemplo2;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream<String> s = Stream.of("casa", "carro", "comida");
        System.out.println(s.count());   // 3


        s = Stream.of("casa", "asa", "comida");
        Optional<String> min = s.min((s1, s2) -> s1.length()-s2.length());
        min.ifPresent(System.out::println); // asa

        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent());


        s = Stream.of("casa", "comida", "carro");
        Stream<String> infinita = Stream.generate(() -> "asa");

        s.findFirst().ifPresent(System.out::println);        // casa
        infinita.findAny().ifPresent(System.out::println);

        s = Stream.of("casa", "comida", "carro");
        s.forEach(System.out::print); // casacomidacarro



        var array = new String[] { "c", "a", "s", "a" };
        var resultado = "";
        for (var s2: array) resultado = resultado + s2;
        System.out.println(resultado); // casa


        Stream<String> stream = Stream.of("c", "a", "s", "a");
        String palavra3 = stream.reduce("", (sr, c) -> sr + c);
        System.out.println(palavra3); // casa


        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        List<String> set = stream2.collect(Collectors.toList());
        System.out.println(set); // [a, b, l, o]



    }

}
