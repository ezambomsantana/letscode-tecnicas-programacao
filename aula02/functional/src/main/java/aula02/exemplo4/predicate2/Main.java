package aula02.exemplo4.predicate2;

import aula02.exemplo4.predicate.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe", false, true));
        animais.add(new Animal("canguru", true, false));

        print(animais, a -> a.startsWith("p"));
    }
    private static void print(List<Animal> animais, Predicate<String> verificador) {
        for (Animal animal : animais) {
            if (verificador.test(animal.getEspecie()))
                System.out.print(animal + " ");
        }
        System.out.println();
    }

}
