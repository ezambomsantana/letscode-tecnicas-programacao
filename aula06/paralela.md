# Programação Paralela em Java

    Mais detalhes em:

    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Thread.html
    https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Runnable.html
    https://www.baeldung.com/java-threadlocal

Até agora nossos programas executam apenas de forma sequencial, isto é, temos apenas um fluxo de execução que é iniciado na execução do método `main`, esse tipo de aplicação é chamada de `single-threaded`. Porém, podemos implementar aplicações que possuem diversos fluxos de execução que executam de forma paralela, as aplicações `multi-threaded`. 

As vantagens disso é que podemos tirar melhor proveito dos recursos computacionais, pois uma aplicação `single-threaded` utiliza apenas uma das CPUs de um computador, enquanto uma aplicação `multi-threaded` pode utilizar todas as CPUs disponíveis.

Para implementar uma aplicação multi-threaded em Java, utilizamos a classe `Thread` e a interface `Runnable`.

## Aplicação single-threaded

Toda aplicação Java possuí pelo menos uma thread, a que é incializa com a execução do método Main, vamos analisar uma aplicação que é executada dessa forma. Podemos criar a classe Conta, que recebe no construtor um número, e depois faz o somatório de todos os números entre 1 e o número passado como parámetro.


    package com.letscode;

    public class Conta {

        private Integer numero;

        public Conta(Integer numero) {
            this.numero = numero;
        }

        public Integer soma() {
            Integer soma = IntStream
                    .range(1, this.numero)
                    .sum();
            System.out.println(soma);
        }

    }

Depois podemos criar algumas instâncias dessa classe e calcular o somatório do intervalo.

    package com.letscode;

    public class Main {

        public static void main(String[] args) {
            Conta conta = new Conta(100);
            System.out.println(conta.soma());

            conta = new Conta(1000);
            System.out.println(conta.soma());
        }
    }

O código anterior funciona, mas ele primeiro soma o invervalo de 1 a 100 e depois o intevalo de 1 a 1000. Esse código pode ser melhorado utilizando processamento paralelo, pois podemos executar as somas ao mesmo tempo caso a máquina tenha mais de uma CPU.

## Classe Thread

A forma mais simples de implementar uma aplicação multi-threaded é utilizar a classe `Thread`. Para utilizar essa classe, precisaremos fazer algumas alterações no nosso código. Na classe Conta precisamos extender a classe `Thread`, que é a classe base do Java para a implementação de processamento paralelo.

A outra mudança é o nome do método que faz a soma, toda Thread deve possuir um método chamado `run`, que é o método que será executado quando a Thread for iniciada. Esse nome é obrigatório, além disso, esse método não pode ter parámetros e seu retorno é obrigatoriamente void.

    package com.letscode.multi;

    public class Conta extends Thread {

        private Integer numero;

        public Conta(Integer numero) {
            this.numero = numero;
        }

        public void run() {
            Integer soma = IntStream
                    .range(0, this.numero)
                    .sum();
            System.out.println(soma);
        }

    }

No main agora temos que fazer uma modificação para chamar o método `start`. Não devemos chamar o método `run` diretamente, pois se fizermos isso, a execução não será feito em uma Thread separada. 

    package com.letscode.multi;

    public class Main {

        public static void main(String[] args) {

            Conta conta = new Conta(100);
            conta.start();

            conta = new Conta(1000);
            conta.start();
        }
    }

O resultado da execução desse código é o mesmo do anterior, porém, aqui foram criadas três threads, a principal, crida quando executamos a aplicação, e as duas criadas para fazer o somatório.

Uma nota importante, quando criamos diferentes threads na JVM, nunca sabemos qual será a ordem da execução delas, por isso pode acontecer de a primeira acabar depois da segunda thread, mesmo ela tendo sendo criada antes.

## Interface Runnable

Outra forma de implementar Threads em Java é utilizar a interface Runnable. A implementação da classe `Conta` é pratimcamente a mesma, a única alteração necessária é substituir a extensão da classe `Thread` para a implementação da interface `Runnable`.

    package com.letscode.multi.runnable;

    public class Conta implements Runnable {

        private Integer numero;

        public Conta(Integer numero) {
            this.numero = numero;
        }

        public void run() {
            Integer soma = IntStream
                    .range(0, this.numero)
                    .sum();
            System.out.println(soma);
        }

    }

Já na execução da Thread no método `main`

    package com.letscode.multi.runnable;

    public class Main {

        public static void main(String[] args) {

            Conta conta = new Conta(100);
            Thread thread = new Thread(conta);
            thread.start();

            
            conta = new Conta(1000);
            Thread thread2 = new Thread(conta);
            thread2.start();
        }
    }

É válido implementar programação paralela usando a classe `Thread` ou a interface `Runnable`, mas é preferivel sempre utilizar a interface `Runnable`, pois ela permite que a classe extenda outra classe que não a Thread, além disso, só é recomendado utilizar herança quando o comportamente da classe pai será alterado, o que normalmente não é caso quando estamos implementado uma classe que será executada em uma Thread.

## Thread com função lambda

A partir do Java 8 é possível também executar uma função lambda utilizando uma Thread, para isso basta passar no construtor a função que deseja ser executada. Isso simplifica a execução de Threads, pois assim não precisamos criar uma classe nova que extenda Thread ou implemente Runnable. O exemplo a seguir mostra a implementação do mesmo exemplo anterior com lambda.

    public static void main(String[] args) {
        Thread thread = new Thread(() -> soma(100));
        thread.start();
    }

    public static void soma(Integer numero) {
        Integer soma = IntStream
                .range(0, numero)
                .sum();
        System.out.println(soma);
    }

## Métodos da classe Thread

A classe Thread possui diversos métodos para gerenciar as Threads, alguns exemplos são:

### getState()

Toda Thread tem um estado, que pode ser NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING e TERMINATED, podemos verificar o estado da thread utilizando o método `getState()`.

    Conta conta = new Conta(1000);
    Thread thread = new Thread(conta);
    System.out.println(thread.getState());;
    thread.start();
    System.out.println(thread.getState());;

O código anterior irá imprimir:

    NEW
    RUNNABLE

### isAlive()

Verifica se a Thread ainda está sendo executada, se sim retorna `true`, caso contrário `false`.

    System.out.println(thread.isAlive());

## join()

O método `join` faz a Thread que chamou o método esperar até que a outra Thread termine. Por exemplo, se executarmos esse código no método `main`:

    System.out.println(thread.isAlive());
    thread.join();
    System.out.println(thread.isAlive());

A thread principal vai esperar a thread chamada terminar de executar para continuar a sua execução.
