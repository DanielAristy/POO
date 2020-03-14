package com.daniel.Desafio_2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Nomina {
	private ArrayList<Empleado> empleados = new ArrayList<>();
	
	public void calcularNomina() {
		String nomina = "Empleado Salario\n";
		
		for (Empleado empleado : empleados) {
			if(empleado instanceof Vendedor) {
				nomina = nomina + empleado.getNombre() +" $"+ empleado.calcularSalario()
				+" Comision: $ "+ ((Vendedor) empleado).calcularComision() + "\n";
			}
			nomina = nomina + empleado.getNombre() +" $" + empleado.calcularSalario()+ "\n";
		}
		JOptionPane.showMessageDialog(null, nomina);
	}
	
	public void agregarEmpleado() {
		
		int opciones = JOptionPane.showOptionDialog(null, "Que tipo de empleado desea ingresar?", "Agregar empleado", JOptionPane.YES_OPTION
				, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Freelance","Directo"} , "Freelance");
		
		if (opciones == 0) {
            this.agreagarFreelance();
        } else if (opciones == 1) {
            opciones = JOptionPane.showConfirmDialog(null, "Es vendedor?", "Agregar empleado", JOptionPane.YES_NO_OPTION);
            if (opciones == 0) {
                this.agregarvendedor();
            } else if (opciones == 1) {
                this.agregarDirecto();
            }
        }
		
		JOptionPane.showMessageDialog(null, "Se ha añadido exitosamente un empleado!");
		
	}
	
	private void agregarDirecto() {
        String nombre;
        long salario = 0;

        nombre = JOptionPane.showInputDialog("Nombre de empleado");
        while (true) {
            try {
                salario = Long.parseLong(JOptionPane.showInputDialog("Salario base"));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "por favor ingresa un valor valido");
            }
        }
        empleados.add(new Directo(nombre, salario));
    }
	
	public void agreagarFreelance() {
		String nombre;
		long valorHora = 0;
		double horasLaboradas = 0;
		
		nombre = JOptionPane.showInputDialog("Nombre del empleado");
		
		while (true) {
            try {
                horasLaboradas = Double.parseDouble(JOptionPane.showInputDialog("Cuantas horas ha laborado?"));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "por favor ingresa un valor valido");
            }
        }
        while (true) {
            try {
                valorHora = Long.parseLong(JOptionPane.showInputDialog("Valor hora laborada?"));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "por favor ingresa un valor valido");
            }
        }
        empleados.add(new Freelance(nombre, valorHora, horasLaboradas));
	}
	
	private void agregarvendedor() {
        String nombre;
        long salario = 0, ventas = 0;

        nombre = JOptionPane.showInputDialog("Nombre de empleado");
        while (true) {
            try {
                salario = Long.parseLong(JOptionPane.showInputDialog("Salario base"));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "por favor ingresa un valor valido");
            }
        }
        while (true) {
            try {
                ventas = Long.parseLong(JOptionPane.showInputDialog("Ventas del mes"));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "por favor ingresa un valor valido");
            }
        }
        empleados.add(new Vendedor(nombre, salario, ventas));
    }
	
	public void listarDirectos() {
        String empleadoDirecto = "";
        for (Empleado empleado : empleados) {
            if (empleado instanceof Directo) {
                empleadoDirecto = empleadoDirecto + (empleado.getNombre() + "\n");
            }
        }
        JOptionPane.showMessageDialog(null, empleadoDirecto);
    }

    public void listarFreelance() {
        String empleadoFreelance = "";
        for (Empleado empleado : empleados) {
            if (empleado instanceof Freelance) {
                empleadoFreelance = empleadoFreelance + (empleado.getNombre() + "\n");
            }
        }
        JOptionPane.showMessageDialog(null, empleadoFreelance);
    }

}
