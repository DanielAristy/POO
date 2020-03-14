package com.daniel.repasoJava;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.logging.SimpleFormatter;

public class Main{

    public static void main(String[] args) {

        int day, month, year;

        Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        System.out.println(calendar.getTime());

        String dates = day + "/" + month + "/" + year;

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formato.format(calendar.getTime());
        System.out.println(fecha);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ahora = LocalDate.now();
        LocalDate fechaNac = LocalDate.parse(fecha, fmt);


        Period periodo = Period.between(fechaNac, ahora);
        System.out.printf("Tu edad es: %s year, %s months y %s days",
                periodo.getYears(), periodo.getMonths(), periodo.getDays());
        
    }
}
