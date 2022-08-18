package aula02.exemplo2;

import java.util.function.Function;

public class Main2 {

    public static void main(String[] args) {

        Operacao operacao = x -> x * 3;

        realizaOperacao(4, operacao);
        realizaOperacao(5, operacao);
        realizaOperacao(5, x -> x * 2);


    }

    public static void realizaOperacao(Integer valor, Operacao operacao) {
        System.out.println(operacao.operacao(valor));
    }



}
