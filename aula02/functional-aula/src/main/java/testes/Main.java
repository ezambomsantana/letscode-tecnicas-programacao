package testes;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Classes de data - now
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        LocalDateTime dateTime2 = LocalDateTime.of(date, time);
        System.out.println(dateTime2);

        // Classe de data - of - parse
        LocalDate dateOf = LocalDate.of(1880, 10, 10);
        System.out.println(dateOf);

        LocalDate dateParse = LocalDate.parse("2022-02-28");
        System.out.println(dateParse);

        LocalTime localTime = LocalTime.of(5, 20, 10);
        System.out.println(localTime);

        LocalTime localTimeParse = LocalTime.parse("11:20");
        System.out.println(localTimeParse);

        LocalDateTime localDateTime = LocalDateTime.of(2022, 12, 15, 5, 10, 10);
        System.out.println(localDateTime);

        LocalDateTime localDateTimeParse = LocalDateTime.parse("2022-12-15T05:10:10");
        System.out.println(localDateTimeParse);

        // Formatação

        String dataString = "20/10/2022 11:15";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime localDateTimeString = LocalDateTime.parse(dataString, formatter);
        System.out.println(localDateTimeString);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd MM - HH E");
        System.out.println(localDateTimeString.format(formatter2));

        // leitura do usuario

       // Scanner scanner = new Scanner(System.in);
       // String dataUsuario = scanner.nextLine();
       // LocalDateTime localDateTimeUsuario = LocalDateTime.parse(dataUsuario, formatter);
       // System.out.println(localDateTimeUsuario);

        // Operacoes

        LocalDate dataNascimento = LocalDate.of(1000, 7, 5);
        System.out.println(dataNascimento);

        System.out.println(dataNascimento.plusDays(10));
        System.out.println(dataNascimento.plusYears(10));
        System.out.println(dataNascimento.plusWeeks(10));
        System.out.println(dataNascimento.minusDays(10));
        System.out.println(dataNascimento.getDayOfWeek());


        LocalDateTime dateTimeZone = LocalDateTime.of(2022, 1, 1, 1,1,1);
        ZonedDateTime zonedDateTimeSP = ZonedDateTime.of(dateTimeZone, ZoneId.of("America/Sao_Paulo"));
        System.out.println(zonedDateTimeSP);

        ZonedDateTime zonedDateTimeAcre = ZonedDateTime.of(dateTimeZone, ZoneId.of("Brazil/Acre"));
        System.out.println(zonedDateTimeAcre);

        ZonedDateTime zonedDateTimeEurope = ZonedDateTime.of(dateTimeZone, ZoneId.of("Europe/Lisbon"));
        System.out.println(zonedDateTimeEurope);


        // horario de verao
        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
        boolean isHorarioVerao = zoneId.getRules().isDaylightSavings(zonedDateTimeSP.toInstant());
        System.out.println("data " + zonedDateTimeSP + " ta no horario de verao: " + isHorarioVerao);


        // Ajuste de data

        LocalDateTime localDateTimeAjuste = LocalDateTime.parse("2018-05-08T05:10:10");
        System.out.println(localDateTimeAjuste.getDayOfWeek());

        System.out.println(localDateTimeAjuste.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));

        System.out.println(localDateTimeAjuste.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(localDateTimeAjuste.with(TemporalAdjusters.lastDayOfMonth()));

        System.out.println(localDateTimeAjuste.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));

        // period
        ZonedDateTime start = ZonedDateTime.of(2022, 10, 11, 10, 20, 30, 0, ZoneId.of("America/Sao_Paulo"));

        Period period = Period.ofWeeks(10);
        ZonedDateTime end = start.plus(period);

        System.out.println("inicio: " + start + " fim: " + end);

        ZonedDateTime dataSP = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println(dataSP);

        System.out.println(dataSP.withZoneSameInstant(ZoneId.of("Europe/Lisbon")));

        // duração
        LocalTime inicio = LocalTime.now();
        LocalTime fim = inicio.plusHours(2);

        System.out.println(inicio);
        System.out.println(fim);

        long minutes = ChronoUnit.MINUTES.between(inicio, fim);
        System.out.println(minutes);

        Duration duration = Duration.ofMinutes(minutes);
        System.out.println(duration.getSeconds());


        LocalDateTime localDateTimeInicio = LocalDateTime.now();
        LocalDateTime localDateTimeFim = localDateTimeInicio.minusYears(20);

        long anos = ChronoUnit.MILLIS.between(localDateTimeFim, localDateTimeInicio);
        System.out.println(anos);

        Locale locale = new Locale("pt", "BR");
        Locale localePT = new Locale("pt", "PT");
        Locale localeJP = new Locale("ja", "JP");
        Locale localeUS = new Locale("en", "US");

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Lisbon"));

        System.out.println("Brasil: " +
                zonedDateTime.format(
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                                .withLocale(locale))
                );

        System.out.println("Portugal: " +
                zonedDateTime.format(
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                                .withLocale(localePT))
        );

        System.out.println("Japão: " +
                zonedDateTime.format(
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                                .withLocale(localeJP))
        );

        System.out.println("US: " +
                zonedDateTime.format(
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                                .withLocale(localeUS))
        );

        // Um financiamento tem parcelas de 400 reais mensais, a data da primeira parcela
        // é 16/08/2022 e a final é 16/08/2024 qual o valor total do pagamento.
        LocalDate inicioFinaciamento = LocalDate.parse("2022-08-16");
        LocalDate fimFinanciamento = LocalDate.parse("2024-08-16");

        long meses = ChronoUnit.MONTHS.between(inicioFinaciamento, fimFinanciamento);
        System.out.println(meses);
        System.out.println(400 * meses);


        // exercicio 2 -> preciso de um filtro de datas em que a partir de uma data digitada pelo usuário,
        // pegue o dia de inicio da semana da data e o dia final da mesma semana.

        Scanner scanner = new Scanner(System.in);
       // String dataFiltro = scanner.nextLine();

       // LocalDate localDateFiltro = LocalDate.parse(dataFiltro);
       // System.out.println(localDateFiltro);
      //  System.out.println(localDateFiltro.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)));
      //  if (localDateFiltro.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
      //      System.out.println(localDateFiltro);
      //  } else {
      //      System.out.println(localDateFiltro.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)));
      //  }

        // exercicio 3 -> Calcule quantos meses falta para terminar o ano.

        System.out.println(12 - LocalDate.now().getMonthValue());




        // exercício 4 - Calcule a sua idade exata, com anos, meses e dias.

        LocalDate dataNascimentoEx1 = LocalDate.parse("1985-05-05");
        LocalDate agora = LocalDate.now();

        Period diferenca = Period.between(dataNascimentoEx1, agora);

        System.out.println("Anos: " + diferenca.getYears()
                + " Meses: " + diferenca.getMonths()
                + " Dias: " + diferenca.getDays());

        // exercício 5 - Calcule exatamente quantos meses e dias faltam para terminar o ano.
        LocalDate hoje = LocalDate.now();
        LocalDate ultimoDiaAno = LocalDate.parse("2023-01-01");

        diferenca = Period.between(hoje, ultimoDiaAno);

        System.out.println("Anos: " + diferenca.getYears()
                + " Meses: " + diferenca.getMonths()
                + " Dias: " + diferenca.getDays());

        // exercício 6 - Descubra o dia da semana do primeiro e ultimo mes do ano.

        LocalDate primeiro = LocalDate.parse("2022-01-01");
        LocalDate ultimo = LocalDate.parse("2022-12-31");

        System.out.println(primeiro.getDayOfWeek().name());
        System.out.println(ultimo.getDayOfWeek().name());

        YearMonth yearMonth = YearMonth.of(2023, 1);
        System.out.println(yearMonth.atDay(1).getDayOfWeek().name());


        yearMonth = YearMonth.of(2023, 12);
        System.out.println(yearMonth.atEndOfMonth().getDayOfWeek().name());


    }


}
