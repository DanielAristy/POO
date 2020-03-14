package com.daniel.clase7;

public class cafetera {

	public int capacidad = 100;
	public int cantidadActual;
	public String marca;
	
	public void servir(int cantidadAServir) {
		if(cantidadAServir > cantidadActual) {
			System.out.println("No existe café para satisfacer esa cantidad");
		} else {
			cantidadActual = cantidadActual - cantidadAServir;
			System.out.println("Café listo, disfrute!");
		}
	}
	
	public void llenar() {
		if(cantidadActual < capacidad) {
			cantidadActual = capacidad;
			System.out.println("Listo, la cafetera fue llenada.");
		} else {
			System.out.println("La cafetera ya está llena.");
		}
	}
	
	public void vaciar() {
		cantidadActual = 0;
		System.out.println("Cafetera vaciada.");
	}
}
