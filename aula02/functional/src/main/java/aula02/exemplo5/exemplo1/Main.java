package aula02.exemplo5.exemplo1;

public class Main {

    public static void main(String[] args) {
        mostraOperacao(5, 6, (x, y) -> x + y);
        mostraOperacao(5, 6, (x, y) -> x * y);
        mostraOperacao(5, 6, (x, y) -> x / y);

    }

    public static void mostraOperacao(Integer num1, Integer num2, Operacao operacao) {
        System.out.println(operacao.operacao(num1, num2));;
    }


}
