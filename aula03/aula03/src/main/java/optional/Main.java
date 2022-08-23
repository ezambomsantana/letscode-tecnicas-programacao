package optional;


import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Optional<String> empty = Optional.empty();
        System.out.println(empty.isEmpty());

        String name = "Eduardo";
        Optional<String> opt = Optional.of("Eduardo");
        System.out.println(opt.isEmpty());

        if (name != null) {
            System.out.println(name);
        }

        opt.ifPresent(n -> System.out.println(n));
        System.out.println(opt.orElse("não existe"));

        retornaNome(null)
                .orElseThrow(() -> new RuntimeException("O nome eh nulo"));

    }

    public static Optional<String> retornaNome(String nome) {
        if (nome == null) {
            return Optional.empty();
        } else {
            return Optional.of(nome);
        }
    }


}
