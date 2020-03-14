package com.daniel.recursividad;

import javax.swing.JOptionPane;

public class main {
	
	public static void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	
	public static void main(String[] args) {
		
		int numero =10, resultado = sumarNumeros(numero);
		
		mostrarMensaje("suma: "+ resultado);	
		
		mostrarMensaje("Factorial: "+ factorial(2));
	}
	
	public static int sumarNumeros(int numero) {
		
		int suma = 0; 
		if (numero == 1) {
			return suma = 1;
			
		}else {
			suma =  numero + sumarNumeros(numero -1);
		}
		
		return suma;
		
	}
	
	public static int factorial(int factor) {
		int resultado = 1;
		
		while (factor > 0 ) {
			resultado = resultado* factor;
			factor--;
		}
		
		return resultado;
		
	}
	
	
	
	

}
