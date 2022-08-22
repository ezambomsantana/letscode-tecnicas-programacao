package exemplo3.modo1;

public class Main {

    public static void main(String[] args) {
        operacao(5, x -> x * 3);
        operacao(5, x -> x + 3);

        operacao(5, x -> (int) Math.pow(x, 10));
        operacao(20, x -> x * 3);

    }

    public static void operacao(Integer x, Operacao operacao) {
        System.out.println(operacao.operacao(x));
    }



}
