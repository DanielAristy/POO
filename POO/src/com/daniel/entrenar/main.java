package com.daniel.entrenar;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataBase dataBase = new DataBase();
		dataBase.iniciarApp();
		
		
		/*//SAber si se ingresan numeros letraso o las dos juntas
		String cadena = JOptionPane.showInputDialog("ingrese");
		
		boolean digitos = false;
		boolean letra = false;
		for (int i = 0; i < cadena.length(); i++) {
			if(Character.isDigit(cadena.charAt(i))) {
				digitos = true;
			}else {
				letra = true;
			}
				
		}
		
		if(digitos && !letra) {
			JOptionPane.showMessageDialog(null, "Numeros");
		}else if(digitos) {
			JOptionPane.showMessageDialog(null, "Alfanumerico");
		}else {JOptionPane.showMessageDialog(null, "Letras");}*/
	}
}


