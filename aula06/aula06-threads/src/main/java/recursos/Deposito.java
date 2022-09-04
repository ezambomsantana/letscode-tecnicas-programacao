package recursos;

public class Deposito implements Runnable {

    private Integer valor;

    public Deposito(Integer valor) {
        this.valor = valor;
    }

    @Override
    public void run() {
        synchronized (Main.saldo) {
            Integer saldo = Main.saldo;
            saldo = saldo + valor;
            Main.saldo = saldo;
        }
    }
}
