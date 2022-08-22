package exemplo3.modo2;

import exemplo3.modo1.Operacao;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Function<Integer, Integer> operacao = x -> x * 3;
        operacao.apply(5);

        operacao(5, x -> x * 3);
        operacao(5, x -> x + 3);

        operacao(5, x -> (int) Math.pow(x, 10));
        operacao(20, x -> x * 3);

    }

    public static void operacao(Integer x,  Function<Integer, Integer> operacao) {
        System.out.println(operacao.apply(x));
    }



}
