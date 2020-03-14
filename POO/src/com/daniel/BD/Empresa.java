package com.daniel.BD;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Empresa {
	
	@XmlElement(name="usuario")
	ArrayList<Usuario> usuarios = new ArrayList<>();
	
	private static final String  TITULO = "Informacion de usuarios";
	private static final String MENSAJE = "¿Que quieres hacer?";
	public Empresa() {
	}
	
	public boolean buscarNombre(String nombre) {
		boolean siEsta = false;
		
		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getNombre().equals(nombre)) {
				siEsta = true;
			}
		}
		return siEsta;
	}
	public void agregar(Usuario usuario) {
		
		boolean existe = buscarNombre(usuario.getNombre());
		
		if (!existe) {
			usuarios.add(usuario);
			mostrarMensaje("Se añadio exitosamente!");
		}else {
			mostrarMensaje("Ya existe Registros!");
		}
	}
	
	public void listaUsuarios() {
		
		if(usuarios.isEmpty()) {
			mostrarMensaje("No existen elementos en la base de datos!");
		}else {
			String usuario = "";
			
			for (int i = 0; i < this.usuarios.size(); i++) {
				usuario += this.usuarios.get(i).getNombre()+" "+this.usuarios.get(i).getApellido()+"\n";
			}
			mostrarMensaje(usuario);
		}
	}
	
	
	public boolean miId(int indentificador) {
		boolean identificar = false;
		
		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getId() == indentificador) {
				identificar = true;
			}
		}
		
		return identificar;
	}

	public boolean cambiarDatos(int idetificacion) {
		
		boolean existe = miId(idetificacion);
		boolean actualizo = false;
		boolean cerrar = true;
		
		if (existe) {
			
			try {
				
				while (cerrar) {
					int opcion =  JOptionPane.showOptionDialog(null, getMensaje(), getTitulo(),JOptionPane.INFORMATION_MESSAGE, JOptionPane.QUESTION_MESSAGE,
							null, new Object[] {"Cambiar Nombre","Cambiar Apellido","Salir"}, null);
					
					switch (opcion) {
					case 0:
						String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
						usuarios.get(posicion(idetificacion)).setNombre(nombre);                                                                                                                                                                                                                                    
						
						break;

					case 1:
							String apellido = JOptionPane.showInputDialog("Ingrese el Apellido");
							usuarios.get(posicion(idetificacion)).setApellido(apellido);
						
						
						break;
						
					case 2:
						cerrar = false;
					}	
				}
				
			} catch (RuntimeException e) {
				mostrarMensaje("Error");
			}
		}else mostrarMensaje("No existe registro!"); 
			
		return actualizo;
	}
	
	public boolean eliminarUsuario(int identificacion) {
		boolean verificar = false;
		
		if(miId(identificacion)) {
			usuarios.remove(posicion(identificacion));
			mostrarMensaje("Se elimino registro!");
			verificar =true;
		}else {
			mostrarMensaje("No existe registro!");
		}
		return verificar;
	}
	
	public int posicion(int posicion) {
		
		int cont =0;
		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getId() == posicion) {
				cont = i;
				break;
			}
		}
		return cont;
	}
	
	public static String getTitulo() {
		return TITULO;
	}

	public static String getMensaje() {
		return MENSAJE;
	}
	
	public static void  mostrarMensaje(String mensaje) {
		 JOptionPane.showMessageDialog(null, mensaje);
	}
}
