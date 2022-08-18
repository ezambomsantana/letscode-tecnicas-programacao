package aula02.exemplo6;


import aula02.exemplo4.predicate.Animal;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Joao");
        names.add("Jose");
        names.add("Maria");
        System.out.println("Nomes: " + names);

        names.removeIf(name -> !name.startsWith("J"));
        System.out.println("Nomes iniciando com J: " + names);

        names.add("Araci");
        names.add("Ze");
        System.out.println("\nNomes: " + names);

        names.sort((name1, name2) -> name1.compareTo(name2));
        System.out.println("Nomes ordenados: " + names);

        System.out.println("\nImprimindo novamente");
        names.forEach(name -> System.out.println(name));


        List<Animal> animals = new ArrayList<>();

        animals.add(new Animal("peixe", false, true));
        animals.add(new Animal("canguru", true, false));
        animals.add(new Animal("coelho", true, false));
        animals.add(new Animal("tartaruga", false, true));

        animals.sort((a1, a2) -> a1.getEspecie().compareTo(a2.getEspecie()));
        animals.forEach(name -> System.out.println(name.getEspecie()));


    }
}
