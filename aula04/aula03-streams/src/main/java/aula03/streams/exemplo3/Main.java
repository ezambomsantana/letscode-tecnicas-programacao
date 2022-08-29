package aula03.streams.exemplo3;

import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("eduardo", "joao", "maria", "jose");
        System.out.println(stream.count());

        stream = Stream.of("eduardo", "joao", "maria", "jose");
        stream
                .map(nome -> nome.charAt(0))
                .forEach(nome -> System.out.println(nome));


        stream = Stream.of("eduardo", "joao", "maria", "jose");
        System.out.println(stream.min((n1, n2) -> n1.compareTo(n2)).get());

        stream = Stream.of("eduardo", "joao", "maria", "jose");
        System.out.println(stream.max((n1, n2) -> n1.compareTo(n2)).get());

        stream = Stream.of("eduardo", "joao", "maria", "jose");
        System.out.println(stream.findFirst().get());


        stream = Stream.of("eduardo", "joao", "maria", "jose");
        Optional<String> texto = stream
                .reduce((s1, s2) -> s1 + s2);
        System.out.println(texto.get());

        String textoFor = "";
        List<String> lista = Arrays.asList("eduardo", "joao", "maria", "jose");
        for (int i = 0; i < lista.size() - 1 ; i++) {
            textoFor = textoFor + lista.get(i) + lista.get(i+1);
        }
        System.out.println(textoFor);



        stream = Stream.of("eduardo", "joao", "maria", "jose");
        Set<String> nomesMaiusculo = stream
                .map(nome -> nome.toUpperCase())
                .collect(Collectors.toSet());
        System.out.println(nomesMaiusculo);

        stream = Stream.of("eduardo", "joao", "maria", "jose", "marcelo", "eduarda");

        Map<Integer, List<String>> map = stream
                .collect(Collectors.groupingBy(nome -> nome.length()));
        System.out.println(map);



    }


}
