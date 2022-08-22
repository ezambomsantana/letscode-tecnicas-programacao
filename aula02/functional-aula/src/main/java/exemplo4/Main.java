package exemplo4;

import exemplo1.Animal;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        operacao(5, x -> new Animal("a", true, true, true, true));

    }

    public static void operacao(Integer x,  Function<Integer, Animal> operacao) {
        System.out.println(operacao.apply(x));
    }



}
