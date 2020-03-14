package com.daniel.hora;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hora hora = new Hora(23,59,30);
		Hora hora1 = new Hora(0,0,0);
		Hora hora2 = new Hora(1, 0, 0);
		Hora hora3 = new Hora(22,59,30);
		Hora hora4 = new Hora(22,59,31);
		Hora hora5 = new Hora(22,59,30);
		Hora hora6 = new Hora(22,59,30);
		Hora hora7 = new Hora(23,59,30);
		
		System.out.println("Mostrar las horas");
		hora.mostrar();
		hora1.mostrar();
		hora2.mostrar();
		hora3.mostrar();
		hora4.mostrar();
		hora5.mostrar();
		hora6.mostrar();
		hora7.mostrar();
		System.out.println("");
		
		System.out.println("Minutos trascurridos desde la media noche"); 
		hora.aMinutos();
		hora1.aMinutos();
		hora2.aMinutos();
		System.out.println("");
		
		System.out.println("Hora correspondiente a los minutos desde la media noche");
		hora1.deMinutos(1439);
		System.out.println("");
		
		System.out.println("Los minutos trascurridos");
		hora1.minutosDesde(hora2);
		System.out.println("");
		
		System.out.println("Siguiente hora");
		hora6.siguiente();
		hora7.siguiente();
		hora1.siguiente();
		System.out.println("");
		
		System.out.println("Hora anterior");
		hora.anterior();
		hora1.anterior();
		hora2.anterior();
		System.out.println("");
		
		System.out.println("Igualdad entre horas");
		System.out.println(hora3.igualQue(hora5));
		System.out.println("");
		
		System.out.println("Menor que");
		System.out.println(hora3.menorQue(hora4));
		System.out.println("");
		
		System.out.println("Mayor que");
		System.out.println(hora4.mayorQue(hora5));
		
		
	}

}
