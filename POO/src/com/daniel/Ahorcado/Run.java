package com.daniel.Ahorcado;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class Run {

	private static JAXBContext jaxbContext = null;
	private static File bdFile = new File("D:\\Usuario\\Daniel Aristy\\Proyectos IntelliJ\\POO\\POO\\src\\com\\daniel\\Ahorcado\\palabras.xml");
	private static Juego juego = null;
	
	public static void main(String[] args)  {
		
		try {
			
			jaxbContext = JAXBContext.newInstance(Juego.class);
			bdFile.createNewFile();
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			juego = (Juego) unmarshaller.unmarshal(bdFile);// Error en esta linea
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null, "Imposible abrir el archivo de base de datos.");
		}catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Imposible crear el archivo.");
		}
		
		boolean cerrar = true;
		while (cerrar) {
			
			int seleccione = JOptionPane.showOptionDialog(null, "Que deseas hacer?", "Bienvenido", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Ingresar palabra","Jugar","Eliminar palabra"}, "Ingresar palabra");
			
			switch (seleccione) {
			case 0:
				juego.ingresarPalabra();
				guardarCambios();
				
				break;
			case 1:
				juego.jugar();
				break;
			
			case 2:
				juego.listarPalabras();
				
				String palabra= JOptionPane.showInputDialog("Ingresa la palabra la cual vas a eliminar");
				juego.eliminarPalabra(palabra);
				
				guardarCambios();
				
				break;
			
			case JOptionPane.CLOSED_OPTION:
					cerrar = false;
			}
		}
	}
	
	public static void guardarCambios() {
		try {
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(juego, bdFile);
			
		} catch (JAXBException e) {
			JOptionPane.showInternalMessageDialog(null,"Imposible leer el archivo de base de datos.");
		}
	}

}
