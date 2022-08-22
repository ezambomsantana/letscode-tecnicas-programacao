package exemplo2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();
        nomes.add("Joao");
        nomes.add("Eduardo");
        nomes.add("Luiz");
        nomes.add("Bruna");


        verificaString(nomes, s -> s.startsWith("L"));
        System.out.println();
        verificaString(nomes, s -> s.length() == 4);
        System.out.println();
        verificaString(nomes, s -> s.length() > 4);
        System.out.println();
        verificaString(nomes, s -> verificaNome(s));
        System.out.println();
        verificaString(nomes, s -> {
            if (s.equals("L")) {
                return true;
            }
            return s.startsWith("L");
        });




    }

    private static boolean verificaNome(String s) {
        System.out.println(s);
        return s.startsWith("J");
    }

    public static void verificaString(List<String> nomes, Predicate<String> validacao) {
        for (String nome : nomes) {
            if (validacao.test(nome)) {
                System.out.println(nome);
            }
        }
    }

}
