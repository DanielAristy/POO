package com.daniel.MVC;



import javax.swing.JOptionPane;

public class Vista {
	
	 public void imprimirDatos(int id, String nombre, String labor, int saldo) {
		
		 JOptionPane.showMessageDialog(null, nombre+" "+ labor+" "+saldo);
	 }
}
