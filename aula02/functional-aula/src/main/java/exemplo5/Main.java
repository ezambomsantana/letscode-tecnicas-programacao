package exemplo5;

import exemplo1.Animal;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Operacao operacao = (x, y, z) -> x * y * z;
        System.out.println(operacao.operacao(5, 3, 6));

        Operacao operacao2 = (x, y, z) -> x + y + z;
        System.out.println(operacao2.operacao(5, 3, 6));

        Function<String, Animal> function = especie -> {
            return new Animal(especie, false, false, false, false);
        };

        BiFunction<String, String, Animal> biFunction = (especie, habilidade) -> {
            if (habilidade.equals("nadar")) {
                return new Animal(especie, false, true, false, false);
            } else if (habilidade.equals("voar")) {
                return new Animal(especie, false, false, true, false);
            }
            return null;
        };

        Animal animal = biFunction.apply("peixe", "nadar");
        System.out.println(animal.getEspecie());


    }



}
