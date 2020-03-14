package com.daniel.Singleton;

public class Persona {
	private String nombre;
	private String apellido;
	
	public Persona() {
		this.nombre = "Daniel";
		this.apellido = "Aristizabal";
	}

	protected String getNombre() {
		return nombre;
	}

	protected String getApellido() {
		return apellido;
	}
	
	
	
}
