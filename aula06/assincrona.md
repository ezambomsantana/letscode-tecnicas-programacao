# Programação Assíncrona

Mais detalhes em:

    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/FutureTask.html
    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/CompletableFuture.html
    https://www.baeldung.com/java-asynchronous-programming

Normalmente quando chamamos um método, esperamos que ele retorne um valor antes de continuar a execução do nosso programa, esse tipo de processamento, é chamado de síncrono. Porém, existem situações que é melhor chamar o método, e continuar o processamento do nosso programa normalmente, e receber o resultado do método apenas quando o método terminar a sua execução.

Esse tipo de processamento é chamado de assíncrono, pois fazemos uma chamada para um método, mas não esperamos a resposta antes de continuar.

É possível implementar processamento assíncrono com Threads, mas é um pouco complicado, pois o método `run` não possui retorno, por isso o Java possui classes que facilitam esse tipo de processamento, elas utilizam as threads na implementação, mas o programador não precisa se preocupar com elas. Essas classes são a `Future` e a `ComplatableFuture`

## Somatório de um Intervalo

Vamos continuar no mesmo exemplo mostrado anteriormente, vamos calcular a soma de um intervalo de números de 1 até o número passado como parâmtro para o método. A única diferença aqui, é que passamos o parâmetro diretamente para o método soma (lembre que o método run não tinha parâmetros), e também que retornamos o valor ao invés de imprimir na tela (o método run obrigatoriamente era void).

    public static Integer soma(Integer numero) {
        Integer soma = IntStream
                .range(0, numero)
                .sum();
        return soma;
    }

## Future

No Java 5 foi adicionado a classe `Future` que faz o processamento assíncrono. Para isso temos que criar um objeto do tipo `ExecutorService` e com esse objeto chamar o método `submit`, passando como parámetro a chamada para uma função, essa função será executada em uma thread separada, e será retornado um objeto do tipo `Future`, que pode ser utilizado para verificar se o processamento já foi finalizado ou não com o método `isDone`.

Enquanto o processamento não for finalizado, o método `isDone` retornará false, mas quando o processamento terminar, o retorno será true. Depois que o processamento for finalizado, podemos chamar o método `get`, que irá retornar o valor calculado no método soma.

    public static void main(String [] args) throws ExecutionException, InterruptedException {
        ExecutorService threadpool = Executors.newCachedThreadPool();
        Future<Integer> futureTask = threadpool.submit(() -> soma(1000));

        while (!futureTask.isDone()) {
            System.out.println("FutureTask is not finished yet...");
        }
        var result = futureTask.get();
        System.out.println(result);

        threadpool.shutdown();
    }

## CompletableFuture

No Java 8 foi introduzido a classe `CompletableFuture`, que funciona exatamente da mesma forma do Future, mas simplifica um pouco as coisas. Com ela não precisamos criar o objeto `ExecutorService`, então economizamos algumas linhas de código.

   public static void main(String [] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> soma(1000));
        while (!completableFuture.isDone()) {
            System.out.println("CompletableFuture is not finished yet...");
        }
        Integer result = completableFuture.get();
        System.out.println(result);
    }

## Outros métodos interessantes na classe CompletableFuture

### cancel(boolean)

É possível cancelar um CompletableFuture ainda não terminado, para isso utilizamos o método cancel, passando um boolean como parâmetro indicando se a tarefa deve ser cancelada mesmo se ela já tiver sido iniciada.

    completableFuture.cancel(true);

### getNow(T)

O método getNow retorna o valor imediatamente se ele já tiver sido calculado, caso contrário retorna um valor padrão passado como parâmetro para o método.

    completableFuture.getNow(100);

Nesse caso, o retorno será ou o valor calculado no método caso o processamento já tenha sido concluído, ou 100 caso o processamento ainda esteja em andamento.

### isCancelled()

Verifica se a task foi cancelada ou não.

    completableFuture.isCancelled();
