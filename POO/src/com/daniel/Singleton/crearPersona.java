package com.daniel.Singleton;

/**
 * Patron Singleton
 * creando una instancia de un objeto*/
public class crearPersona {

	private static crearPersona crear;
	public static final int CONTADOR_PRIN = 1;
	public static int cont;
	private Persona persona;
	
	private crearPersona() {
		++cont;
		persona = new Persona();
		System.out.println("objeto: "+cont);
	}
	
	public static crearPersona getInstancia() {
		if(crear == null && cont < CONTADOR_PRIN) {
			crear = new crearPersona();
		}
		return crear = null;
	}
}
