package exemplo1.modo2;

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

        verificaHabilidade(animais, new VerificaPodeNadar());
        System.out.println();
        verificaHabilidade(animais, new VerificaPodeSaltar());
        System.out.println();
        verificaHabilidade(animais, new VerificaPodeVoar());
        System.out.println();
        verificaHabilidade(animais, new VerificaPodeArrastar());

    }

    private static void verificaHabilidade(List<Animal> animais, Verificador verificador) {
        for (Animal animal : animais) {
            if (verificador.verificar(animal)) {
                System.out.print(animal.getEspecie() + " ");
            }
        }
    }


}
