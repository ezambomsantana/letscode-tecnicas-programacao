package recursos;

public class Saque implements Runnable {

    private Integer valor;

    public Saque(Integer valor) {
        this.valor = valor;
    }

    @Override
    public void run() {
        synchronized (Main.saldo) {
            Integer saldo = Main.saldo;
            saldo = saldo - valor;
            Main.saldo = saldo;
        }
    }
}
