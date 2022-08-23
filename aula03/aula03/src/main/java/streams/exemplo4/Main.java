package streams.exemplo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Eduardo", 7, 6));
        alunos.add(new Aluno("Luiz", 8, 2));
        alunos.add(new Aluno("Joao", 3, 4));
        alunos.add(new Aluno("Bruna", 5, 9));
        alunos.add(new Aluno("Maria", 7, 7));
        alunos.add(new Aluno("Jose", 2, 6));
        alunos.add(new Aluno("Marcelo", 9, 5));

        alunos
                .stream()
                .forEach(x -> System.out.println(x.getNome()));

        Long count = alunos
                .stream()
                .count();

        System.out.println(count);

        Optional<Aluno> aluno = alunos
                .stream()
                .max((a1, a2) -> (Integer.valueOf(a1.getNota1() + a1.getNota2()).compareTo(a2.getNota1() + a2.getNota2())));
        System.out.println(aluno.get().getNome());


        Optional<Aluno> alunoMin = alunos
                .stream()
                .min((a1, a2) -> (Integer.valueOf(a1.getNota1() + a1.getNota2()).compareTo(a2.getNota1() + a2.getNota2())));
        System.out.println(alunoMin.get().getNome());

        Optional<Integer> soma = alunos
                .stream()
                .map(a1 -> a1.getNota1())
                .reduce((x, y) -> x + y);

        System.out.println(soma);

        Long conta = alunos
                .stream()
                .count();

        System.out.println(soma.get() /conta.intValue());


    }

}
