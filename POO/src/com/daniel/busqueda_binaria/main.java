package com.daniel.busqueda_binaria;

public class main {

	public static void main(String[] args) {
		
		System.out.println(buscarNumero(7));
	}
	
	public static String buscarNumero(int numero) {
		String resultado = "Mal";
		int[] numeros = {1,2,3,4,5,6};
		
		for (int i = 0; i < numeros.length; i++) {
			if(numero == numeros[i]) {
				return resultado = "Verdadero";
			}
		}
		return resultado;	
	}
}
