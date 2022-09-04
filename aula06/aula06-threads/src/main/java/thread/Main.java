package thread;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Soma soma1 = new Soma(10);
        soma1.setPriority(10);
        soma1.setName("Thread soma-1");
        System.out.println(soma1.getState());

        soma1.start();
        System.out.println(soma1.getState());

        Soma soma2 = new Soma(1000000);
        soma2.start();

        Soma soma3 = new Soma(50);
        soma3.start();

        Thread t1 = new Thread(new Soma2(100));
        t1.start();

        Thread t2 = new Thread(new Soma2(150));
        t2.start();

        Thread t3 = new Thread(new Soma2(20));
        t3.start();

        Thread t4 = new Thread(() -> soma(t3, 1000));
        t4.start();

        Thread t5 = new Thread(() -> soma(t4, 5));
        t5.start();
        System.out.println(t5.isAlive());



        soma1.join(1000);
        soma1.join();
        soma2.join();
        soma3.join();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println(soma1.getName());
        System.out.println(soma2.getName());
        System.out.println(soma3.getName());
        System.out.println(t1.getName());

        System.out.println(soma1.getPriority());
        System.out.println(soma1.getState());
        System.out.println(soma1.isAlive());

        System.out.println("Finalizou o main!");



        // try {
        //   Thread.sleep(5000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
    }

    public static void soma(Thread t, Integer numero)  {
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer soma = IntStream
                .range(1, numero)
                .sum();
        System.out.println(soma);
    }

}
