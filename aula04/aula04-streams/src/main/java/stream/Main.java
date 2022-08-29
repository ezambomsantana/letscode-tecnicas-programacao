package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("population.csv");

        Stream<String> stream = Files.lines(path);
        Map<String, List<Pais>> map = stream
                .skip(1)
                .map(pais -> mapToPais(pais))
                .collect(Collectors.groupingBy(pais -> pais.getContinente()));


        stream = Files.lines(path);
        Map<String, DoubleSummaryStatistics> mapSoma = stream
                .skip(1)
                .map(pais -> mapToPais(pais))
                .collect(
                        Collectors.groupingBy(pais -> pais.getContinente(),
                        Collectors.summarizingDouble(pais -> pais.getPorcentagem()))
                );
        System.out.println(mapSoma);

        /* map
                .keySet()
                .stream()
                .forEach(continente -> {
                    System.out.println("########## " + continente);
                    try {
                        listaPaises(path, continente);
                        somaPopulacao(path, continente);
                        calculaMedia(path, continente);
                        achaMaiorPais(path, continente);
                        achaMenorPais(path, continente);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
*/

    }

    private static void achaMenorPais(Path path, String continente) throws IOException {
        Stream<String> stream;
        stream = Files.lines(path);
        Optional<Pais> min = stream
                .skip(1)
                .map(pais -> mapToPais(pais))
                .filter(pais -> pais.getContinente().equals(continente))
                .min((p1, p2) -> p1.getPopulacao().compareTo(p2.getPopulacao()));
        System.out.println(min.get().getNome());
    }

    private static void achaMaiorPais(Path path, String continente) throws IOException {
        Stream<String> stream;
        stream = Files.lines(path);
        Optional<Pais> max = stream
                .skip(1)
                .map(pais -> mapToPais(pais))
                .filter(pais -> pais.getContinente().equals(continente))
                .max((p1, p2) -> p1.getPopulacao().compareTo(p2.getPopulacao()));
        System.out.println(max.get().getNome());
    }

    private static void calculaMedia(Path path, String continente) throws IOException {
        Stream<String> stream;
        stream = Files.lines(path);
        double media = stream
                .skip(1)
                .map(pais -> mapToPais(pais))
                .filter(pais -> pais.getContinente().equals(continente))
                .mapToInt(pais -> pais.getPopulacao())
                .average().getAsDouble();
        System.out.println(media);
    }

    private static void somaPopulacao(Path path, String continente) throws IOException {
        Stream<String> stream;
        stream = Files.lines(path);
        int sum = stream
                .skip(1)
                .map(pais -> mapToPais(pais))
                .filter(pais -> pais.getContinente().equals(continente))
                .map(pais -> pais.getPopulacao())
                .reduce((p1, p2) -> p1 + p2)
                .get();

        System.out.println(sum);
    }

    private static void listaPaises(Path path, String continente) throws IOException {
        Stream<String> stream;
        // filtrar os pais da europa
        stream = Files.lines(path);
        stream
                .skip(1)
                .map(pais -> mapToPais(pais))
                .filter(pais -> pais.getContinente().equals(continente))
                .forEach(pais -> System.out.println(pais.getNome()));
    }

    private static Pais mapToPais(String pais) {

        String [] data = pais.split(",");

        Pais p = new Pais();
        p.setNome(data[1]);
        p.setContinente(data[2]);
        p.setPopulacao(Integer.parseInt(data[3]));
        p.setPorcentagem(Float.parseFloat(data[4].replace("%", "")));
        p.setData(YearMonth.parse(data[5], DateTimeFormatter.ofPattern("yy-MMM")));
        return p;

    }


}
