package com.daniel.Desafio_2;

public abstract class  Empleado {

	private String nombre;

	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	public  String getNombre() {
		return nombre;
	}
	
	protected abstract double calcularSalario();
}
