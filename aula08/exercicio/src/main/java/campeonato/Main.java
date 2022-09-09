package campeonato;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        Path campeonato = Path.of("/Users/eduardosantana/campeonato-brasileiro-full.csv");

        Path resultado = Path.of("resultado.txt");
        Files.deleteIfExists(resultado);
        Files.createFile(resultado);

        Long count = Files.lines(campeonato.toAbsolutePath())
                .skip(1)
                .count();
        System.out.println("1) " + count);
        Files.writeString(resultado, "1) " + count + "\n", StandardOpenOption.APPEND);

        Integer gols = Files.lines(campeonato.toAbsolutePath())
                .skip(1)
                .map(p -> mapToPartida(p))
                .mapToInt(p -> p.getGolTotal())
                .sum();
        System.out.println("2) " + gols);
        Files.writeString(resultado, "2) " + gols + "\n", StandardOpenOption.APPEND);


        Long empate = Files.lines(campeonato.toAbsolutePath())
                .skip(1)
                .map(p -> mapToPartida(p))
                .filter(p -> p.getVencedor().equals("-"))
                .count();
        System.out.println("13) " + empate);
        Files.writeString(resultado, "13) " + empate + "\n", StandardOpenOption.APPEND);



        Long countAnos = Files.lines(campeonato.toAbsolutePath())
                .skip(1)
                .map(p -> mapToPartida(p))
                .filter(p -> p.getDataPartida().getYear() >= 2010 && p.getDataPartida().getYear() <= 2015)
                .count();
        System.out.println("3) " + countAnos);
        Files.writeString(resultado, "3) " + countAnos + "\n", StandardOpenOption.APPEND);


        Optional<Partida> max = Files.lines(campeonato.toAbsolutePath())
                .skip(1)
                .map(p -> mapToPartida(p))
                .max((x, y) -> x.getGolTotal().compareTo(y.getGolTotal()));
        System.out.println("4) " + max.get().getGolTotal() + " " + max.get().getDataPartida() + " " + max.get().getMandante() + "x" + max.get().getVisitante());
        Files.writeString(resultado, "4) " + max.get().getGolTotal() + " " + max.get().getDataPartida() + " " + max.get().getMandante() + "x" + max.get().getVisitante() + "\n", StandardOpenOption.APPEND);

        Long vMandante = Files.lines(campeonato.toAbsolutePath())
                .skip(1)
                .map(p -> mapToPartida(p))
                .filter(p -> p.getMandante().equals(p.getVencedor()))
                .count();
        System.out.println("8) " + vMandante);
        Files.writeString(resultado, "8) " + vMandante + "\n", StandardOpenOption.APPEND);

        Long vVisitante = Files.lines(campeonato.toAbsolutePath())
                .skip(1)
                .map(p -> mapToPartida(p))
                .filter(p -> p.getVisitante().equals(p.getVencedor()))
                .count();
        System.out.println("9) " + vVisitante);
        Files.writeString(resultado, "9) " + vVisitante + "\n", StandardOpenOption.APPEND);


        Map<Integer, Long> partidasAno = Files.lines(campeonato.toAbsolutePath())
                .skip(1)
                .map(p -> mapToPartida(p))
                .filter(p -> p.getDataPartida().getYear() >= 2003)
                .collect(Collectors.groupingBy(p -> p.getDataPartida().getYear(), Collectors.counting()));
        System.out.println("11)" + partidasAno);
        Files.writeString(resultado, "11) " + partidasAno + "\n", StandardOpenOption.APPEND);

        HashMap<String, Time> timesMap = new HashMap<>();
        Files.lines(campeonato.toAbsolutePath())
                .skip(1)
                .forEach(t -> mapToTime(t, timesMap));

        Optional<Time> maxGols = timesMap
                .values()
                .stream()
                .max((t1, t2) -> t1.getGols().compareTo(t2.getGols()));
        System.out.println("5) " + maxGols.get().getNome() + " " + maxGols.get().getGols());
        Files.writeString(resultado, "5) " + maxGols.get().getNome() + " " + maxGols.get().getGols() + "\n", StandardOpenOption.APPEND);


        Optional<Time> maxGolsTomados = timesMap
                .values()
                .stream()
                .max((t1, t2) -> t1.getGolsTomados().compareTo(t2.getGolsTomados()));
        System.out.println("6) " + maxGolsTomados.get().getNome() + " " + maxGolsTomados.get().getGols());
        Files.writeString(resultado, "6) " + maxGolsTomados.get().getNome() + " " + maxGolsTomados.get().getGols() + "\n", StandardOpenOption.APPEND);


        Optional<Time> maxVitorias = timesMap
                .values()
                .stream()
                .max((t1, t2) -> t1.getVitorias().compareTo(t2.getVitorias()));
        System.out.println("7) " + maxVitorias.get().getNome() + " " + maxVitorias.get().getVitorias());
        Files.writeString(resultado, "7) " + maxVitorias.get().getNome() + " " + maxVitorias.get().getVitorias() + "\n", StandardOpenOption.APPEND);

        Optional<Time> maxDerrotas = timesMap
                .values()
                .stream()
                .max((t1, t2) -> t1.getDerrotas().compareTo(t2.getDerrotas()));
        System.out.println("10) " + maxDerrotas.get().getNome() + " " + maxDerrotas.get().getDerrotas());
        Files.writeString(resultado, "10) " + maxDerrotas.get().getNome() + " " + maxDerrotas.get().getDerrotas() + "\n", StandardOpenOption.APPEND);


        timesMap
                .values()
                .stream()
                .forEach(t -> {
                    try {
                        System.out.println(t.getNome() + " " + t.getJogos());
                        Files.writeString(resultado, t.getNome() + " " + t.getJogos() + "\n", StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        /* Map<String, Integer> golsTime = Files.lines(campeonato.toAbsolutePath())
                .skip(1)
                .map(t -> mapToTime(t))
                .collect(Collectors.groupingBy(t -> t.getNome(), Collectors.summingInt(t -> t.getGols())));

        Optional<Integer> maxGols = golsTime
                .values()
                .stream()
                .max((x, y) -> x.compareTo(y));
        System.out.println("5) " + maxGols.get());
        */

        /* Files.lines(campeonato.toAbsolutePath())
                .skip(1)
                .map(dados -> mapToPartida(dados))
                .collect(Collectors.groupingBy(dados-> dados.getVencedor(), Collectors.counting()))
                 .values()
                 .stream()
                 .max((x, y) -> x.compareTo(y)); */
    }

    private static void mapToTime(String t, HashMap<String, Time> timesMap) {
        String [] data = t.split(",");

        String mandante = data[5];
        String vencedor = data[11];
        if (timesMap.get(mandante) != null) {
            Time time = timesMap.get(mandante);
            time.setGols(time.getGols() + Integer.parseInt(data[13]));
            time.setGolsTomados(time.getGolsTomados() + Integer.parseInt(data[14]));
            if (mandante.equals(vencedor)) {
                time.setVitorias(time.getVitorias() + 1);
            } else if (!vencedor.equals("-")){
                time.setDerrotas(time.getDerrotas() + 1);
            }
            time.setJogos(time.getJogos() + 1);
        } else {
            Time time = new Time();
            time.setNome(mandante);
            time.setGols(Integer.parseInt(data[13]));
            time.setGolsTomados(Integer.parseInt(data[14]));
            if (mandante.equals(vencedor)) {
                time.setVitorias(1);
            } else if (!vencedor.equals("-")){
                time.setDerrotas(time.getDerrotas() + 1);
            }
            time.setJogos(1);
            timesMap.put(mandante, time);
        }

        String visitante = data[6];
        if (timesMap.get(visitante) != null) {
            Time time = timesMap.get(visitante);
            time.setGols(time.getGols() + Integer.parseInt(data[14]));
            time.setGolsTomados(time.getGolsTomados() + Integer.parseInt(data[13]));
            if (visitante.equals(vencedor)) {
                time.setVitorias(time.getVitorias() + 1);
            } else if (!vencedor.equals("-")){
                time.setDerrotas(time.getDerrotas() + 1);
            }
            time.setJogos(time.getJogos() + 1);
        } else {
            Time time = new Time();
            time.setNome(visitante);
            time.setGols(Integer.parseInt(data[14]));
            time.setGolsTomados(Integer.parseInt(data[13]));
            if (visitante.equals(vencedor)) {
                time.setVitorias(1);
            } else if (!vencedor.equals("-")){
                time.setDerrotas(time.getDerrotas() + 1);
            }
            time.setJogos(1);
            timesMap.put(visitante, time);
        }

    }

    private static Partida mapToPartida(String p) {
        String [] data = p.split(",");

        // 1,1,2003-03-29,16:00,Sabado,Guarani,Vasco,,,,,Guarani,brinco de ouro,4,2,SP,RJ,SP

        Partida partida = new Partida();
        partida.setPlacarMandante(Integer.parseInt(data[13]));
        partida.setPlacarVisitante(Integer.parseInt(data[14]));
        partida.setGolTotal(partida.getPlacarMandante() + partida.getPlacarVisitante());
        partida.setDataPartida(LocalDate.parse(data[2]));
        partida.setMandante(data[5]);
        partida.setVisitante(data[6]);
        partida.setVencedor(data[11]);

        if (partida.getPlacarMandante() > partida.getPlacarVisitante()) {
            partida.setTipoVencedor("mandante");
        } else if (partida.getPlacarVisitante() > partida.getPlacarMandante()) {
            partida.setTipoVencedor("visitante");
        } else {
            partida.setTipoVencedor("empate");
        }

        return partida;
    }


}
