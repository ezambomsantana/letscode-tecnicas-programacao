package recursos;

public class Main {

    public static Integer saldo = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Deposito(100));
        t1.start();

        Thread t2 = new Thread(new Deposito(200));
        t2.start();

        Thread t3 = new Thread(new Saque(150));
        t3.start();

        Thread t4 = new Thread(new Deposito(100));
        t4.start();

        Thread t5 = new Thread(new Deposito(300));
        t5.start();

        Thread t6 = new Thread(new Saque(200));
        t6.start();

        Thread t7 = new Thread(new Deposito(100));
        t7.start();

        Thread t8 = new Thread(new Saque(200));
        t8.start();

        Thread t9 = new Thread(new Deposito(500));
        t9.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();
        t9.join();

        System.out.println(Main.saldo);


    }
}
