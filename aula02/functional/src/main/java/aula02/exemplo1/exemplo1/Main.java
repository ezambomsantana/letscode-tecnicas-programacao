package aula02.exemplo1.exemplo1;

import aula02.exemplo1.Animal;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // lista de animais
        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe", false, true));
        animais.add(new Animal("canguru", true, false));
        animais.add(new Animal("coelho", true, false));
        animais.add(new Animal("tartaruga", false, true));

        // imprime os animais verificados
        imprimirSaltadores(animais);
        imprimirNadadores(animais);
    }
    private static void imprimirSaltadores(List<Animal> animais) {
        System.out.println("Saltadores");
        for (Animal animal : animais) {
            // verificando
            if (animal.podeSaltar()) {
                System.out.print(animal + " ");
            }
        }
        System.out.println();
    }

    private static void imprimirNadadores(List<Animal> animais) {
        System.out.println("Nadadores");
        for (Animal animal : animais) {
            // verificando
            if (animal.podeNadar()) {
                System.out.print(animal + " ");
            }
        }
        System.out.println();
    }

}
