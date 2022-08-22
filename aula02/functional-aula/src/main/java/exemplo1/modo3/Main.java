package exemplo1.modo3;

import exemplo1.Animal;
import exemplo1.modo2.VerificaPodeNadar;
import exemplo1.modo2.VerificaPodeSaltar;
import exemplo1.modo2.VerificaPodeVoar;

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

        verificaHabilidade(animais, animal -> animal.isPodeNadar());
        System.out.println();
        verificaHabilidade(animais, animal -> animal.isPodeSaltar());
        System.out.println();
        verificaHabilidade(animais, animal -> animal.isPodeVoar());
        System.out.println();
        verificaHabilidade(animais, animal -> animal.isPodeArrastar());

    }

    private static void verificaHabilidade(List<Animal> animais, Verificador verificador) {
        for (Animal animal : animais) {
            if (verificador.verificar(animal)) {
                System.out.print(animal.getEspecie() + " ");
            }
        }
    }


}
