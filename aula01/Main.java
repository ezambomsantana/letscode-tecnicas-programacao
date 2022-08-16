package testes;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // now
        LocalDate data = LocalDate.now();
        LocalTime horario = LocalTime.now();

        System.out.println(data);
        System.out.println(horario);

        LocalDateTime dataHora = LocalDateTime.of(data, horario);
        System.out.println("Data e hora usando LocalDateTime.of(data, horario): " + dataHora);

        dataHora = LocalDateTime.now();
        System.out.println("Data e hora usando LocalDateTime.now(): " + dataHora);

        // of

        LocalDate dataInicio = LocalDate.of(2022, 01, 01);
        LocalDate dataFim = LocalDate.parse("2022-01-30");
        System.out.println("Ferias de " + dataInicio + " ate " + dataFim);

        LocalTime horaInicio = LocalTime.of(8,15,30);
        LocalTime horaFim = LocalTime.parse("09:47:55");
        System.out.println("Intervalo de " + horaInicio + " ate " + horaFim);

        LocalDateTime dataHoraInicio = LocalDateTime.of(2022, 12,15, 1, 22, 43);
        LocalDateTime dataHoraFim = LocalDateTime.parse("2022-12-20T05:45:43");
        System.out.println("Recesso de " + dataHoraInicio + " ate " + dataHoraFim);


        // date formatter

        String strDataFormatoBR = "25-06-1980 11:15";
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dataHoraBR = LocalDateTime.parse(strDataFormatoBR, formatoData);
        System.out.println("Data e hora extraidos do formato BR: " + dataHoraBR);

        DateTimeFormatter outroFormato = DateTimeFormatter.ofPattern("dd MM yy - HH, mm");
        System.out.println("Outros formatos: " + dataHoraBR.format(outroFormato));

        System.out.println("Exibir outro formato: " + LocalDateTime.now().format(outroFormato));

        // leitura user

        Scanner scanner = new Scanner(System.in);
        String dataUsuario = scanner.nextLine();
        LocalDateTime dataUsuarioDate = LocalDateTime.parse(dataUsuario, formatoData);
        System.out.println("Data e hora extraidos do formato BR: " + dataUsuarioDate);

        // operacoes

        LocalDate dataNascimento = LocalDate.of(1980, 6, 25);
        System.out.println("Dia da Semana: " + dataNascimento.getDayOfWeek());
        System.out.println("Três dias antes: " + dataNascimento.minusDays(3));
        System.out.println("Três dias depois: " + dataNascimento.plusDays(3));

        LocalDate dezAnos = dataNascimento.plusYears(10);
        System.out.println("Dez anos depois: " + dezAnos);
        System.out.println(dezAnos.getDayOfWeek());




        // timezones
        LocalDateTime dateTime = LocalDateTime.now();

        ZonedDateTime zonedDateTimeSP = ZonedDateTime.of(dateTime, ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime zonedDateTimeAC = ZonedDateTime.of(dateTime, ZoneId.of("Brazil/Acre"));
        ZonedDateTime zonedDateTimePT = ZonedDateTime.of(dateTime, ZoneId.of("Europe/Lisbon"));

        System.out.println("Data hora fuso SP: " + zonedDateTimeSP);
        System.out.println("Data hora fuso AC: " + zonedDateTimeAC);
        System.out.println("Data hora fuso PT: " + zonedDateTimePT);

        // horario de verao

        dateTime = LocalDateTime.parse("2018-05-01T05:00:00");
        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
        zonedDateTimeSP = ZonedDateTime.of(dateTime, zoneId);

        boolean isDaylightSaving = zoneId.getRules().isDaylightSavings(zonedDateTimeSP.toInstant());
        System.out.println("Em " + zonedDateTimeSP + " SP estava em horario de verao: " + isDaylightSaving);

        dateTime = LocalDateTime.parse("2018-12-01T05:00:00");
        zonedDateTimeSP = ZonedDateTime.of(dateTime, zoneId);
        isDaylightSaving = zoneId.getRules().isDaylightSavings(zonedDateTimeSP.toInstant());
        System.out.println("Em " + zonedDateTimeSP + " SP estava em horario de verao: " + isDaylightSaving);


        // data ajustada
        dateTime = LocalDateTime.parse("2018-05-01T05:00:00");
        zonedDateTimeSP = ZonedDateTime.of(dateTime, ZoneId.of("America/Sao_Paulo"));
        System.out.println("O dia " + zonedDateTimeSP + " foi no dia da semana: " + zonedDateTimeSP.getDayOfWeek());

        ZonedDateTime nextFridayDateTime = zonedDateTimeSP.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("A data da proxima SEXTA foi: " + nextFridayDateTime);

        System.out.println("Primeiro dia do mes: " + LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("Ultimo dia do mes: " + LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()));



        // start - fim
        ZonedDateTime startDateTime = ZonedDateTime.of(2022, 4, 8, 13, 35, 56, 0, ZoneId.of("America/Sao_Paulo"));

        Period period = Period.ofMonths(3);
        ZonedDateTime endDateTime = startDateTime.plus(period);

        System.out.println("Inicio da Atividade: " + startDateTime);
        System.out.println("Fim da Atividade (+ 3 meses): " + endDateTime);

        System.out.println("\nFim da Atividade com horario de Portugal: " + endDateTime.withZoneSameInstant(ZoneId.of("Europe/Lisbon")));




        // duração

        LocalTime begins = LocalTime.of(12, 07, 10);
        LocalTime ends = LocalTime.of(14, 22, 37);
        System.out.println("Intervalo: " + begins + " - " + ends);

        long minutes = ChronoUnit.MINUTES.between(begins, ends);
        System.out.println("Total minutos: " + minutes);

        Duration duration = Duration.ofMinutes(minutes);
        System.out.println("Duracao do intervalo: " + duration.getSeconds());


        ZonedDateTime eventDateTime = ZonedDateTime.of(1998, 1, 13, 16, 45, 56, 0, ZoneId.of("America/Sao_Paulo"));
        Instant eventInstant = eventDateTime.toInstant();
        System.out.println("Data e hora do evento: " + eventDateTime);
        System.out.println("Instante do evento: " + eventInstant);

        System.out.println("\nNumero de segundos de 01-Janeiro-1970 ate o inicio do evento: " + eventInstant.getEpochSecond());


        Locale locBR = new Locale("pt", "BR");
        Locale locJA = new Locale("ja");
        Locale locUS = new Locale("US");

        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        System.out.println("Formato longo: ");
        System.out.println("Brasil: " +
                zonedDateTime.format(
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)
                                .withLocale(locBR)));
        System.out.println("Japao: " +
                zonedDateTime.format(
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)
                                .withLocale(locJA)));
        System.out.println("USA: " +
                zonedDateTime.format(
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)
                                .withLocale(locUS)));

        System.out.println("\nFormato curto: ");
        System.out.println("Brasil: " +
                zonedDateTime.format(
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                                .withLocale(locBR)));
        System.out.println("Japao: " +
                zonedDateTime.format(
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                                .withLocale(locJA)));
        System.out.println("USA: " +
                zonedDateTime.format(
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                                .withLocale(locUS)));

    }


}
