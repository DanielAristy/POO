package com.daniel.entrenar;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.DocFlavor.READER;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.daniel.CrisDan.Programa;

@XmlRootElement
public class Game {
	
	public Game() {}
	
	@XmlElement(name="numero")
	public static ArrayList<Integer> usuarios = new ArrayList<>();
	
	public void ingresarDatos() {
		
		try {
			int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese un dato: "));
			usuarios.add(numero);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un valor");
		}
		
	}

}
