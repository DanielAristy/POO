package com.daniel.clase7;

public class DispensadorDeAgua {
	
	public int capacidad = 100;
	public int cantidadActual;
	public String marca;
	
	public void servir(int cantidadAServir) {
		if(cantidadAServir > cantidadActual) {
			System.out.println("No existe agua para satisfacer esa cantidad");
		} else {
			cantidadActual = cantidadActual - cantidadAServir;
			System.out.println("Agua lista, disfrute!");
		}
	}
	
	public void llenar() {
		if(cantidadActual < capacidad) {
			cantidadActual = capacidad;
			System.out.println("Listo, el dispensador fue llenado.");
		} else {
			System.out.println("El dispensador ya está lleno.");
		}
	}
	
	public void vaciar() {
		cantidadActual = 0;
		System.out.println("Dispensador vaciado.");
	}

}
