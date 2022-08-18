package aula02.exemplo3;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x * 2;

        System.out.println(f.apply(5));
    }
}
