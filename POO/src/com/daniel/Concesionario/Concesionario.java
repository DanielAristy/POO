package com.daniel.Concesionario;

import javax.swing.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Concesionario {

    private String nombre;
    private  static final int CAPACIDAD_TOTAL = 15;
    public static int cont;
    private static Moto moto;

    @XmlElement(name = "Moto")
    private static ArrayList<Moto> motos = new ArrayList<>();

    public Concesionario() {}

    public boolean buscarId(long serial) {
        boolean verificar = false;

        for (int i = 0; i < motos.size(); i++) {
            if (motos.get(i).getSerial() == serial) {
                verificar = true;
            }
        }
        return verificar;
    }

    public void agregarMoto(Moto moto) {

        boolean existe = buscarId(moto.getSerial());

        if (existe) {
            mensaje("Ya existe");
        } else {
            motos.add(moto);
        }
    }

    public void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
