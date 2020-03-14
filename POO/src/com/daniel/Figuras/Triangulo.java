package com.daniel.Figuras;

public class Triangulo extends FiguraGeometrica {
	private double base;
	private double altura;
	
	public Triangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	
	@Override
	public double calcularArea() {
		double areaTriangulo;
		
		areaTriangulo = ((this.base * this.altura) / 2);
		
		return areaTriangulo;
	}

	@Override
	public double calcularPerimetro() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
