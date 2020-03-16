package com.daniel.Ahorcado;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Juego {

	@XmlElement(name="Palabras")
	ArrayList<String> palabras = new ArrayList<>();
	ArrayList<String> espacios = new ArrayList<>();
	ArrayList<String> repetidas = new ArrayList<>();
	public static boolean cerrar = true;
	public static int VIDAS = 7;
	/**
	 * Generar una constructor vacio para poder que funcion el XML
	 * */
	public Juego() {
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	/**
	 * Generar aleatoriamente una palabra*/
	private int generarRandomPalabras() {
		return (int) Math.floor(Math.random()*palabras.size());
	}

	public void ingresarPalabra() {
		String palabra;
		do {
			palabra = (String) JOptionPane.showInputDialog(null, "Ingrese una palabra");

		} while ((palabra.equals(null)) || (palabra.trim().isEmpty()));
		
		palabras.add(palabra);
	}
	
	public void jugar() {


		if(palabras.isEmpty()){
			mostrarMensaje("Debes tener por lo menos una palabra para iniciar el juego!");
		}else {
			
			String palabra1 = palabras.get(generarRandomPalabras());
			
			for (int i = 0; i < palabra1.length(); i++) {
				espacios.add("_");
			}

			while (cerrar) {
				
				String ingresaLetra;
				
				mostrarMensaje(espacios.toString());
				
				do {
					ingresaLetra = JOptionPane.showInputDialog(null, "Ingresa una letra");
				} while ((ingresaLetra.equals(null))|| ingresaLetra.length() > 1);

				compararCaracteres(ingresaLetra,palabra1);
				verificarVidas(palabra1);
			}
		}
	}

	public void compararCaracteres(String ingresaLetra, String palabra){

		for (int i = 0; i < palabra.length(); i++) {
			if(ingresaLetra.charAt(0) == (palabra.charAt(i))) {

				espacios.set(i, ingresaLetra);
			}else if(!palabra.contains(ingresaLetra)) {
				VIDAS--;
				mostrarMensaje("La letra "+ingresaLetra+" no existe!"+"\nVidas:"+ VIDAS);
				break;
			}
		}
	}

	public void verificarVidas(String palabra){

		if (VIDAS == 0) {
			mostrarMensaje("Has perdido!\n la palabra es: "+palabra);
			cerrar = false;
		}
	}
	
	public void listarPalabras() {

		String palabras = "";
		for (int i = 0; i < this.palabras.size(); i++) {
			palabras += this.palabras.get(i)+"\n";
		}
		
		JOptionPane.showMessageDialog(null, palabras);
	}

	public boolean eliminarPalabra(String palabra) {
		boolean eliminar = false;
		
		int posicion = palabras.indexOf(palabra);
		
		if(posicion == -1) {
			mostrarMensaje("Ocurrio un error al eliminar la palabra");
		}else {
			palabras.remove(posicion);
			mostrarMensaje("Se elimino exitosamente el elemento!");
		}
		return eliminar;
	}
}