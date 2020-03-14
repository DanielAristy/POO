package com.daniel.repaso;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class main {
	
	public static void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public static void main(String[] args) {
		
		ArrayList<String> uno_Al_Nueve = new ArrayList<>(Arrays.asList("one","two","three","four","five","six","seven","eight","nine"));
		
		ArrayList<String> diez_Al_Diez_Y_Nueve = new ArrayList<>(Arrays.asList("ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen",
				                                                           "seventeen","eighteen","nineteen"));
		
		ArrayList<String> de_A_Diez = new ArrayList<>(Arrays.asList("twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"));
		
		ArrayList<String> grandes = new ArrayList<>(Arrays.asList("hundred","thousand","million"));
		
		boolean verficar = true;
		int opcion, medida,suma, posicion;
		String cadena1 = null;
		
		while (verficar) {
			
			opcion = JOptionPane.showOptionDialog(null, "Elige una opcion", "Convertir numeros", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE,null, new String[] { "Ingresar numero", "Salir" }, null);
			
			switch (opcion) {
			case 0:
				 do {
					 String cadena = JOptionPane.showInputDialog("Ingrese el numero");
					 cadena1 = cadena;
					 
				} while (Integer.parseInt(cadena1) <= 0);

				medida = cadena1.length();
				
				// si el tama�o es 1
				if(medida==1) {
					mostrarMensaje(""+uno_Al_Nueve.get(Integer.parseInt(cadena1)-1));
				}
				
				// si el tama�o es 2
				if(medida ==2) {
					
					if(Integer.parseInt(cadena1.substring(0, 1)) == 1) {
						//JOptionPane.showMessageDialog(null, tama�o+" "+Integer.parseInt(cadena.substring(0, 1)));
						suma = Integer.parseInt(cadena1.substring(medida - 2 , medida- 1)) + Integer.parseInt(cadena1.substring(medida - 1, medida));
						
						mostrarMensaje(""+diez_Al_Diez_Y_Nueve.get(suma-1));
					}else 
						
						if((Integer.parseInt(cadena1.substring(0, 1))) > 1) {
							
							if ((Integer.parseInt(cadena1.substring(medida - 1, medida))) == 0) {
								
								posicion = Integer.parseInt(cadena1.substring(medida - 2 , medida - 1));
								mostrarMensaje(de_A_Diez.get(posicion - medida));
							}else
								
								if((Integer.parseInt(cadena1.substring(medida- 1, medida))) > 0) {
									
									mostrarMensaje(""+de_A_Diez.get(Integer.parseInt(cadena1.substring(medida - 2, medida - 1))- medida)+"-"+
									uno_Al_Nueve.get(Integer.parseInt(cadena1.substring(medida - 1, medida))- (medida - 1)));
								}
						
						}
				}
				
				// si el tam�o es 3
				break;

			case 1:
				verficar = false;
			}
		}
	}

}
