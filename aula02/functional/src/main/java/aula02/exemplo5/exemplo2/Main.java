package aula02.exemplo5.exemplo2;

public class Main {

    public static void main(String[] args) {
        mostraOperacao(5, 6, 7, (x, y, z) -> x + y + z);
        mostraOperacao(5, 6, 8, (x, y, z) -> x * y * z);
        mostraOperacao(5, 6, 0,  (x, y, z) -> x / y);

    }

    public static void mostraOperacao(Integer num1, Integer num2, Integer num3, Operacao operacao) {
        System.out.println(operacao.operacao(num1, num2, num3));;
    }


}
