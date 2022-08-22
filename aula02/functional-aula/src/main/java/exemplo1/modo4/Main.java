package exemplo1.modo4;

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

        List<Verificador> verificadores = new ArrayList<>();
        verificadores.add(animal -> animal.isPodeNadar());
        verificadores.add(animal -> animal.isPodeSaltar());
        verificadores.add(animal -> animal.isPodeVoar());
        verificadores.add(animal -> animal.isPodeArrastar());

        for (Verificador v : verificadores) {
            verificaHabilidade(animais, v);
            System.out.println();
        }
    }

    private static void verificaHabilidade(List<Animal> animais, Verificador verificador) {
        for (Animal animal : animais) {
            if (verificador.verificar(animal)) {
                System.out.print(animal.getEspecie() + " ");
            }
        }
    }


}
