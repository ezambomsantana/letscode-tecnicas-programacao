package retorno;

import java.util.stream.IntStream;

public class Soma extends Thread {

    private Integer numero;

    public Soma(Integer numero) {
        this.numero = numero;
    }

    public void run() {
        Integer soma = IntStream
                .range(1, this.numero)
                .sum();
        System.out.println(this.getName() + " " + soma);
    }

}
