package com.daniel.Desafio_2;

public class Directo extends Empleado {
	
	private long salario;

	public Directo(String nombre, long salario) {
		super(nombre);
		this.salario = salario;
	}
	
	public double calcularSalud() {
		double salud;
		return salud = this.salario * 0.04;
	}
	
	public double calcularPension() {
		double pension;
		pension = this.salario * 0.05;
		
		return pension; 
	}
	
	@Override
	protected double calcularSalario() {
		double salario;
		salario = this.salario - (this.calcularSalud() + this.calcularPension());
		
		return salario;
	}

	public long getSalario() {
		return salario;
	}
}
