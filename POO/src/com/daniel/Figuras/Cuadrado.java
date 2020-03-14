
package com.daniel.Figuras;

public class Cuadrado extends FiguraGeometrica {
	private double lado;

	public Cuadrado(double lado) {
		this.lado = lado;
	}
	
	@Override
	public double calcularArea() {
		double areaCuadrado;
		
		areaCuadrado = this.lado * this.lado;
		return areaCuadrado;
	}
	
	@Override
	public double calcularPerimetro() {
		double perimetroCuadrado;
		
		perimetroCuadrado = this.lado * this.lado;

		return perimetroCuadrado;
	}
}
