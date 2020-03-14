package com.daniel.Singleton;

public class Main {

	public static void main(String[] args) {
		
		crearPersona crear1 = crearPersona.getInstancia();
		crearPersona crear2 = crearPersona.getInstancia();
		crearPersona crear3 = crearPersona.getInstancia();
		crearPersona crear4 = crearPersona.getInstancia();
		crearPersona crear5 = crearPersona.getInstancia();
		crearPersona crear6 = crearPersona.getInstancia();
		crearPersona crear7 = crearPersona.getInstancia();


		System.out.println(crear7);
		System.out.println(crear6);
		System.out.println(crear1);

	}

}
