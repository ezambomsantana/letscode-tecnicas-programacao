package vendas;

import campeonato.Partida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Stream<Path> arquivos = Files.list(Path.of("/Users/eduardosantana/letscode/vendas"));
        Path arquivoResultado = Path.of("resultado.txt");

        Files.deleteIfExists(arquivoResultado);
        Files.createFile(arquivoResultado);

        List<Venda> todasVendas = new ArrayList<>();

        arquivos
                .forEach(arquivo -> {
                    try {

                        Files.writeString(arquivoResultado, "\n" + arquivo.getFileName().toString(), StandardOpenOption.APPEND);
                        System.out.println(arquivo.getFileName());
                        Double valorTotal = Files.lines(arquivo.toAbsolutePath())
                                .skip(1)
                                .map(venda -> mapToVenda(venda, arquivo.getFileName().toString()))
                                .mapToDouble(venda -> venda.getPreco())
                                .sum();
                        System.out.println(valorTotal);
                        Files.writeString(arquivoResultado, "\n" + String.valueOf(valorTotal), StandardOpenOption.APPEND);



                        Double valorTotalManha = Files.lines(arquivo.toAbsolutePath())
                                .skip(1)
                                .map(venda -> mapToVenda(venda, arquivo.getFileName().toString()))
                                .filter(venda -> venda.getDataCompra().getHour() < 12)
                                .mapToDouble(venda -> venda.getPreco())
                                .sum();
                        System.out.println(valorTotalManha);
                        Files.writeString(arquivoResultado, "\n" + String.valueOf(valorTotalManha), StandardOpenOption.APPEND);


                        Map<String, Long> vendasComprador = Files.lines(arquivo.toAbsolutePath())
                                .skip(1)
                                .map(venda -> mapToVenda(venda, arquivo.getFileName().toString()))
                                .collect(Collectors.groupingBy(venda -> venda.getComprador(), Collectors.counting()));
                        System.out.println(vendasComprador);
                        Files.writeString(arquivoResultado, "\n" + vendasComprador, StandardOpenOption.APPEND);


                        todasVendas.addAll(Files.lines(arquivo.toAbsolutePath())
                                .skip(1)
                                .map(venda -> mapToVenda(venda, arquivo.getFileName().toString()))
                                .collect(Collectors.toList()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        System.out.println("Todas as vendas");
        Files.writeString(arquivoResultado, "\n Todas as Vendas", StandardOpenOption.APPEND);
        Double valorTotal =  todasVendas
                .stream()
                .mapToDouble(venda -> venda.getPreco())
                .sum();
        System.out.println(valorTotal);
        Files.writeString(arquivoResultado, "\n" + String.valueOf(valorTotal), StandardOpenOption.APPEND);

        Double valorTotalManha = todasVendas
                .stream()
                .filter(venda -> venda.getDataCompra().getHour() < 12)
                .mapToDouble(venda -> venda.getPreco())
                .sum();
        System.out.println(valorTotalManha);
        Files.writeString(arquivoResultado, "\n" + String.valueOf(valorTotalManha), StandardOpenOption.APPEND);

        Map<String, Long> vendasComprador = todasVendas
                .stream()
                .collect(Collectors.groupingBy(venda -> venda.getComprador(), Collectors.counting()));
        System.out.println(vendasComprador);
        Files.writeString(arquivoResultado, "\n" + vendasComprador, StandardOpenOption.APPEND);

    }

    private static Venda mapToVenda(String vendaString, String data) {
        String dados[] = vendaString.split(",");
        Venda venda = new Venda();
        venda.setComprador(dados[1]);
        venda.setNumeroItens(Integer.parseInt(dados[2]));
        venda.setPreco(Float.parseFloat(dados[3]));
        venda.setCaixa(Integer.parseInt(dados[4]));

        data = data.replace(".csv", "");

        venda.setDataCompra(LocalDateTime.parse(data + " " + dados[5],
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));

        return venda;
    }

    private static Partida mapToPartida(String partidaString) {
        String dados[] = partidaString.split(",");
        Partida partida = new Partida();
        partida.setMandante(dados[5]);
        partida.setVisitante(dados[6]);
        return partida;


    }
}
