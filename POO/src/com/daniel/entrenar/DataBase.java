package com.daniel.entrenar;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class DataBase {

	//Metodos estaticos para la creacion de JAXB
	private static JAXBContext jaxbContext = null;
	private static File bdFile = new File("D:\\Usuario\\Daniel Aristy\\Proyectos IntelliJ\\POO\\POO\\src\\com\\daniel\\entrenar\\entrenar.xml");
	private static Game game = null;
	//Cargar imagenes
	//Cargar archivo de base de datos
	private void inicializacion() {
		try {
			jaxbContext = JAXBContext.newInstance(Game.class);
			bdFile.createNewFile();
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			game = (Game) unmarshaller.unmarshal(bdFile);// Error en esta linea
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null, "Imposible abrir el archivo de base de datos.");
		}catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Imposible crear el archivo.");
		  }
	}
				
	private void guardarCambios() {
		try {
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);		
			marshaller.marshal(game, bdFile);
						
		} catch (JAXBException e) {
			JOptionPane.showInternalMessageDialog(null,"Imposible leer el archivo de base de datos.");
		}
	}
	
	public void mensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void iniciarApp() {
		
		inicializacion();
		game.ingresarDatos();
		guardarCambios();
	}
			
			
}
