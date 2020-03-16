package com.daniel.repasoJava;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main{

    public static class Gasto {
        String nombre;
        int valor;
        String descripcion;

        public Gasto(String nombre, int valor, String descripcion) {
            this.nombre = nombre;
            this.valor = valor;
            this.descripcion = descripcion;
        }

        public Gasto(String nombre, int valor) {
            this.nombre = nombre;
            this.valor = valor;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }
    }

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

        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7);

        /**
         * Suma de una cadena usando expresiones lambda*/
        int suma = numeros.stream().reduce(0,(x,y) -> x+y);

        /**Impresion por consola de datos*/
        numeros.forEach(l -> System.out.println(l));

        /**
         * Multiplicacion de todos los datos del Array*/
        int multiplicacion = numeros.stream().reduce(1,(x,y) -> x * y);
        int MAYOR = numeros.stream().reduce(1,Integer::max);
        int MENOR = numeros.stream().reduce(1,Integer::min);

        /**
         * Obtiene el numero mayor par*/
        Optional<Integer> mayor = numeros.stream().filter(x -> x % 2 == 0).reduce(Integer::max);

        System.out.println("suma: " + suma);
        System.out.println("multiplicacion: " + multiplicacion);
        System.out.println("Mayor: " + MAYOR);
        System.out.println("Menor: " + MENOR);
        System.out.println("Mayor Par: " + mayor.get());

        /**
         * Streams con clases*/

        ArrayList<Gasto> gatos = new ArrayList<>();

        gatos.add(new Gasto("IVA",1200));
        gatos.add(new Gasto("GP",1000,"Gastos publicos"));
        gatos.add(new Gasto("TI",1100,"Televison e internet"));


        /**
         * En este caso coge el valor de cada precio del gato y suma los valores de ellos que sean
         * mayores o iguales a 1000*/
        double resultado = gatos.stream().mapToDouble(gato->gato.valor).filter(gato->gato>=1000).sum();

        int resultadoGatos = gatos.stream().mapToInt(gato -> gato.valor -100).sum();
        System.out.println(resultado);
        System.out.println(resultadoGatos);
        
    }
}