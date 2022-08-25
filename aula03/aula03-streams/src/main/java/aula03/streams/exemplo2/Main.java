package aula03.streams.exemplo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Eduardo", 7, 8));
        alunos.add(new Aluno("Luiz", 5, 5));
        alunos.add(new Aluno("Maria", 8, 9));
        alunos.add(new Aluno("Jose", 4, 10));
        alunos.add(new Aluno("Joao", 6, 7));
        alunos.add(new Aluno("Bruna", 10, 8));
        alunos.add(new Aluno("A", 4, 10));
        alunos.add(new Aluno("B", 4, 10));
        alunos.add(new Aluno("C", 10, 10));

        alunos.stream().forEach(aluno -> System.out.println(aluno.getNome()));

        System.out.println("---");
        Optional<Aluno> maiorNota = alunos
                .stream()
                .max((aluno1, aluno2) -> aluno1.getNota1().compareTo(aluno2.getNota1()));
        System.out.println(maiorNota.get().getNome());

        System.out.println("---");
        Optional<Aluno> menorNota = alunos
                .stream()
                .max((aluno1, aluno2) -> aluno1.getNota1().compareTo(aluno2.getNota1()));
        System.out.println(menorNota.get().getNome());

        System.out.println("----");
        Optional<Integer> soma = alunos
                .stream()
                .map(aluno -> aluno.getNota1())
                .reduce((nota1, nota2) -> nota1 + nota2);
        System.out.println(soma.get() / alunos.stream().count());

        System.out.println("----");
        Integer somaNota1 = 0;
        for (Aluno aluno : alunos) {
            somaNota1 = somaNota1 + aluno.getNota1();
        }
        System.out.println(somaNota1 / alunos.size());



        // calcular medias dos alunos

        System.out.println("----");
        OptionalDouble medias = alunos
                .stream()
                .map(aluno -> new AlunoMedia(aluno.getNome(), (aluno.getNota1() + aluno.getNota2()) / 2))
                .mapToInt(alunoMedia -> alunoMedia.getMedia())
                .average();
        System.out.println(medias.getAsDouble());

        System.out.println("----");
        Integer somaFor = 0;
        Integer countFor = 0;
        for (Aluno aluno : alunos) {
            AlunoMedia alunoMedia = new AlunoMedia(aluno.getNome(), (aluno.getNota1() + aluno.getNota2()) / 2);
            if (alunoMedia.getMedia() >= 6) {
                somaFor = somaFor + alunoMedia.getMedia();
                countFor++;
            }
        }
        System.out.println(somaFor / countFor);



    }
}
