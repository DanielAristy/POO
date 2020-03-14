package com.daniel.JAXB;

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
	
	
	public void ingresarPalabra() {
		String palabra;
		do {
			palabra = (String) JOptionPane.showInputDialog(null, "Ingrese una palabra");
			
		} while ((palabra.equals(null)) || (palabra.trim().isEmpty()));
		
		palabras.add(palabra);
	}
	
	public void listarPalabras() {
		String palabras = "";
		for (int i = 0; i < this.palabras.size(); i++) {
			palabras += this.palabras.get(i)+"\n";
		}
		
		JOptionPane.showMessageDialog(null, palabras);
	}
}
