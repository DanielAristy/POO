package com.daniel.MVC;



public class Main {

	public static void main(String[] args) {
		
		Usuario modelo = new Usuario(1, "Daniel", "Profesor", 1500000);
		
		Vista vista = new Vista();
		
		Controlador control = new Controlador(modelo, vista);
		
		control.actualizarVista();
		control.setNombre("Juan");
		control.actualizarVista();
		
	}
}
