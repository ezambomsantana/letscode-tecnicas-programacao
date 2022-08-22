package exemplo6.modo2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Joao", 5000, "1234", "Sao Paulo"));
        pessoas.add(new Pessoa("Maria", 1000, "4323", "Campinas"));
        pessoas.add(new Pessoa("Eduardo", 10000, "4234", "Sao Paulo"));
        pessoas.add(new Pessoa("Luiz", 9000, "5344", "Sao Carlos"));
        pessoas.add(new Pessoa("Bruna", 15000, "1235", "Campinas"));

        System.out.println(pessoas);

        //pessoas.removeIf(pessoa -> pessoa.getSalario() > 6000
         //       && pessoa.getCidade().equals("Campinas"));


        pessoas.sort((p1, p2) -> p1.getCidade().compareTo(p2.getCidade()));
        System.out.println(pessoas);



       // pessoas.forEach(pessoa -> System.out.println(pessoa.getNome()));
    }

}
