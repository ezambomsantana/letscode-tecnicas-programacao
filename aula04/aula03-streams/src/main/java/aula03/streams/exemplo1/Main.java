package aula03.streams.exemplo1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(5, 4, 2, 6, 7, 20, 21);
        Long count = numeros
                .stream()
                .map(x -> x * 2)
                .count();

        System.out.println(count);

        numeros
                .stream() // fonte
                .map(x -> x * 2) // t1
                .map(x -> x * 8) // t2
                .forEach(x -> System.out.println(x)); //terminal

        System.out.println("---");
        for (Integer numero : numeros) {
            numero = numero * 2;
            numero = numero * 8;
            System.out.println(numero);
        }



    }

}
