package com.daniel.BD;


import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Inicio {
	
	//Métodos estáticos para la creación del JAXB

	private static JAXBContext jaxbContext = null;
	private static File bdFile = new File("D:\\Usuario\\Daniel Aristy\\Proyectos IntelliJ\\POO\\POO\\src\\com\\daniel\\BD\\usuarios.xml");
	private static Empresa empresa = null;
	
	private static JPanel panel = new JPanel();
	private static JTextField 	textfieldNombre = new JTextField();
	private static JTextField 	textfieldApellido = new JTextField();
	private static JPasswordField 	textfieldId = new JPasswordField();
	private static JTextField 	textfieldTelefono = new JTextField();

	public static void main(String[] args) {
		
		try {
			
			jaxbContext = JAXBContext.newInstance(Empresa.class);
			bdFile.createNewFile();
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			empresa = (Empresa) unmarshaller.unmarshal(bdFile);// Error en esta linea
			
			panel.setLayout(new GridLayout(4, 2, 7, 7));
			
			String[] option = {"Ingresar usuario","Listar usuarios","CambiarDatos","Eliminar Usuario"};
			
			panel.add(new JLabel("Ingresa el Id"));
			panel.add(textfieldId);
			panel.add(new JLabel("Ingresa el Nombre"));
			panel.add(textfieldNombre);	
			panel.add(new JLabel("Ingresa el Apellido"));
			panel.add(textfieldApellido);
			panel.add(new JLabel("Ingresa el Telefono"));
			panel.add(textfieldTelefono);
			
			
			boolean cerrar = true, verificar = false;
			while (cerrar) {
				
				int opcion =  JOptionPane.showOptionDialog(null, Empresa.getMensaje(), Empresa.getTitulo(), JOptionPane.INFORMATION_MESSAGE,
						JOptionPane.QUESTION_MESSAGE, null, option, null);
				
				switch (opcion) {
				case 0:
						
					do {
						
						try {
							
							JOptionPane.showMessageDialog(null, panel);
							
							empresa.agregar(new Usuario(convertirEntero(textfieldId), textfieldNombre.getText(), textfieldApellido.getText(),
									convertirLargo(textfieldTelefono)));
							
							
							verificar = true;
							
						} catch (Exception e) {
							Empresa.mostrarMensaje("Faltan algunos campos");
							
						}
						
						
					} while (convertirEntero(textfieldId) == 0 || textfieldNombre.getText() == "" || textfieldApellido.getText() == "" || convertirLargo(textfieldTelefono) ==0);
					
					if (verificar == true) {
						guardarCambios();
						limpiarCampos(panel);
					}
					
					break;
					
				case 1:
					
					empresa.listaUsuarios();
					break;
					
				case 2:
					
					int identificacion = 0;
					do {
						try {
							 
							identificacion = Integer.parseInt(JOptionPane.showInputDialog("Id")); 
							
							if (empresa.cambiarDatos(identificacion)) {
								guardarCambios();
							}
							
						} catch (NumberFormatException e) {
							Empresa.mostrarMensaje("Debes ingresar el id para continuar");
						}
					} while (identificacion == 0);
					 
					break;
					
				case 3:
					
					int identificacion1 = 0;
					
					do {
						try {
							identificacion1 = Integer.parseInt(JOptionPane.showInputDialog("Id")); 
							
							if (empresa.eliminarUsuario(identificacion1)) {
								guardarCambios();
							}
						} catch (NumberFormatException e) {
							Empresa.mostrarMensaje("Debes ingresar el id para continuar");
						}
					} while (identificacion1 == 0);
					
					break;
					
				case JOptionPane.CLOSED_OPTION:
					
					cerrar = false;
					guardarCambios();
					break;
		
				}
			}
		
		} catch (JAXBException e) {
			Empresa.mostrarMensaje("Imposible abrir el archivo de base de datos.");
		} catch (IOException e1) {
			Empresa.mostrarMensaje("Imposible crear el archivo.");
		}

	}
	
	public static void guardarCambios() {
		try {
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(empresa, bdFile);
		} catch (JAXBException e) {
			Empresa.mostrarMensaje("Imposible leer el archivo de base de datos.");
		}
	}
	
	public static int convertirEntero(JTextField texto) {
		int numero=0;
		
		try {
		 numero = Integer.parseInt(texto.getText());
		} catch (Exception e) {}
		
		return numero;
		
	}
	public static long convertirLargo(JTextField texto) {
		long numero = 0;
		
		try {
			numero = Long.parseLong(texto.getText());
		} catch (Exception e) {}
		
		return numero;
	}
	
	public static void limpiarCampos(JPanel jPanel){
        for(int i=0; jPanel.getComponents().length>i;i++){
            //Limpia todos los JTextField de un JPanel
            if(jPanel.getComponents()[i]instanceof JTextField){
                ((JTextField)jPanel.getComponents()[i]).setText("");
            }
        }
	}
	
	public static void verficarCampos(JPanel jpanel) {
		
		for (int i = 0; i < jpanel.getComponents().length; i++) {
			if(jpanel.getComponents()[i]instanceof JTextField) {
				if(((JTextField)jpanel.getComponents()[i]).getText() == "") {
					Empresa.mostrarMensaje("Efetivo!");
				}
			}
		}
	}
}
