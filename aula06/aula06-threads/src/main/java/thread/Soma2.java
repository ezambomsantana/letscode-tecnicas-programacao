package thread;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Soma2 implements Runnable {

    private Integer numero;

    public Soma2(Integer numero) {
        this.numero = numero;
    }

    public void run() {
        Integer soma = IntStream
                .range(1, this.numero)
                .sum();
        System.out.println(soma);
    }

}
