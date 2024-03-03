package application;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args){

        DateTimeFormatter format01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format02 = DateTimeFormatter.ofPattern("dd/LLLL/yyyy hh:mm");
        DateTimeFormatter format03 = DateTimeFormatter.ofPattern("dd/LLL/yy HH:mm").withZone(ZoneId.systemDefault());

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();

        LocalDate d04 = LocalDate.parse("2024-03-03");
        LocalDateTime d05 =LocalDateTime.parse("2024-03-20T00:01");
        Instant d06 = Instant.parse("2024-02-20T12:47:00Z");
        Instant d07 = Instant.parse("2024-07-12T23:30:00-03:00");

        LocalDate r1 = LocalDate.ofInstant(d07,ZoneId.systemDefault());
        LocalDateTime r2 = LocalDateTime.ofInstant(d06,ZoneId.systemDefault());

        LocalDate d08 = LocalDate.parse("20/03/2017", format01);
        LocalDate d09 = LocalDate.of(2017,5,28);
        System.out.println("d01: " + d01);
        System.out.println("d02: " + d02);
        System.out.println("d03: " + d03);
        System.out.println("d04: " + d04.format(format01));
        System.out.println("d05: " + d05.format(format02));
        System.out.println("d06: " + format03.format(d06));
        System.out.println("d07: " + d07);
        System.out.println("d08: " + d08);
        System.out.println("d09: " + d09);
        System.out.println("r1: " + r1.format(format01));
        System.out.println("r2: " + r2.format(format03));
        System.out.println("--------------------------------------------");
        System.out.println("d02:");
        System.out.print("Dia: " + d02.getDayOfMonth());
        System.out.print(", Mês: " + d02.getMonth());
        System.out.print(", Ano: " + d02.getYear());
        System.out.print("\nHora: " + d02.getHour());
        System.out.println(", Minuto: " + d02.getMinute());
        System.out.println("----------------------------------------------");

        LocalDate pastWeekLocalDate = d01.minusDays(7);
        LocalDateTime pastWeekLocalDateTime = d02.minusDays(7);
        Instant pastWeekInstant = d03.minus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekLocalDate: " + pastWeekLocalDate.format(format01));
        System.out.println("pastWeekLocalDateTime: " + pastWeekLocalDateTime.format(format02));
        System.out.println("pastWeekInstant: " + format03.format(pastWeekInstant));

        Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d01.atStartOfDay());
        Duration t2 = Duration.between(pastWeekLocalDateTime, d02);
        Duration t3 = Duration.between(pastWeekInstant, d03);

        System.out.println("t1: " + t1.toDays());
        System.out.println("t2: " + t2.toHours());
        System.out.println("t3: " + t3.toMinutes());

    }
}
