package com.daniel.CrisDan;

import javax.swing.JOptionPane;

public class Calculadora {

	public static float valor1 = 0;
	public static float valor2 = 0;
	public static final String MENSAJE = "Ingrese un valor";
	public static final String BASE = "Ingrese la base:";
	public static final String EXPONENTE = "Ingrese el exponente";
	public static final String INDICE = "Ingrese el indice";
	public static final String RADICADO = "Ingrese el radicando";
	
	public static void ingresarDatos(String mensaje, String mensaje2) {
		
		valor1 = Float.parseFloat(JOptionPane.showInputDialog(mensaje));
		valor2 = Float.parseFloat(JOptionPane.showInputDialog(mensaje2));		
			
		
	};

	public static void ingresarDato(String mensaje) {
		
		try {
			valor1 = Float.parseFloat(JOptionPane.showInputDialog(mensaje));
		} catch (Exception e) {
			Programa.mostrarMensaje("Solo puedes ingresar numeros");
		}
		
	}

	public static float sumar() {
		
		try {
			ingresarDatos(MENSAJE,MENSAJE);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return valor1 + valor2;
	}

	public static float restar() {
		ingresarDatos(MENSAJE,MENSAJE);
		return valor1 - valor2;
	}
	

	public static float multiplicar() {
		ingresarDatos(MENSAJE,MENSAJE);
		return valor1 * valor2;
	}

	public static float dividir() {
		ingresarDatos(MENSAJE,MENSAJE);
		return valor1 / valor2;
	}

	public static float raiz() {
		ingresarDatos(INDICE,RADICADO);
		//return (float) Math.sqrt(valor1);
		return (float) Math.pow(valor2,1/valor1);
	}

	public static boolean entero() {
		boolean ingreso = false;
		ingresarDato(MENSAJE);

		if (valor1 % 1 == 0) {
			ingreso = true;
		}
		return ingreso;
	}

	public static int potencia() {
		ingresarDatos(BASE,EXPONENTE);
		return (int) Math.pow(valor1, valor2);
	}
}
