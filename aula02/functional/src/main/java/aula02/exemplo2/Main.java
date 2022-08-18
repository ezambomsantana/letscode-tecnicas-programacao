package aula02.exemplo2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        realizaOperacao(4, x -> x * 3);
        realizaOperacao(5, x -> x * 3);
        realizaOperacao(5, x -> x * 2);


    }

    public static void realizaOperacao(Integer valor, Operacao operacao) {
        System.out.println(operacao.operacao(valor));
    }



}
