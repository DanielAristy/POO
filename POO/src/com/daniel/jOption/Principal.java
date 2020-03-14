package com.daniel.jOption;

import java.awt.HeadlessException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) throws HeadlessException, MalformedURLException {
//		 String[] numeros = {"1","2","3"};
//		 String nombre = (String) JOptionPane.showInputDialog(null, "Su opcion: ",
//		 "POO", JOptionPane.QUESTION_MESSAGE, null, numeros, null);
//		 JOptionPane.showMessageDialog(null, nombre);
//		 JOptionPane.showMessageDialog(null, "How are you", "POO",
//		 JOptionPane.WARNING_MESSAGE, new ImageIcon(new
//		 URL("http://graffica.info/wp-content/uploads/2017/06/pixabay-banco-imagenes.jpg")));

		int opcion = JOptionPane.showOptionDialog(null, "Elige uno", "POO", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, new String[] { "Sumar", "Restar","Multiplicar", "Dividir" }, null);

		while (true) {
			if (opcion == 0) {
				int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese a: "));
				int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese b: "));
				int resultado = Calculadora.sumar(a, b);
				mostrarMensaje("" + resultado);
			} else if (opcion == 1) {
				int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese a: "));
				int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese b: "));
				int resultado = Calculadora.restar(a, b);
				mostrarMensaje("" + resultado);
			} else if (opcion == 2) {
				int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese a: "));
				int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese b: "));
				int resultado = Calculadora.multiplicar(a, b);
				mostrarMensaje("" + resultado);
			}else if (opcion == 3) {
			int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese a: "));
			int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese b: "));
			int resultado = Calculadora.dividir(a, b);
			mostrarMensaje("" + resultado);
			}
		}
	}
	
	public  static void  mostrarMensaje(String men)
	{
		JOptionPane.showMessageDialog(null, men);	
	}
}
