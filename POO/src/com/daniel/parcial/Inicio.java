package com.daniel.parcial;

public class Inicio {
	
	public static void main(String[] args) {
		
		Fecha fecha = new Fecha();
		Fecha fecha1 = new Fecha(30, 12, 2020);
		Fecha fecha2 = new Fecha(28, 12, 2019);
		Fecha fecha3 = new Fecha(28, 12, 2020);
		
		fecha.mostrar();
		fecha1.mostrar();
		fecha.getNombreDias();
		fecha1.getNombreMes();
		fecha1.tomorrow();
		fecha1.mostrar();
		System.out.println(fecha2.comparar(fecha3));
	}
}
