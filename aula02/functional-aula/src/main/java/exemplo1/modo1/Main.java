package exemplo1.modo1;

import exemplo1.Animal;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe", false, true, false, false));
        animais.add(new Animal("canguru", true, false, false, false));
        animais.add(new Animal("coelho", true, false, false, false));
        animais.add(new Animal("tarturaga", false, true, false, false));
        animais.add(new Animal("pomba", false, false, true, false));
        animais.add(new Animal("cobra", false, false, false, true));

        for (Animal animal : animais) {
            if (animal.isPodeNadar()) {
                System.out.print(animal.getEspecie() + " ");
            }
        }

        System.out.println();
        for (Animal animal : animais) {
            if (animal.isPodeSaltar()) {
                System.out.print(animal.getEspecie() + " ");
            }
        }

        System.out.println();
        for (Animal animal : animais) {
            if (animal.isPodeVoar()) {
                System.out.print(animal.getEspecie() + " ");
            }
        }

        System.out.println();
        for (Animal animal : animais) {
            if (animal.isPodeArrastar()) {
                System.out.print(animal.getEspecie() + " ");
            }
        }

    }

}
