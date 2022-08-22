package exemplo6.modo1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Joao");
        nomes.add("Eduardo");
        nomes.add("Maria");
        nomes.add("Luiz");
        nomes.add("Edmilson");

        System.out.println(nomes);
       // List<String> nomesRemove = new ArrayList<>();

       // for (String n : nomes) {
       //     if (n.startsWith("E")) {
       //         nomesRemove.add(n);
       //     }
       // }
       // nomes.removeAll(nomesRemove);

       // System.out.println(nomesRemove);

        nomes.removeIf(nome -> nome.startsWith("J"));
        System.out.println(nomes);

        nomes.sort((nome1, nome2) -> nome1.compareTo(nome2));
        System.out.println(nomes);

        nomes.forEach(nome -> System.out.println(nome));



        List<Integer> inteiros = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            inteiros.add(i);
        }
        System.out.println(inteiros);

        inteiros.removeIf(x -> x % 3 == 0);
        System.out.println(inteiros);

        inteiros.removeIf(x -> x % 4 == 0);
        System.out.println(inteiros);

        inteiros.sort((x, y) -> y.compareTo(x));
        System.out.println(inteiros);

        List<Integer> num2 = new ArrayList<>();
        inteiros.forEach(numero -> num2.add(numero * 3));


    }

}
