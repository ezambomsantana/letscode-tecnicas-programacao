package assincrona;

import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Main2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService thread = Executors.newCachedThreadPool();
        Future<String> futureTask = thread.submit(() -> soma("eduardo"));
        Future<String> futureTask2 = thread.submit(() -> soma("casa"));
        while (!futureTask.isDone() && !futureTask2.isDone()) {
            System.out.println("1: " + futureTask.isDone());
            System.out.println("2: " + futureTask2.isDone());
            System.out.println("Nao terminou de calcular o valor");
        }
        String soma = futureTask.get();
        String soma2 = futureTask2.get();
        System.out.println(soma);
        System.out.println(soma2);
        thread.shutdown();
    }

    public static String soma(String texto) {
        return texto.toUpperCase();
    }

}
