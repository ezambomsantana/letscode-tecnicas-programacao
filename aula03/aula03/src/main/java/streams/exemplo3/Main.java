package streams.exemplo3;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(5,3,6,8,9,1,2,43,10,8);

        Integer value = ints
                .stream()
                .reduce((x, y) -> x + y)
                .get();

        System.out.println(value);

        value = ints
                .stream()
                .map(x -> x * 2)
                .reduce((x, y) -> x + y)
                .get();

        System.out.println(value);


        value = ints
                .stream()
                .distinct()
                .map(x -> x * 2)
                .reduce((x, y) -> x + y)
                .get();

        System.out.println(value);

        value = ints
                .stream()
                .filter(x -> x > 10)
                .map(x -> x * 2)
                .reduce((x, y) -> x + y)
                .get();

        System.out.println(value);


        value = ints
                .stream()
                .map(x -> x * 2)
                .limit(5)
                .reduce((x, y) -> x + y)
                .get();

        System.out.println(value);

        ints
                .stream()
                .sorted()
                .forEach(x -> System.out.println(x));


    }


}
