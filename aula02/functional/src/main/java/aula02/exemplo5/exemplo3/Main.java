package aula02.exemplo5.exemplo3;

import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x + y;

        System.out.println(biFunction.apply(5, 6));

    }
}
