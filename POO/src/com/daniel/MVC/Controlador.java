package com.daniel.MVC;

import com.daniel.MVC.Usuario;
import com.daniel.MVC.Vista;


public class Controlador {
	
	private Usuario usuario;
	private Vista vista;
	
	public Controlador(Usuario usuario, Vista vista) {
		this.usuario = usuario;
		this.vista = vista;
	}

	public int getId() {
		return usuario.getId();
	}
	public void setId(int id) {
		this.usuario.setId(id);
	}
	public String getNombre() {
		return usuario.getNombre();
	}
	public void setNombre(String nombre) {
		this.usuario.setNombre(nombre); 
	}
	public String getLabor() {
		return usuario.getLabor();
	}
	public void setLabor(String apellido) {
		this.usuario.setLabor(apellido);
	}
	      
	public void actualizarVista() {
		vista.imprimirDatos(usuario.getId(), usuario.getNombre(), usuario.getLabor(),usuario.getSaldo());
	}
	
	
}
