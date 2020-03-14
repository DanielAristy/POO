package com.daniel.Concesionario;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class Main {

    private static JAXBContext jaxbContext = null;
    private static File bdFile = new File("D:\\Usuario\\Daniel Aristy\\Proyectos IntelliJ\\POO\\POO\\src\\com\\daniel\\Concesionario\\concesionario.xml");
    private static Concesionario concesionario = null;
    private static Moto moto;

    public static void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static void inicializacion(){
        try {

            jaxbContext = JAXBContext.newInstance(Concesionario.class);
            bdFile.createNewFile();
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            concesionario = (Concesionario) unmarshaller.unmarshal(bdFile);// Error en esta linea
        } catch (JAXBException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Imposible abrir el archivo de base de datos.");
        }catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "Imposible crear el archivo.");
        }
    }

    public static void guardarCambios() {
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(concesionario, bdFile);

        } catch (JAXBException e) {
            JOptionPane.showInternalMessageDialog(null,"Imposible leer el archivo de base de datos.");
        }
    }


    public static void main(String[] args) {

        inicializacion();

        int serial = 0, precio = 0, cilindraje = 0;
        String marca ="";
        Boolean esNueva = true;

        //Ingresar Serial
        do {
            serial = Integer.parseInt(JOptionPane.showInputDialog(null,"Serial"));
            if (serial < 0) mensaje("Debe ingresar un valor positivo");
        }while (serial < 0);

        //Ingresar Marca
        do {
            marca = (String) JOptionPane.showInputDialog(null,"Marca");
        }while (marca.equals(null) || marca.trim().isEmpty());

        //Ingresar Precio
        do {
            precio = Integer.parseInt(JOptionPane.showInputDialog(null,"Precio"));
            if (precio < 0) mensaje("Debe ingresar un valor positivo");
        }while (precio < 0);

        /*Ingresar Cilindraje*/
        do {
            cilindraje = Integer.parseInt(JOptionPane.showInputDialog(null,"Cilindraje"));
            if (cilindraje < 0) mensaje("Debe ingresar un valor positivo");
        }while (cilindraje < 0);

        concesionario.agregarMoto(new Moto(serial,marca,precio,cilindraje,esNueva));
        guardarCambios();

    }
}
