package aula03.streams.intermediarias;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        List<Integer> numeros = Arrays.asList(5, 5, 5, 4, 2, 6, 7, 20, 21);

        numeros
                .stream()
                .map(x -> x * 2)
                .filter(x -> x < 20)
                .forEach(x -> System.out.println(x));

        System.out.println("----");
        Optional<Integer> num = numeros
                .stream()
                .min((n1, n2) -> n1.compareTo(n2));
        System.out.println(num.get());

        System.out.println("----");
        Integer min = Integer.MAX_VALUE;
        for (Integer numero : numeros) {
            if (min > numero) {
                min = numero;
            }
        }
        System.out.println(min);


        Optional<Integer> numMax = numeros
                .stream()
                .max((n1, n2) -> n1.compareTo(n2));
        System.out.println(numMax.get());

        //List<Integer> numeros = Arrays.asList(5, 4, 2, 6, 7, 20, 21);
        // map -> 10, 8, 4, 12, 14, 40, 42
        // reduce -> 10 + 8 = 18, 4, 12, 14 40, 42
        // reduce -> 22, 12, 14 40, 42
        // reduce -> 34, 14 40, 42
        // 48, 40, 42
        // 88, 42
        // 130
        System.out.println("---");
        Optional<Integer> valor = numeros
                .stream()
                .distinct()
                .sorted()
                .map(x -> x * 2)
                .reduce((x, y) -> x + y); // terminal

        System.out.println(valor.get());



    }

}
