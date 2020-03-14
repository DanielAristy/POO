package com.daniel.taller1;

public class Nota {
	private double seguimiento;
	private double parcial;
	private double Final;
	private Asignatura asignatura;
	
	public Nota(Asignatura materia,double seguimiento,double parcial,double Final) {
		this.asignatura = materia;
		this.seguimiento = seguimiento;
		this.parcial = parcial;
		this.Final = Final;
	}
	
	public double calcularFinal() {
		double lanota = (this.seguimiento*0.4)+(this.parcial*0.3)+(this.Final*0.3);
		return lanota;
	}
	
	public double getSeguimiento() {
		return seguimiento;
	}
	public void setSeguimiento(double seguimiento) {
		this.seguimiento = seguimiento;
	}
	public double getParcial() {
		return parcial;
	}
	public void setParcial(double parcial) {
		this.parcial = parcial;
	}
	public double getFinal() {
		return Final;
	}
	public void setFinal(double final1) {
		Final = final1;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	
}
