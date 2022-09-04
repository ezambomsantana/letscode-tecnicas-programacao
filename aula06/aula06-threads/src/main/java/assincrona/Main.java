package assincrona;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService thread = Executors.newCachedThreadPool();
        Future<Integer> futureTask = thread.submit(() -> soma(1000));
        while (!futureTask.isDone()) {
            System.out.println("Nao terminou de calcular o valor");
        }
        Integer soma = futureTask.get();
        System.out.println(soma);
        thread.shutdown();
    }

    public static Integer soma(Integer numero) {
        Integer soma = IntStream
                .range(1, numero)
                .sum();
        return soma;
    }

}
