package functional;

import java.time.LocalDate;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        // supplier
        Supplier<LocalDate> s1 = () -> LocalDate.now();
        LocalDate d1 = s1.get();
        System.out.println(d1);

        // consumer
        Consumer<String> c1 = x -> System.out.println(x);
        c1.accept("Anne");

        Predicate<String> stringVazia = x -> x.isEmpty();
        System.out.println(stringVazia.test(""));


        BiPredicate<String, String> verificaPrefixo = (string, prefix) -> string.startsWith(prefix);
        System.out.println(verificaPrefixo.test("cachorro", "cacho"));  // true


        Function<String, Integer> funcao1 = x -> x.length();
        System.out.println(funcao1.apply("sorte"));


        BiFunction<String, String, String> bifunction = (string1, string2) -> string1.concat(string2);
        System.out.println(bifunction.apply("carro ", "novo"));


        UnaryOperator<String> operadorUnario = x -> x.toUpperCase();
        System.out.println(operadorUnario.apply("carro"));  // CARRO


        BinaryOperator<String> operadorBinario = (string1, string2) -> string1.concat(string2);
        System.out.println(operadorBinario.apply("carro ", "velho")); // carro velho


    }


}
