package exercicio1;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Eduardo", "Engenheiro de Software",(float) 10000, LocalDate.parse("2020-01-01"), null));
        funcionarios.add(new Funcionario("Joao", "Engenheiro de Software",(float) 5000, LocalDate.parse("2018-01-01"), LocalDate.parse("2022-01-01")));
        funcionarios.add(new Funcionario("Maria", "Engenheiro de Software",(float) 7000, LocalDate.parse("2022-01-01"), null));

        double media = funcionarios
                .stream()
                .mapToDouble(funcionario -> funcionario.getSalario())
                .average().getAsDouble();
        System.out.println(media);

        Comparator<Funcionario> comparator = (f1, f2) -> f1.getSalario().compareTo(f2.getSalario());

        Optional<Funcionario> max = funcionarios
                .stream()
                .max(comparator);
        System.out.println(max.get().getNome());

        Optional<Funcionario> min = funcionarios
                .stream()
                .min(comparator);
        System.out.println(min.get().getNome());

        List<Funcionario> engenheiros = funcionarios
                .stream()
                .filter(funcionario -> funcionario.getCargo().equals("Engenheiro de Software") && funcionario.getSalario() >= 5000)
                .collect(Collectors.toList());

        Optional<Funcionario> maxEngenheiro = engenheiros
                .stream()
                .max(comparator);
        System.out.println(maxEngenheiro.get().getNome());

        Optional<Funcionario> minEngenheiro = engenheiros
                .stream()
                .min(comparator);
        System.out.println(minEngenheiro.get().getNome());


        double mediaEngenheiro = engenheiros
                .stream()
                .mapToDouble(funcionario -> funcionario.getSalario())
                .average().getAsDouble();
        System.out.println(mediaEngenheiro);




        funcionarios.stream()
                .sorted((f1, f2) -> f1.getDataContratacao().compareTo(f2.getDataContratacao()))
                .forEach(funcionario -> System.out.println(funcionario.getNome()));

        //funcionarios
      ///          .stream()
       //         .map(funcionario ->
        //                Period.between(funcionario.getDataContratacao(), funcionario.getDataDemissao() != null ? funcionario.getDataDemissao() : LocalDate.now()))


        Funcionario funcionario =     new Funcionario("Eduardo", "Engenheiro de Software",(float) 10000, LocalDate.parse("2020-01-01"), LocalDate.parse("2022-01-01"));
        if (funcionario.getDataDemissao() != null) {
            System.out.println(funcionario.getDataDemissao());
        } else {
            System.out.println(LocalDate.now());
        }

        System.out.println(
                funcionario.getDataDemissao() != null ? funcionario.getDataDemissao() : LocalDate.now()
        );

        System.out.println(funcionario.getSalario() >= 5000 ? "OK" : "Nao OK");

    }

}
