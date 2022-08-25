package aula03.fuctional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        Supplier<LocalTime> supplier = () -> LocalTime.now();
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());

        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(5);

        Predicate<String> predicate = x -> x.isEmpty();
        System.out.println(predicate.test("abc"));
        System.out.println(predicate.test(""));

        UnaryOperator<Integer> unaryOperator = num1 -> num1 * 3;
        System.out.println(unaryOperator.apply(5));
    }
}
