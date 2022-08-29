package aula03.optional;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<String> nome = Optional.of("Eduardo");
        System.out.println(nome.isPresent());

        nome.ifPresent(x -> System.out.println(x));
        System.out.println(nome.orElse("Nome indefinido"));

        nome.orElseThrow(() -> new RuntimeException());
     }

}
