package aula02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        //Crie uma lista de animais (usando a classe que vimos em aula), adicione 5 animais.
        //         filtre apenas por animais que nadam.
        //         imprima todas as espécies usando o forEach
        // ordene os animais em ordem alfabética
        // imprima novamente todas as espécies usando o forEach


        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe", false, true, false, false));
        animais.add(new Animal("canguru", true, false, false, false));
        animais.add(new Animal("coelho", true, false, false, false));
        animais.add(new Animal("tarturaga", false, true, false, false));
        animais.add(new Animal("pomba", false, false, true, false));
        animais.add(new Animal("cobra", false, false, false, true));
        animais.add(new Animal("baleia", false, true, false, false));

        animais.forEach(animal -> System.out.println(animal.getEspecie()));

        animais.removeIf(animal -> !animal.isPodeNadar());

        System.out.println("----");
        animais.forEach(animal -> System.out.println(animal.getEspecie()));

        System.out.println("----");

        animais.sort((animal1, animal2)
                -> animal2.getEspecie().compareTo(animal1.getEspecie()));

        animais.forEach(animal -> System.out.println(animal.getEspecie()));


        // Crie uma BiFunction que receba um valor de uma transação e o limite de um cliente,
        // se o limite for maior que o valor retorne true, caso contrário retorne false

        System.out.println("----");
        BiFunction<Integer, Integer, Boolean> funcao = (valor, limite) -> limite >= valor;
        System.out.println(funcao.apply(1000, 5000));
        System.out.println(funcao.apply(10000, 5000));

        System.out.println("----");
        // Escreva uma Function Java que verifica se o número é par ou impar.
        Function<Integer, Boolean> funcao2 = numero -> numero % 2 == 0;
        System.out.println(funcao2.apply(10));
        System.out.println(funcao2.apply(7));
        System.out.println(funcao2.apply(20));
        System.out.println(funcao2.apply(5));

        //Crie uma lista com número inteiros, adicione os números de 0 a 100 na lista.

        //filtre apenas os números pares.
        //        ordene os números

        System.out.println("----");
        List<Integer> numeros = new ArrayList<>();
        for (int i = 101; i >= 0; i--) {
            numeros.add(i);
        }
        numeros.forEach(numero -> System.out.println(numero));

        numeros.removeIf(numero -> numero % 2 != 0);
        System.out.println("----");
        numeros.forEach(numero -> System.out.println(numero));

        numeros.sort((n1, n2) -> n1.compareTo(n2));
        numeros.forEach(numero -> System.out.println(numero));



    }

}
