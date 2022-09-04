package assincrona;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        CompletableFuture<Integer> completableFuture =
                CompletableFuture.supplyAsync(() -> soma(1000));
        int count = 0;

        Integer soma = completableFuture.get(2100, TimeUnit.MILLISECONDS);
        System.out.println(soma);
    }

    public static Integer soma(Integer numero) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer soma = IntStream
                .range(1, numero)
                .sum();
        return soma;
    }

}
