package com.daniel.Desafio_2;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		
		Nomina nomina = new Nomina();
        OUTER:
        while (true) {
            int seleccion = JOptionPane.showOptionDialog(null, "que deseas hacer?", "Bienvenido", JOptionPane.YES_NO_OPTION,
            		JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Agregar Empleado","calcular salarios","Listar Freelance","Listar Directos"}, "Agregar Empleado");
            switch (seleccion) {
                case 0:
                    nomina.agregarEmpleado();
                    break;
                case 1:
                    nomina.calcularNomina();
                    break;
                case 2:
                    nomina.listarFreelance();
                    break;
                case 3:
                    nomina.listarDirectos();
                    break;
                default:
                    break OUTER;
            }
        }
	}

}
