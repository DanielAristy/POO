package com.daniel.Ahorcado;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Juego {
	
	public Juego() {
	}
	
	@XmlElement(name="Palabras")
	ArrayList<String> palabras = new ArrayList<>();
	
	ArrayList<String> espacios = new ArrayList<>();
	ArrayList<String> repetidas = new ArrayList<>();
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	private int generarRandomPalabras() {
		int generarPalabra = (int)Math.floor(Math.random()*palabras.size());
		return generarPalabra;
	}

	public void ingresarPalabra() {
		String palabra;
		do {
			palabra = (String) JOptionPane.showInputDialog(null, "Ingrese una palabra");
			
			
		} while ((palabra.equals(null)) || (palabra.trim().isEmpty()));
		
		palabras.add(palabra);
	}
	
	public void jugar() {
		
		boolean cerrar = true;
		
		int vidas = 7;
		
		if(palabras.isEmpty()){
			mostrarMensaje("Debes tener por lo menos una palabra para iniciar el juego!");
		}else {
			
			String palabra1 = palabras.get(generarRandomPalabras());
			
			for (int i = 0; i < palabra1.length(); i++) {
				if (!palabra1.isEmpty()) {
					espacios.add("_");
				}
			}

			while (cerrar == true) {
				
				String ingresaLetra;
				
				mostrarMensaje(espacios.toString());
				
				do {
					ingresaLetra = JOptionPane.showInputDialog(null, "Ingresa una letra");
					
					
				} while ((ingresaLetra.equals(null))|| ingresaLetra.length() > 1);
				
//				for (int i = 0; i < repetidas.size(); i++) {
//					if(ingresaLetra.charAt(0) == repetidas.get(i).charAt(0)) {
//						mostrarMensaje("Ya ingresaste esta letra!");
//						break;
//					}
//				}
//				
//				repetidas.add(ingresaLetra);
				
				
				for (int i = 0; i < palabra1.length(); i++) {
					if(ingresaLetra.charAt(0) == palabra1.charAt(i)) {
						espacios.set(i, ingresaLetra);
					}else if(!palabra1.contains(ingresaLetra)) {
						vidas--;
						mostrarMensaje("La letra "+ingresaLetra+" no existe!"+"\nVidas:"+ vidas);
						break;
					}
				}
				
				if (vidas == 0) {
					mostrarMensaje("Has perdido!\n la palabra es: "+palabra1);
					cerrar = false;
				}
			}
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