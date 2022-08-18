package aula02.exemplo1.exemplo4;

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

        List<Verificador> verificadores = new ArrayList<>();
        verificadores.add(x -> x.podeNadar());
        verificadores.add(x -> x.podeSaltar());
        
        for (Verificador v : verificadores) {
            imprimirSaltadores(animais, v);
        }

    }
    private static void imprimirSaltadores(List<Animal> animais, Verificador verificador) {
        for (Animal animal : animais) {
            // verificando
            if (verificador.verificar(animal)) {
                System.out.print(animal + " ");
            }
        }
        System.out.println();
    }


}
