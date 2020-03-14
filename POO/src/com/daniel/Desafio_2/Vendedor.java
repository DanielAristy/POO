package com.daniel.Desafio_2;

public class Vendedor extends Directo {
	private static double MILLON = 1000000;
	private long ventasDelMes;
	
	public Vendedor(String nombre, long salario, long ventasDelMes) {
		super(nombre, salario);
		this.ventasDelMes = ventasDelMes;
	}
	
	public double calcularComision() {
		double comision;
		
		if (super.getSalario() < MILLON) {
			comision = this.ventasDelMes * 0.03;
		}else {
			comision = this.ventasDelMes * 0.026;
		}
		return comision;
	}
	
	@Override
	protected double calcularSalario() {
        double salario;
        salario  = super.getSalario() + this.calcularComision();
        return salario;
    }
}
