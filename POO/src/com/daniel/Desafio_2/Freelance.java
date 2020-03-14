package com.daniel.Desafio_2;

public class Freelance extends Empleado {

	private long valorHora;
	private double horasTrabajadas;
	
	public Freelance(String nombre, long valorHora, double horasTrabajadas) {
		super(nombre);
		this.valorHora = valorHora;
		this.horasTrabajadas = horasTrabajadas;
	}

	@Override
	protected double calcularSalario() {
		double salario;
		salario = this.valorHora * this.horasTrabajadas;
		
		return salario;
	}
}
