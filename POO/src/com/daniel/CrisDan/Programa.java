package com.daniel.CrisDan;

import java.util.ArrayList;

import javax.crypto.AEADBadTagException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Programa {

	ArrayList<User> usuarios = new ArrayList<>();
	public static float resultado = 0;
	private static final ImageIcon ICONO = new ImageIcon("D:\\Usuario\\Daniel Aristy\\Proyectos IntelliJ\\POO\\POO\\src\\com\\daniel\\CrisDan\\calculadora.png");
	private static final ImageIcon LOGIN = new ImageIcon("D:\\Usuario\\Daniel Aristy\\Proyectos IntelliJ\\POO\\POO\\src\\com\\daniel\\CrisDan\\login.png");
	
	public void registrarse() {
		
		String nombre, apellido, usuario,clave;
		
		do {
			nombre = JOptionPane.showInputDialog("Ingrese su nombre");
		} while ((nombre.equals(null))|| (nombre.isEmpty()));
		
		do {
			apellido = JOptionPane.showInputDialog("Ingrese su apellido");
		} while ((apellido.equals(null))|| (apellido.isEmpty()) );
		
		do {
			usuario = JOptionPane.showInputDialog("Ingrese su usuario");
		} while ((usuario.equals(null))||(usuario.isEmpty()));
		
		do {
			clave = JOptionPane.showInputDialog("Ingrese su clave");
		} while ((clave.equals(null))||(clave.isEmpty()
				));
		
		
		agregar(new User(nombre, apellido, usuario, clave));
	}
	
	public void agregar(User usuario) {
		
		boolean existe = buscarUser(usuario.getUsuario());
		boolean confirm = buscarPassword(usuario.getPassword());
		
		if (!existe && !confirm) {
			usuarios.add(usuario);
			mostrarMensaje("Se añadio exitosamente!");
		}else {
			mostrarMensaje("Ya existe Registros!");
		}
	}
	
	public boolean  buscarUser(String user) {
		boolean siEsta = false;
		
		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getUsuario().equals(user)) {
				siEsta = true;
			}
		}
		return siEsta;
	}
	
	public boolean buscarPassword(String pass) {
		boolean siEsta = false;
		
		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getPassword().equals(pass)) {
				siEsta = true;
			}
		}
		return siEsta;
	}
	
	public static void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void calculator() {
		boolean ingresar = true;
		
		while (ingresar) {
			try {
				
				resultado = 0;
				String opcion = (String) JOptionPane.showInputDialog(null, "Eligue una opcion", "Calculadora",
						JOptionPane.DEFAULT_OPTION, ICONO, new String[] { "Sumar", "Restar", "Multiplicar", "Dividir",
								"Raiz", "Entero", "Elevar Potencia"},
						null);

				switch (opcion) {
				case "Sumar":
					resultado = Calculadora.sumar();
					mostrarMensaje("Resultado de la suma: " + resultado);
					break;
				case "Restar":
					resultado = Calculadora.restar();
					mostrarMensaje("Resultado de la resta: " + resultado);
					break;
				case "Multiplicar":
					resultado = Calculadora.multiplicar();
					mostrarMensaje("Resultado de la multiplicacion: " + resultado);
					break;
				case "Dividir":
					resultado = Calculadora.dividir();
					mostrarMensaje("Resultado de la divicion: " + resultado);
					break;
				case "Raiz":
					resultado = Calculadora.raiz();
					mostrarMensaje("Resultado de la raiz: " + resultado);
					break;
				case "Entero":
					if (Calculadora.entero() == true) {
						mostrarMensaje("Es entero");
					} else {
						mostrarMensaje("No es entero");
					}
					break;
				case "Elevar Potencia":
					resultado = Calculadora.potencia();
					mostrarMensaje("El resultado de la potencia es: " + resultado);
					break;
				}
			} catch (Exception e) {
				mostrarMensaje("Deseas salir");	
				ingresar = false;
			}
		}
	}
	
	public void inicio() {
		
		boolean ingresar = true;
		String usuar, password;
		
		while(ingresar) {
			
			try {
				
				int option = JOptionPane.showOptionDialog(null, "Elige una opcion", "Iniciar Seccion", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE,LOGIN, new String[] { "Login", "Registrarse","Salir" }, null);
				
				switch (option) {
				case 0:
					
					do {
						 usuar = JOptionPane.showInputDialog("Ingrese su usuario");
					} while ((usuar.equals(null))|| (usuar.isEmpty()));
					
					do {
						password = JOptionPane.showInputDialog("Ingrese su constraseña");
					} while ((password.equals(null))||(password.isEmpty()));
					
					if(buscarUser(usuar)== true && buscarPassword(password) == true) {
						calculator();
					}
					else {mostrarMensaje("El usuario o contraseña no existen");}
					break;
					
				case 1:
					registrarse();
					break;
				case 2:
					
					ingresar = false;
				}
			} catch (Exception e) {
				mostrarMensaje("Devuelta a la pagina principal");
			}
			
		} 		
	}
}
